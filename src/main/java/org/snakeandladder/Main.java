package org.snakeandladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to load a saved game? (yes/no): ");
        String loadResponse = scanner.nextLine();

        Game game;
        if (loadResponse.equalsIgnoreCase("yes")) {
            try {
                game = Game.loadGame("game_save.ser");
                System.out.println("Game loaded successfully.");
                game.start();
                return;
            } catch (Exception e) {
                System.out.println("Failed to load game. Starting a new game.");
            }
        }

        // Initialize board with custom snakes and ladders
        Map<Integer, Integer> snakes = Map.of(16, 6, 47, 26, 49, 11, 56, 53, 62, 19, 64, 60, 87, 24, 93, 73, 95, 75, 98, 78);
        Map<Integer, Integer> ladders = Map.of(1, 38, 4, 14, 9, 31, 21, 42, 28, 84, 36, 44, 51, 67, 71, 91, 80, 100);
        Board board = new Board(100, snakes, ladders);

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter the name of player " + i + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        game = new Game(board, players);
        game.start();
    }
}
