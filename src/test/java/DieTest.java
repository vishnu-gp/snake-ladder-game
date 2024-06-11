import org.junit.Test;
import org.snakeandladder.Die;

import static org.junit.Assert.assertTrue;

public class DieTest {

    @Test
    public void testRoll() {
        Die die = new Die();
        int roll = die.roll();
        assertTrue(roll >= 1 && roll <= 6);
    }
}
