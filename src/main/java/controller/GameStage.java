package controller;

import model.Player;
import model.card.CardDeck;
import java.util.List;

public class GameStage {
    private final CardDeck cardDeck;
    private final List<Player> playerList;
    public GameStage(CardDeck cardDeck, List<Player> playerList){
        this.cardDeck = cardDeck;
        this.playerList = playerList;
    }
    public void giveTowCardToEachPlayer(){
        playerList.stream()
                .forEach(player -> player.drawTowCard(cardDeck));
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
