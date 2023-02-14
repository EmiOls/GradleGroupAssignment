package ui;

import core.GameEngine;
import core.Player;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static ui.Launcher.*;

class LauncherTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testInvalidNumberOfRounds() {
        assertFalse(checkRounds(-1));
        assertFalse(checkRounds(0));
        assertFalse(checkRounds(5));
    }

    @Test
    void testTie() throws IOException {
        Player firstPlayer = new Player("firstPlayer");
        Player secondPlayer = new Player("secondPlayer");
        GameEngine game = new GameEngine(firstPlayer, secondPlayer, 1);
        firstPlayer.setScore(1);
        secondPlayer.setScore(1);
        declareWinner(game);
        assertEquals("Game was a tie, you both scored: 1", outputStreamCaptor.toString().trim());

    }

    @Test
    void testNotTie() throws IOException {
        Player firstPlayer = new Player("firstPlayer");
        Player secondPlayer = new Player("secondPlayer");
        GameEngine game = new GameEngine(firstPlayer, secondPlayer, 1);
        firstPlayer.setScore(1);
        secondPlayer.setScore(2);
        declareWinner(game);
        assertEquals("secondPlayer won with 2 points!", outputStreamCaptor.toString().trim());

    }

}