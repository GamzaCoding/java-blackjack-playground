package controller;

import model.card.CardDeck;
import model.gamer.Dealer;
import model.gamer.Players;

import java.util.List;

public class BlackjackGameSetting {

    public Dealer createDealer(){
        return new Dealer();
    }

    public Players createPlayers(List<String> names){
        return Players.of(names);
    }

}
