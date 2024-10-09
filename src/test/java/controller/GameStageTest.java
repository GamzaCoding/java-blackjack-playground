package controller;

import model.Amount;
import model.Player;
import model.card.CardDeck;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameStageTest {

    private GameStage gameStage;

    @BeforeEach
    public void setUp(){
        gameStage = new GameStage(new CardDeck(),
                Arrays.asList(new Player("minsu",new Amount(10000)),
                        new Player("souji",new Amount(20000))));
    }

    @Test
    @DisplayName("카드 2개 배부 테스트")
    public void giveTowCardToEachPayer(){
        List<Player> playerList = gameStage.getPlayerList();
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);

        gameStage.giveTowCardToEachPlayer();

        assertThat(player1.getPlayerCards().size()).isEqualTo(2);
        assertThat(player2.getPlayerCards().size()).isEqualTo(2);

    }

}
