package org.snakeandladder;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import org.snakeandladder.utils.GameLoader;
import org.snakeandladder.utils.GameSaver;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Board board;
    private final List<Player> players;
    private final Die die;
    private int currentPlayerIndex;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.die = new Die();
        this.currentPlayerIndex = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n" + currentPlayer.getName() + "'s turn. Current position: " + currentPlayer.getPosition());
            System.out.print("Press enter to roll the die or type 'save' to save the game: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("save")) {
                saveGame("game_save.ser");
                System.out.println("Game saved.");
                continue;
            }

            int roll = die.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + roll);

            int newPosition = currentPlayer.getPosition() + roll;
            if (newPosition > board.getSize()) {
                System.out.println(currentPlayer.getName() + " rolled too high and stays at " + currentPlayer.getPosition());
            } else {
                int initialPosition = newPosition;
                newPosition = board.getNewPosition(newPosition);
                if (newPosition < initialPosition) {
                    System.out.println("Oh no! " + currentPlayer.getName() + " got bitten by a snake and moves to " + newPosition);
                } else if (newPosition > initialPosition) {
                    System.out.println("Great! " + currentPlayer.getName() + " climbed a ladder and moves to " + newPosition);
                } else {
                    System.out.println(currentPlayer.getName() + " moves to " + newPosition);
                }

                currentPlayer.setPosition(newPosition);

                if (newPosition == board.getSize()) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    gameWon = true;
                }
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        scanner.close();
    }

    /**
     * To save the current game to the disk so that it can be loaded later to resume the game.
     * @param filename String File name.
     */
    public void saveGame(String filename) {
        GameSaver.saveGame(this, filename);
    }

    /**
     * To load an already saved game to resume playing.
     * @param filename String File name.
     * @return Game
     */
    public static Game loadGame(String filename) {
        return GameLoader.loadGame(filename);
    }
}
