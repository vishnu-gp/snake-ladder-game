package org.snakeandladder;

import java.io.Serializable;
import java.util.Random;

public class Die implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Random random;

    public Die() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
