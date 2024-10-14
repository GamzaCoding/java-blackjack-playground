package model.gamer;
import model.card.CardDeck;
import model.card.Cards;

public class Player extends AbstractGamer {
    private final Name name;
    private final Amount amount;

    public Player(String name){
        this.name = new Name(name);
        this.amount = new Amount(0);
    }

    private Player(Name name, Amount resultAmount, Hand hand){
        super(); /// 흐음...
        this.name = name;
        this.amount = resultAmount;
        super.hand = hand;
    }

    @Override
    public Player setBettingResult(final int revenue){
        Amount total = amount.addRevenue(revenue);
        return new Player(name, total, hand);
    }

    public int getAmount() {
        return amount.getAmount();
    }

    public String getName() {
        return name.getName();
    }
}
