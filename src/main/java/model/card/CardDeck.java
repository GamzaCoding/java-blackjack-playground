package model.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Collectors;

public class CardDeck {
    private static final String DECK_EMPTY_MESSAGE = "덱에 카드가 더이상 없습니다.";

    // 일급 컬랙션
    private final Stack<Card> cards;

    public CardDeck(){
        this.cards = deckSetting();
        deckShuffle();
    }
    private Stack<Card> deckSetting() {
        return Arrays.stream(Emblem.values())
                .flatMap(emblem ->
                        Arrays.stream(Value.values()).map(value -> Card.of(emblem, value)))
                .collect(Collectors.toCollection(Stack::new));
    }
    public void deckShuffle(){
        Collections.shuffle(cards);
    }

    public Card draw() {
        validateCardDeckEmpty();
        return cards.pop();
    }

    public int size(){
        return cards.size();
    }

    private void validateCardDeckEmpty(){
        if(cards.isEmpty()){
            throw new IllegalStateException(DECK_EMPTY_MESSAGE);
        }
    }
}
