package model.card;

public enum Value {
    TOW("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("10"),
    QUEEN("10"),
    KING("10"),
    ACE("1");

    private final String value;
    private Value(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
