package org.snakeandladder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(100);
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        Game game = new Game(board, Arrays.asList(player1, player2));
        game.start();
    }
}
