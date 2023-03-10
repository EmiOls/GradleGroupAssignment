package core;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        answers = TextFileOps.createAnswerMap("capitals.txt");
    }
    public void loadQuestions() throws IOException {
        List<String> countriesList = TextFileOps.createCountryList("capitals.txt");
        Set<String> temp = new HashSet<>();
        while (temp.size() < 5 * rounds) {
            int i = ThreadLocalRandom.current().nextInt(countriesList.size());
            temp.add(countriesList.get(i));
        }

        Iterator<String> it =  temp.iterator();
        for(int i = 0; i < rounds; i++)
        {
            List<String> roundSet = new ArrayList<>();
            for(int j = 0; j < 5; j++)
            {
                if(it.hasNext())
                {
                    roundSet.add(it.next());
                    it.remove();
                }
            }
            question.add(roundSet);
        }
    }
    public boolean checkForPlayerSwap()
    {
        if(currentGuess == 5)
        {
            currentGuess = 0;
            return true;
        }
        return false;
    }
    public void newRoundCheckAndSet()
    {

        if(currentPlayer == playerOne)
        {
            currentRound++;
        }
    }
    public String getCountry()
    {
        String country = question.get(currentRound).get(currentGuess);
        currentGuess++;
        currentCountry = country;
        return country;
    }
    public void answerQuestion(String nextLine)
    {

        if(answers.get(currentCountry).equalsIgnoreCase(nextLine))
        {
            currentPlayer.setScore(currentPlayer.getScore() + 1);
        }
    }
    public void swapCurrentPlayer()
    {
        if (currentPlayer == playerOne)
        {
            currentPlayer = playerTwo;
        }
        else
        {
            currentPlayer = playerOne;
        }
    }

    public Player getResult()
    {
        if(playerOne.getScore() > playerTwo.getScore())
        {
            return playerOne;
        }
        else if(playerOne.getScore() < playerTwo.getScore())
        {
            return playerTwo;
        }
        return new Player("TIE");
    }


    public boolean checkForGameEnd()
    {
        // currentRound starts at 0 rounds starts at 1
        if(currentRound == rounds)
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