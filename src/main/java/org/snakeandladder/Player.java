package org.snakeandladder;

public class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        // Player starts at 1
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
