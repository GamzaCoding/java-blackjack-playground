package controller;

import model.card.CardDeck;
import model.gamer.Dealer;
import model.gamer.Player;
import model.gamer.Players;
import view.InputView;
import view.OutputView;

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

    }

    private void askBettingAmountToPayers(Players players) {
        players.getPlayers().stream()
                .map(player -> player.setBettingResult(inputView.askBettingAmount(player.getName())))
                .collect(Collectors.toList());
    }

    private void giveCardsPlayersAndDealer(final Players players, final Dealer dealer) {
        players.giveTwoCardEachPlayer(cardDeck);
        dealer.drawTowCard(cardDeck);
    }
}
