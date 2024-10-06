package model.card;

public enum Emblem {
    SPADE("스페이드"),
    HEART("하트"),
    CLOVER("클로버"),
    DIAMOND("다이아몬드");

    private final String emblemName;

    private Emblem(String emblemName){
        this.emblemName = emblemName;
    }
    public String getEmblemName() {
        return emblemName;
    }
}
