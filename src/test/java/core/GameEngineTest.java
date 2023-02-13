package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
public class GameEngineTest
{
    @Test
    public void testgetCurrentPlayer() throws IOException {
        Player first = new Player("first");
        GameEngine game = new GameEngine(first, new Player("second"), 1);
        assertEquals(first, game.getCurrentPlayer());

    }
    @Test
    public void testswapCurrentPlayer() throws IOException {
        GameEngine game = new GameEngine(new Player("first"), new Player("second"), 1);
        Player test1 = game.getCurrentPlayer();
        game.swapCurrentPlayer();
        assertNotEquals(test1, game.getCurrentPlayer());
    }
    @Test
    public void testLoadQuestions() throws IOException {
        GameEngine game = new GameEngine(new Player("first"), new Player("second"), 1);
        game.loadQuestions();
        assertNotNull(game.getCountry());
    }
    @Test
    public  void testFail()
    {
        assertEquals(1, 2);
    }
}
