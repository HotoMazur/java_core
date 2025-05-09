package org.example.tasks.pigLatin;

public class PigLatin {
    public static String translate(String str) {
        String first = str.substring(1);
        String second = first + str.charAt(0);
        return second + "ay";
    }
}
