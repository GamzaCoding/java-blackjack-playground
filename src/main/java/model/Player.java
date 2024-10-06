package model;
public class Player {
    public static final String MINUS_AMOUNT = "소유 금액이 0보다 작습니다.";

    private final String name;
    private final int amount;

    public Player(String name, int amount){
        validateAmount(amount);
        this.name = name;
        this.amount = amount;
    }
    public Player setBettingResult(int resultAmount){
        return new Player(this.name, resultAmount);
    }
    public int getAmount() {
        return amount;
    }
    private void validateAmount(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException(MINUS_AMOUNT);
        }
    }
}
