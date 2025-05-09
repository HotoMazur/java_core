package consecutiveNum;

import org.example.tasks.consecutiveNumbers.ConsecutiveNumbers1;
import org.example.tasks.consecutiveNumbers.ConsecutiveNumbers2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsecutiveNumbersTests {

    @Test
    void testConsecutiveNumbers1() {
        assertTrue(ConsecutiveNumbers1.consecutiveNumbers(new int[]{1, 2, 3, 4, 5}));
        assertTrue(ConsecutiveNumbers1.consecutiveNumbers(new int[]{5, 4, 3, 2, 1}));
        assertFalse(ConsecutiveNumbers1.consecutiveNumbers(new int[]{1, 2, 4, 5}));
        assertFalse(ConsecutiveNumbers1.consecutiveNumbers(new int[]{1, 2, 2, 3, 4}));
        assertTrue(ConsecutiveNumbers1.consecutiveNumbers(new int[]{7, 8, 9}));
        assertFalse(ConsecutiveNumbers1.consecutiveNumbers(new int[]{1}));
    }

    @Test
    void testConsecutiveNumbers2() {
        assertTrue(ConsecutiveNumbers2.consecutiveNumbers(new int[]{1, 2, 3, 4, 5}));
        assertTrue(ConsecutiveNumbers2.consecutiveNumbers(new int[]{5, 4, 3, 2, 1}));
        assertFalse(ConsecutiveNumbers2.consecutiveNumbers(new int[]{1, 2, 4, 5}));
        assertFalse(ConsecutiveNumbers2.consecutiveNumbers(new int[]{1, 2, 2, 3, 4}));
        assertTrue(ConsecutiveNumbers2.consecutiveNumbers(new int[]{7, 8, 9}));
        assertFalse(ConsecutiveNumbers2.consecutiveNumbers(new int[]{1}));
    }
}
