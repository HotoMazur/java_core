package org.example.tasks.consecutiveNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConsecutiveNumbers2 {
    public static boolean consecutiveNumbers(int[] n) {
        Set<Integer> set = new HashSet<>();
        for (int num: n){
            set.add(num);
        }
        if (set.size() == n.length){
            List<Integer> list = new ArrayList<>(set);
            for (int i = 1; i < list.size(); i++){
                if (list.get(i) != list.get(i - 1) + 1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
