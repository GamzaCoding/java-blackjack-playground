import model.Card;
import model.CardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardDeckTest {
    private static final int CARD_DECK_MAX_SIZE = 52;

    private CardDeck cardDeck;
    @BeforeEach
    public void setting(){
        this.cardDeck = new CardDeck();
    }
    @Test
    @DisplayName("생성된 카드덱의 사이즈 테스트")
    public void deckSize(){
        assertThat(cardDeck.size()).isEqualTo(CARD_DECK_MAX_SIZE);
    }

    @Test
    @DisplayName("draw 테스트")
    // 추가 보완해야한다.
    public void draw(){
        int beforeDrawDeckSize = cardDeck.size();
        Card card = cardDeck.draw();
        assertThat(cardDeck.size()).isEqualTo(CARD_DECK_MAX_SIZE - 1);
    }
}
