package org.snakeandladder.utils;

import org.snakeandladder.Game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GameSaver {
    public static void saveGame(Game game, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
