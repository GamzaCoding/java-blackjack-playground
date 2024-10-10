package model.gamer;
import model.card.CardDeck;
import model.card.Cards;

public class Player {
    private final Name name;
    private final Amount amount;
    private final Hand hand;

    public Player(String name, Amount amount){
        this.name = new Name(name);
        this.amount = amount;
        this.hand = new Hand(new Cards()); // 이렇게 해도 되나...
    }

    private Player(Name name, Amount resultAmount, Hand hand){
        this.name = name;
        this.amount = resultAmount;
        this.hand = hand;
    }

    public Player setBettingResult(int revenue){
        Amount total = amount.addRevenue(revenue);
        return new Player(name, total, hand);
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

    public Cards getPlayerCards() {
        return hand.getCards();
    }
}
