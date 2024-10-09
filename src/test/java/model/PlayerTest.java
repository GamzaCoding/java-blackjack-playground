package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {

    private Player player;
    @BeforeEach
    public void setUP(){
        this.player = new Player("seok", new Amount(10000));
    }

    @Test
    @DisplayName("마이너스 예산 예외발생 테스트")
    public void minus(){
        assertThatThrownBy(() -> player.setBettingResult(new Amount(-100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Amount.MINUS_AMOUNT);
    }
}
