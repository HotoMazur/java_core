package org.example.tasks.findHex;

public class FindHex {
    public static int findHex(String str, String hex){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String s = hex.substring(i, i + 2);
            output.append((char) Integer.parseInt(s, 16));
        }
        return str.indexOf(output.toString());
    }
}
