package org.example.tasks.reverseOnlyLetter;

import org.example.tasks.reverseString.ReverseString1;

public class ReverseOnlyLetters {
    public static String reverseString(String str){
        StringBuilder reversed = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                reversed.append(c);
            }
        }
        String reverse = ReverseString1.reverseString(String.valueOf(reversed));

        StringBuilder result = new StringBuilder();
        int letterIndex = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(reverse.charAt(letterIndex++));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
