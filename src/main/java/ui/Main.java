package ui;

import core.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        GameEngine game = Launcher.gameStartup(input);
        while (true)
        {
            System.out.printf("Get ready %s press enter when ready", game.getCurrentPlayer().getName());
            input.nextLine();
            while (true)
            {
                Launcher.newQuestion(game);
                game.answerQuestion(input.nextLine());
                if (game.checkForPlayerSwap())
                {
                    game.swapCurrentPlayer();
                    break;
                }
            }
            Launcher.clearScreen();
            game.newRoundCheckAndSet();
            if (game.checkForGameEnd())
            {
                Launcher.declareWinner(game);
                break;
            }

        }
    }
}