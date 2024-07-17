import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player p1 = new Player(1, "Igor", 1);
    Player p2 = new Player(2, "Hasbick", 2);
    Player p3 = new Player(3, "Bickhas", 2);

    @Test
    public void secondWin() {
        Game game = new Game();
        game.register(p1);
        game.register(p2);

        Assertions.assertEquals(2, game.round(p1.getName(), p2.getName()));
    }

    @Test
    public void firstWin() {
        Game game = new Game();
        game.register(p1);
        game.register(p2);

        Assertions.assertEquals(1, game.round(p2.getName(), p1.getName()));
    }

    @Test
    public void strengthsEqual() {
        Game game = new Game();
        game.register(p3);
        game.register(p2);

        Assertions.assertEquals(0, game.round(p3.getName(), p2.getName()));
    }

    @Test
    public void firstNonExist() {
        Game game = new Game();
        game.register(p2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round(p1.getName(), p2.getName())
        );
    }

    @Test
    public void secondNonExist() {
        Game game = new Game();
        game.register(p1);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round(p1.getName(), p2.getName())
        );
    }
}