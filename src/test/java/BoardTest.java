import org.junit.Test;

import org.snakeandladder.Board;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class BoardTest {

    @Test
    public void testGetNewPositionWithSnake() {
        Map<Integer, Integer> snakes = Map.of(16, 6);
        Map<Integer, Integer> ladders = Map.of();
        Board board = new Board(100, snakes, ladders);

        int newPosition = board.getNewPosition(16);
        assertEquals(6, newPosition);
    }

    @Test
    public void testGetNewPositionWithLadder() {
        Map<Integer, Integer> snakes = Map.of();
        Map<Integer, Integer> ladders = Map.of(4, 14);
        Board board = new Board(100, snakes, ladders);

        int newPosition = board.getNewPosition(4);
        assertEquals(14, newPosition);
    }

    @Test
    public void testGetNewPositionWithoutSnakeOrLadder() {
        Map<Integer, Integer> snakes = Map.of();
        Map<Integer, Integer> ladders = Map.of();
        Board board = new Board(100, snakes, ladders);

        int newPosition = board.getNewPosition(10);
        assertEquals(10, newPosition);
    }
}
