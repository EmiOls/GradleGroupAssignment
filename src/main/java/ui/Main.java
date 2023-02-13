package ui;

import core.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            GameEngine game = Launcher.gameStartup(input);
            while (!game.checkForGameEnd()) {
                initiateRound(input, game);
                manageQuestions(input, game);
                game.newRoundCheckAndSet();
            }
            Launcher.declareWinner(game);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initiateRound(Scanner input, GameEngine game) {
        System.out.printf("Get ready %s. Press enter when ready", game.getCurrentPlayer().getName());
        input.nextLine();
    }

    public static void manageQuestions(Scanner input, GameEngine game) {
        while (true) {
            Launcher.newQuestion(game);
            game.answerQuestion(input.nextLine());
            if (game.checkForPlayerSwap()) {
                game.swapCurrentPlayer();
                break;
            }
            Launcher.clearScreen();
        }
    }
}