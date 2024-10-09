package model.card;

import java.util.Objects;

public class Card {
    private final Emblem emblem;
    private final Value value;
    public Card(Emblem emblem, Value value){
        this.emblem = emblem;
        this.value = value;
    }

    public Value getValue(){
        return value;
    }

    public static Card of(Emblem emblem, Value value){
        return new Card(emblem, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return emblem == card.emblem && value == card.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emblem, value);
    }
}
