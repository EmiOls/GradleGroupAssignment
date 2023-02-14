package ui;

import core.GameEngine;
import core.Player;

import java.io.IOException;
import java.util.Scanner;

public class Launcher {

    // This method asks the user for player names, number of rounds then makes an
    // instance of GameEngine and returns it.
    public static GameEngine gameStartup() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("-----Question Game v0.1a-----");
        System.out.print("Player 1 name: ");
        String playerOneName = input.nextLine();
        System.out.print("Player 2 name: ");
        String playerTwoName = input.nextLine();
        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);
        System.out.println("How many rounds would you like to play? (5 questions per round)");
        int rounds = input.nextInt();
        input.nextLine();
        while (!checkRounds(rounds)) {
            System.out.println("You must enter a number between 1 and 4.");
            rounds = input.nextInt();
            input.nextLine();
        }
        GameEngine game = new GameEngine(playerOne, playerTwo, rounds);
        game.loadQuestions();
        input.close();
        return game;
    }

    // This method is used to check if the entered number of rounds are
    // allowed.(Min:1 Max:4)
    public static boolean checkRounds(int rounds) {
        if (rounds >= 1 && rounds <= 4) {
            return true;
        }
        return false;
    }

    // This method declares the winner.
    public static void declareWinner(GameEngine game) {
        Player winner = game.getResult();
        if (winner.getName().equals("TIE")) {
            System.out.printf("Game was a tie, you both scored: %d", game.getPlayerOne().getScore());
        } else {
            System.out.printf("%s won with %d points!", winner.getName(), winner.getScore());
        }
    }

    // This method prints a new question.
    public static void newQuestion(GameEngine game) {
        System.out.printf("What is the capital of %s? \n", game.getCountry());
    }

    public static void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

}
