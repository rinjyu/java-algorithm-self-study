package com.study.chapter9;

public class FibonacciRecDP {

    public static int[] fibonacciNumbers = new int[100];

    public static void initFibonacciNumbers() {

        for (int i = 0; i < fibonacciNumbers.length; i++) {
            fibonacciNumbers[i] = -1;
        }
    }

    public static int fibonacci(int number) {

        System.out.println(String.format("fibonacci(%d)가 호출됨", number));

        if (fibonacciNumbers[number] == -1) {
            if (number == 0) {
                fibonacciNumbers[number] = 0;
            } else if (number == 1) {
                fibonacciNumbers[number] = 1;
            } else {
                fibonacciNumbers[number] = fibonacci(number - 1) + fibonacci(number - 2);
            }
        }

        return fibonacciNumbers[number];
    }

    public static void main(String[] args) {

        initFibonacciNumbers();

        System.out.println(String.format("5번째 피보나치 수 = %d", fibonacci(5)));
    }
}
