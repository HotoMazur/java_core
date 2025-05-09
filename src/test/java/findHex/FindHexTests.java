package findHex;

import org.example.tasks.findHex.FindHex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindHexTests {
    @Test
    void testFindHex_Found() {
        String str = "Hello, this is a test string.";
        String hex = "74657374";
        int result = FindHex.findHex(str, hex);
        assertEquals(15, result);
    }

    @Test
    void testFindHex_NotFound() {
        String str = "Hello, this is a test string.";
        String hex = "6E6F74686578";
        int result = FindHex.findHex(str, hex);
        assertEquals(-1, result);
    }

    @Test
    void testFindHex_EmptyHex() {
        String str = "Hello, this is a test string.";
        String hex = "";
        int result = FindHex.findHex(str, hex);
        assertEquals(0, result);
    }

    @Test
    void testFindHex_EmptyString() {
        String str = "";
        String hex = "74657374";
        int result = FindHex.findHex(str, hex);
        assertEquals(-1, result);
    }

    @Test
    void testFindHex_InvalidHex() {
        String str = "Hello, this is a test string.";
        String hex = "ZZZZ";
        assertThrows(NumberFormatException.class, () -> FindHex.findHex(str, hex));
    }
}
