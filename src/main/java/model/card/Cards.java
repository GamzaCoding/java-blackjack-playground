package model.card;

import model.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    // 일급 컬랙션
    private List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int size(){
        return cards.size();
    }
}
