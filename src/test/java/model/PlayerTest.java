package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {

    private Player player;
    @BeforeEach
    public void setting(){
        this.player = new Player("hyeongSeok", 10000);
    }

    @Test
    @DisplayName("마이너스 예산 예외발생 테스트")
    public void minus(){
        assertThatThrownBy(() -> player.settingBettingResult(-100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Player.MINUS_AMOUNT);
    }
}
