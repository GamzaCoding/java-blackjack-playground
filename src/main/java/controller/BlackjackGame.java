package controller;

import model.card.Card;
import model.card.CardDeck;
import model.card.Cards;
import model.gamer.Dealer;
import model.gamer.Player;
import model.gamer.Players;
import view.InputView;
import view.OutputView;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BlackjackGameSetting blackjackGameSetting;
    private final CardDeck cardDeck;
    public BlackjackGame(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.blackjackGameSetting = new BlackjackGameSetting();
        this.cardDeck = new CardDeck();
    }

    public void gameStart(){
        Players players = blackjackGameSetting.createPlayers(inputView.readPlayerName());
        Dealer dealer = blackjackGameSetting.createDealer();

        askBettingAmountToPayers(players);
        giveCardsPlayersAndDealer(players, dealer);
        printTwoCardState(players);
        printDealerCardState(dealer);
        printPlayersCardState(players);
        takeOneMoreCardToPlayers(players);

    }

    private void takeOneMoreCardToPlayers(Players players) {
        for(Player player : players.getPlayers()){
            takeOneMoreCard(player);
        }

    }
    private void takeOneMoreCard(Player player){
        while (inputView.askTakeOneMoreCard(player.getName()).equals("y")){
            giveOneCardToPlayer(player);
            printPlayerCardsState(player);
        }
    }
    private void printPlayerCardsState(Player player){
        String playerCards =  player.getPlayerCards().getCards().stream()
                .map(Card::getValueAndEmblem)
                .reduce((n1,n2) -> n1 + ", " + n2)
                .get();
        outputView.printPlayerCardState(player.getName(), playerCards);
        outputView.printBlank();

    }

    private void giveOneCardToPlayer(Player player) {
        player.drawOneCard(cardDeck);
    }

    private void printDealerCardState(Dealer dealer) {
        String dealerCards = dealer.getDealerCards().getCards().stream()
                .map(Card::getValueAndEmblem)
                .reduce((n1, n2) -> n1 + ", " + n2)
                .get();

        outputView.printDealerCardState(dealerCards);
    }

    private void printPlayersCardState(Players players) {
        List<String> playersName = players.getPlayers().stream()
                .map(Player::getName)
                .collect(Collectors.toList());

        List<String> playersCards = players.getPlayers().stream()
                        .map(Player::getPlayerCards)
                .map(Cards::getCards)
                        .map(cards -> cards.stream()
                                .map(Card::getValueAndEmblem)
                                .reduce((n1, n2) -> n1 + ", " + n2)
                                .get())
                                .collect(Collectors.toList());

        twoListHashMap(playersName, playersCards).entrySet().stream()
                .forEach(player -> outputView.printPlayerCardState(player.getKey(), player.getValue()));

        outputView.printBlank();
    }

    private HashMap<String, String> twoListHashMap(List<String> playersName, List<String> playersCards){
        HashMap<String, String> nameAndCards = new HashMap<>();
        for(int i = 0; i < playersName.size(); i++){
            nameAndCards.put(playersName.get(i), playersCards.get(i));
        }
        return nameAndCards;
    }

    private void printTwoCardState(Players players) {
        String playersName = players.getPlayers().stream()
                .map(Player::getName)
                .reduce((n1, n2) -> n1 + ", " + n2)
                .get();

        outputView.announceTwoCardSituation(playersName);
    }

    private void askBettingAmountToPayers(Players players) {
        players.getPlayers().stream()
                .map(player -> player.setBettingResult(inputView.askBettingAmount(player.getName())))
                .collect(Collectors.toList());
        outputView.printBlank();

    }

    private void giveCardsPlayersAndDealer(final Players players, final Dealer dealer) {
        players.giveTwoCardEachPlayer(cardDeck);
        dealer.drawTowCard(cardDeck);
    }
}
