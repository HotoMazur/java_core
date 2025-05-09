package org.example.tasks.consecutiveNumbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ConsecutiveNumbers1 {
    public static boolean consecutiveNumbers(int[] n) {
        return Arrays.stream(n)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.minBy(Comparator.naturalOrder()),
                        (count, minOpt) -> count == n.length && n.length > 1 &&
                                minOpt.isPresent() &&
                                Arrays.stream(n)
                                        .distinct()
                                        .sorted()
                                        .allMatch(i -> i >= minOpt.get() &&
                                                i <= minOpt.get() + n.length - 1 &&
                                                i == minOpt.get() + (i - minOpt.get()))
                ));


    }
}
