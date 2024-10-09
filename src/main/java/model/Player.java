package model;
import model.card.CardDeck;
import model.card.Cards;
import model.card.Name;

public class Player {
    private final Name name;
    private final Amount amount;
    private final Hand hand;

    public Player(String name, Amount amount){
        this.name = new Name(name);
        this.amount = amount;
        this.hand = new Hand(new Cards()); // 이렇게 해도 되나...
    }

    public Player setBettingResult(Amount resultAmount){
        return new Player(name.getName(), resultAmount);  // 이렇게 하면 hand가 이어지지 않음...
    }

    public void drawTowCard(CardDeck cardDeck) {
        hand.add(cardDeck.draw());
        hand.add(cardDeck.draw());
    }

    public void drawOneCard(CardDeck cardDeck){
        hand.add(cardDeck.draw());
    }

    public int getAmount() {
        return amount.getAmount();
    }

    public Hand getPlayerCards() {
        return hand;
    }
}
