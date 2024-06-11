import org.junit.Test;
import org.snakeandladder.Player;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testInitialPosition() {
        Player player = new Player("Alice");
        assertEquals(1, player.getPosition());
    }

    @Test
    public void testSetPosition() {
        Player player = new Player("Bob");
        player.setPosition(10);
        assertEquals(10, player.getPosition());
    }
}
