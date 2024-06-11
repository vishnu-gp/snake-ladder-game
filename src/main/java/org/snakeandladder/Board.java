package org.snakeandladder;

import java.io.Serializable;
import java.util.Map;

public class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int size;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    /**
     * To get the new position of the player in the board considering the presence of snakes and ladders.
     * @param position int Current position.
     * @return int New position.
     */
    public int getNewPosition(int position) {
        if (snakes.containsKey(position)) {
            return snakes.get(position);
        } else if (ladders.containsKey(position)) {
            return ladders.get(position);
        }
        return position;
    }
}
