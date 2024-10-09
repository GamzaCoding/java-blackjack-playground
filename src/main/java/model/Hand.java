package model;

import model.card.Card;
import model.card.Cards;

public class Hand {

    private Cards cards;
    public Hand(Cards cards){
        this.cards = cards;
    }
    public void add(Card card){
        cards.addCard(card);
    }
    public int size(){
        return cards.size();
    }
}
