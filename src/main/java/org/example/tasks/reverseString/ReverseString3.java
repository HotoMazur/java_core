package org.example.tasks.reverseString;

public class ReverseString3 {
    public static String reverseString(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = reverseWord(words[i]);
        }
        return String.join(" ", words);
    }

    private static String reverseWord(String str) {
        char[] chars = str.toCharArray();
        String result = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }
        return result;
    }
}
