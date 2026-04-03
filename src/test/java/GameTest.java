import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private void assertIlligalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            Assertions.fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    void throwIlligalArgumentExceptionInvalidInput() {
        assertIlligalArgument(null);
        assertIlligalArgument("12");
        assertIlligalArgument("1234");
        assertIlligalArgument("12s");
        assertIlligalArgument("121");
    }

    @Test
    void returnSolvedResultIfMatchedNumber() {
        game.question = "123";
        GuessResult result = game.guess("123");

        assertThat(result).isNotNull();
        assertThat(result.solved).isEqualTo(true);
        assertThat(result.strikes).isEqualTo(3);
        assertThat(result.balls).isEqualTo(0);


    }
}