package model;

import model.card.CardDeck;
import model.card.Cards;
import model.gamer.Amount;
import model.gamer.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {

    private Player player;
    private CardDeck deck;
    @BeforeEach
    public void setUP(){
        this.player = new Player("seok", new Amount(10000));
        this.deck = new CardDeck();
    }

    @Test
    @DisplayName("마이너스 예산 예외발생 테스트")
    public void minus(){
        assertThatThrownBy(() -> player.setBettingResult(-100000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Amount.MINUS_AMOUNT);
    }

    @Test
    @DisplayName("배팅 수익 추가 기능 테스트")
    public void addRevenue(){
        Player resultPlayer = player.setBettingResult(20000);
        assertThat(resultPlayer.getAmount()).isEqualTo(30000);
    }
    @Test
    @DisplayName("카드 2장 드로우 기능 테스트")
    public void drawTwoCard(){
        player.drawTowCard(deck);
        Cards cards = player.getPlayerCards();

        assertThat(cards.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("카드 1장 드로우 기능 테스트")
    public void drawCard(){
        player.drawOneCard(deck);
        Cards cards = player.getPlayerCards();

        assertThat(cards.size()).isEqualTo(1);
    }
}
