package model;

import model.card.CardDeck;
import model.card.Cards;

public class Player {
    public static final String MINUS_AMOUNT = "소유 금액이 0보다 작습니다.";

    private final String name;
    private final int amount;
    private Cards playerCards;

    public Player(String name, int amount){
        validateAmount(amount);
        this.name = name;
        this.amount = amount;
        playerCards = new Cards();
    }
    public Player setBettingResult(int resultAmount){
        return new Player(this.name, resultAmount);
    }

    public void drawTowCard(CardDeck cardDeck) {
        playerCards.setCards(cardDeck.draw());
        playerCards.setCards(cardDeck.draw());
    }

    public int getAmount() {
        return amount;
    }

    public Cards getPlayerCards() {
        return playerCards;
    }

    private void validateAmount(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException(MINUS_AMOUNT);
        }
    }
}
