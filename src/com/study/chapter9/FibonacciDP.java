package com.study.chapter9;

public class FibonacciDP {

    public static int[] fibonacciNumbers = new int[100];

    public static void main(String[] args) {

        for (int i = 0; i <= 8; i++) {
            System.out.print(String.format("%d, ", fibonacci(i)));
        }
    }

    public static int fibonacci(int number) {

        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                fibonacciNumbers[i] = 0;
            } else if (i == 1) {
                fibonacciNumbers[i] = 1;
            } else {
                fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
            }
        }

        return fibonacciNumbers[number];
    }
}
