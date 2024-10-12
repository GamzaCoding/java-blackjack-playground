package model.gamer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AmountTest {

    @Test
    @DisplayName("정상적인 예산 예외 테스트")
    public void amountTest(){
        assertThatCode(() -> new Amount(100)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("마이너스 예산 예외 테스트")
    public void minusTest(){
        assertThatThrownBy(() -> new Amount(-100)).isInstanceOf(IllegalArgumentException.class);
    }
}
