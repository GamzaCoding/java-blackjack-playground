package model.gamer;
import model.card.CardDeck;

public class Dealer extends AbstractGamer {
    private final Hand hand;
    private final Amount amount;
    public Dealer(){
        this.amount = new Amount(0);
        this.hand = new Hand();
    }
    private Dealer(Amount resultAmount, Hand hand){
        this.amount = resultAmount;
        this.hand = hand;
    }
    public void drawTowCard(CardDeck cardDeck) {
        hand.add(cardDeck.draw());
        hand.add(cardDeck.draw());
    }
    public void drawOneCard(CardDeck cardDeck){
        hand.add(cardDeck.draw());
    }
    @Override
    public Dealer setBettingResult(final int revenue){
        Amount total = amount.addRevenue(revenue);
        return new Dealer(total, hand);
    }

}
