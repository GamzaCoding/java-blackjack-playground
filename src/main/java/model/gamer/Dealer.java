package model.gamer;

import model.card.CardDeck;
import model.card.Cards;
import model.gamer.Hand;

public class Dealer {
    private final Hand hand;
    private final Amount amount;
    public Dealer(){
        this.hand = new Hand(new Cards());
        this.amount = new Amount(0);
    }
    public void drawTowCard(CardDeck cardDeck) {
        hand.add(cardDeck.draw());
        hand.add(cardDeck.draw());
    }
    public void drawOneCard(CardDeck cardDeck){
        hand.add(cardDeck.draw());
    }

}
