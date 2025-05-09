package org.example.tasks.consecutiveNumbers;

import java.util.*;

public class ConsecutiveNumbers2 {
    public static boolean consecutiveNumbers(int[] n) {
        if (n.length == 0 || n.length == 1) return false;
        SortedSet<Integer> set = new TreeSet<>();
        for (int num: n){
            set.add(num);
        }
        if (set.size() == n.length){
            return set.getLast() - set.getFirst() == set.size() - 1;
        }
        return false;
    }
}
