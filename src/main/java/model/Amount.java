package model;

public class Amount {
    public static final String MINUS_AMOUNT = "0 이하의 금액은 불가능합니다.";
    private int amount;
    public Amount(int amount){
        validateAmount(amount);
        this.amount = amount;
    }
    private void validateAmount(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException(MINUS_AMOUNT);
        }
    }

    public int getAmount() {
        return amount;
    }
}
