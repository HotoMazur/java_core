package phoneNum;

import org.example.tasks.phoneNum.PhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneNumberTests {
    @Test
    public void testDecodeValidInput() {
        String input = "CALLME1234";
        String expected = "(225) 563-1234";
        assertEquals(expected, PhoneNumber.decode(input));
    }

    @Test
    public void testDecodeWithOnlyNumbers() {
        String input = "1234567890";
        String expected = "(123) 456-7890";
        assertEquals(expected, PhoneNumber.decode(input));
    }

    @Test
    public void testDecodeInvalidLength() {
        String input = "12345";
        assertThrows(IllegalArgumentException.class, () -> PhoneNumber.decode(input));
    }

    @Test
    public void testDecodeWithInvalidCharacters() {
        String input = "12345@7890";
        assertThrows(IllegalArgumentException.class, () -> PhoneNumber.decode(input));
    }

    @Test
    public void testDecodeWithMixedCaseLetters() {
        String input = "CallMe1234";
        String expected = "(225) 563-1234";
        assertEquals(expected, PhoneNumber.decode(input));
    }
}
