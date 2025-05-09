package org.example.tasks.reverseString;

import java.util.Stack;

public class ReverseString2 {
    public static String reverseString(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++){
            words[i] = reverseWord(words[i]);
        }
        return String.join(" ", words);
    }

    private static String reverseWord(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += stack.pop();
        }
        return result;
    }
}
