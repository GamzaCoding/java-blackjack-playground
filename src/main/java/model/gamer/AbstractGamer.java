package model.gamer;

import model.card.CardDeck;

public abstract class AbstractGamer {
    protected Hand hand;
    public AbstractGamer(){
        this.hand = new Hand();
    }

    public void drawTowCard(CardDeck cardDeck) {
        hand.add(cardDeck.draw());
        hand.add(cardDeck.draw());
    }

    public void drawOneCard(CardDeck cardDeck){
        hand.add(cardDeck.draw());
    }

    abstract AbstractGamer setBettingResult(int revenue);


}
