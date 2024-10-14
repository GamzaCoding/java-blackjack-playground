package view;

public class OutputView {
    private static final String ANNOUNCE_TWO_CARD_SITUATION = "에게 2장의 카드를 나눠줬습니다.";
    private static final String WITH_DEALER = "딜러와 ";
    private static final String CARD_OF = "카드: ";
    private static final String DEALER = "딜러 ";
    private static final String BLANK = " ";
    private static final String RESULT = " - 결과: ";
    private static final String DEALER_UNDER_SIXTEEN = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    public void announceTwoCardSituation(String playersName){
        System.out.println(WITH_DEALER + playersName + ANNOUNCE_TWO_CARD_SITUATION);
    }

    public void printPlayerCardState(String playerName, String cards){
        System.out.println(playerName + CARD_OF + cards);
    }

    public void printDealerCardState(String cards){
        System.out.println(DEALER + CARD_OF + cards);
    }

    public void printBlank(){
        System.out.println(BLANK);
    }

    public void printDealerUnderSixteenMessage(){
        System.out.println(DEALER_UNDER_SIXTEEN);
    }

    public void printDealerResult(String cards, int score){
        System.out.println(DEALER + CARD_OF + cards + RESULT + score);
    }

    public void printPlayerResult(String name, String cards, int score){
        System.out.println(name + CARD_OF + cards + RESULT + score);
    }



}



