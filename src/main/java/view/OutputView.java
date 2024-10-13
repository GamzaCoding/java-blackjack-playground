package view;

public class OutputView {
    private static final String ANNOUNCE_TWO_CARD_SITUATION = "에게 2장의 카드를 나눠줬습니다.";
    private static final String WITH_DEALER = "딜러와 ";
    private static final String CARD_OF = "카드: ";
    private static final String DEALER = "딜러 ";
    private static final String BLANK = " ";

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

}



