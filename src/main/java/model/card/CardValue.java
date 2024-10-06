package model.card;

public enum CardValue {
    TOW("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("11"),
    QUEEN("11"),
    KING("11"),
    ACE("1");

    private final String value;
    private CardValue(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
