package model.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

public class CardDeck {
    // 일급 컬랙션
    private final Stack<Card> cards;

    public CardDeck(){
        this.cards = deckSetting();
        deckShuffle();
    }
    private Stack<Card> deckSetting() {
        return Arrays.stream(Emblem.values())
                .flatMap(emblem ->
                        Arrays.stream(CardValue.values()).map(cardValue -> Card.of(emblem, cardValue)))
                .collect(Collectors.toCollection(Stack::new));
    }
    public void deckShuffle(){
        Collections.shuffle(cards);
    }

    public Card draw(){
        return cards.pop();
    }

    public int size(){
        return cards.size();
    }
}
