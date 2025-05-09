package org.example.tasks.reverseString;

public class ReverseString1 {

    public static String reverseString(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = reverseWord(words[i]);
        }
        return String.join(" ", words);
    }

    private static String reverseWord(String str) {
        String result = "";
        for (int i = str.length(); i > 0; i--) {
            result += str.charAt(i-1);
        }
        return result;
    }
}
