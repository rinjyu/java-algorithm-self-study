package com.study.chapter9;

public class FibonacciRec {

    public static void main(String[] args) {

        int number;
        for (number = 0; number <= 8; number++) {
            System.out.println(String.format("%d", fibonacci(number)));
        }
    }

    public static int fibonacci(int number) {

        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
