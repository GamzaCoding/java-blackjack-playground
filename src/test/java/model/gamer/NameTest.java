package model.gamer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {


    @Test
    @DisplayName("정상적인 이름 생성 테스트")
    public void allowedNameTest(){
        assertThatCode(() -> new Name("gamza choi")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("허용되지 않은 이름 입력 예외발생 테스트")
    public void disAllowedNameTest(){
        assertThatThrownBy(() -> new Name("2%$러ㅑ ㄹ")).isInstanceOf(IllegalArgumentException.class);
    }
}
