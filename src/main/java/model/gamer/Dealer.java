package model.gamer;
import model.card.CardDeck;
import model.card.Cards;

public class Dealer extends AbstractGamer {
    private final Amount amount;
    public Dealer(){
        super();
        this.amount = new Amount(0);
    }
    private Dealer(Amount resultAmount, Hand hand){
        this.amount = resultAmount;
        super.hand = hand;
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
