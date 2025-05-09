package org.example.tasks.consecutiveNumbers;

import java.util.*;

public class ConsecutiveNumbers2 {
    public static boolean consecutiveNumbers(Integer[] n) {
        if (n.length == 0 || n.length == 1) return false;
        SortedSet<Integer> set = new TreeSet<>(List.of(n));
        if (set.size() == n.length){
            return set.getLast() - set.getFirst() == set.size() - 1;
        }
        return false;
    }
}
