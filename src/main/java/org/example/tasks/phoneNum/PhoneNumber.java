package org.example.tasks.phoneNum;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
    private static final Map<Character, Character> PHONE_NUMBER_MAP = new HashMap<>();

    static {
        putLetters(",.?!", '1');
        putLetters("ABC", '2');
        putLetters("DEF", '3');
        putLetters("GHI", '4');
        putLetters("JKL", '5');
        putLetters("MNO", '6');
        putLetters("PQRS", '7');
        putLetters("TUV", '8');
        putLetters("WXYZ", '9');
    }

    private static void putLetters(String letters, Character number) {
        for (char letter: letters.toCharArray()) {
            PHONE_NUMBER_MAP.put(letter, number);
        }
    }

    public static String decode(String str) {
        if (str.length() != 10) throw new IllegalArgumentException("Input must be exactly 10 characters long.");
        char[] chars = str.toUpperCase().toCharArray(); // Normalize to uppercase
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                Character mappedChar = PHONE_NUMBER_MAP.get(c);
                if (mappedChar == null) {
                    throw new IllegalArgumentException("Invalid character: " + c);
                }
                chars[i] = mappedChar;
            } else if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        StringBuilder result = new StringBuilder(String.valueOf(chars));
        result.insert(0, "(");
        result.insert(4, ") ");
        result.insert(9, "-");
        return result.toString();
    }
}
