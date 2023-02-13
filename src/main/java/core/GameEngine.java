package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameEngine {

    private Player currentPlayer;
    private int currentRound;
    private int currentGuess;

    private Player playerOne;
    private Player playerTwo;
    private int rounds;
    private Map<String, String> answers;
    private List<List<String>> question;
    private String currentCountry;

    public GameEngine(Player playerOne, Player playerTwo, int rounds) throws IOException {
        question = new ArrayList<>();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.rounds = rounds;
        currentRound = 0;
        currentGuess = 0;
        currentPlayer = playerOne;
        // answers = TextFileOps
    }
    public boolean checkForGameEnd()
    {
        if(currentRound == rounds && currentPlayer == playerOne)
        {
            return true;
        }
        return false;
    }
    public Player getPlayerOne() {
        return playerOne;
    }
    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}