package model.gamer;

import model.card.Card;
import model.card.Cards;

public class Hand {

    private Cards cards;
    public Hand(){
        this.cards = new Cards();
    }
    public void add(Card card){
        cards.addCard(card);
    }

    public Cards getCards() {
        return cards;
    }

    public int size(){
        return cards.size();
    }
}
