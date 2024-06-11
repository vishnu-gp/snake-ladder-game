package org.snakeandladder;

import java.util.List;
import java.util.Scanner;

public class Game {
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
            System.out.println(currentPlayer.getName() + "'s turn. Current position: " + currentPlayer.getPosition());
            System.out.print("Press enter to roll the die...");
            scanner.nextLine();

            int roll = die.roll();
            System.out.println(currentPlayer.getName() + " rolled a " + roll);

            int newPosition = currentPlayer.getPosition() + roll;
            if (newPosition > board.getSize()) {
                System.out.println(currentPlayer.getName() + " rolled too high and stays at " + currentPlayer.getPosition());
            } else {
                newPosition = board.getNewPosition(newPosition);
                System.out.println(currentPlayer.getName() + " moves to " + newPosition);

                if (newPosition == board.getSize()) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    gameWon = true;
                }

                currentPlayer.setPosition(newPosition);
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        scanner.close();
    }
}
