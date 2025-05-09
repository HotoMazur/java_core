package reverseOnlyLetters;

import org.example.tasks.reverseOnlyLetter.ReverseOnlyLetters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseOnlyLettersTests {
    @Test
    void testReverseOnlyLetters_AllLetters() {
        String input = "abcde";
        String expected = "edcba";
        assertEquals(expected, ReverseOnlyLetters.reverseString(input));
    }

    @Test
    void testReverseOnlyLetters() {
        String input = "ez56d";
        String expected = "dz45e";
        assertEquals(expected, ReverseOnlyLetters.reverseString(input));
    }

    @Test
    void testReverseOnlyLetters_WithNonLetters() {
        String input = "a-bC-dEf-ghIj";
        String expected = "j-Ih-gfE-dCba";
        assertEquals(expected, ReverseOnlyLetters.reverseString(input));
    }

    @Test
    void testReverseOnlyLetters_OnlyNonLetters() {
        String input = "1234-5678";
        String expected = "1234-5678";
        assertEquals(expected, ReverseOnlyLetters.reverseString(input));
    }

    @Test
    void testReverseOnlyLetters_EmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, ReverseOnlyLetters.reverseString(input));
    }

    @Test
    void testReverseOnlyLetters_SingleLetter() {
        String input = "a";
        String expected = "a";
        assertEquals(expected, ReverseOnlyLetters.reverseString(input));
    }

    @Test
    void testReverseOnlyLetters_SingleNonLetter() {
        String input = "1";
        String expected = "1";
        assertEquals(expected, ReverseOnlyLetters.reverseString(input));
    }
}
