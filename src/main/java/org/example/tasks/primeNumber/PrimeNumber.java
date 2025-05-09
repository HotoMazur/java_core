package org.example.tasks.primeNumber;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static List<Integer> prime(int[] numbers) {
        List<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    private static boolean isPrime(int number){
        for (int i = 2; i <= number/2; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
