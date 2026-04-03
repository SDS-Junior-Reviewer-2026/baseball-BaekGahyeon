import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
            fail();
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
    }
}