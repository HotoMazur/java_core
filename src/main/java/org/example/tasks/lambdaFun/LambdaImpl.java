package org.example.tasks.lambdaFun;

public class LambdaImpl {
    LambdaOdd lambdaOdd = n -> n % 2 != 0;


    LambdaPrime lambdaPrime = (n) -> {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    };


    LambdaPalindrome palindrome = (str) -> {
        String reversed = new StringBuilder(str).reverse().toString();
        return reversed.equals(str);
    };
}
