package com.study.chapter8;

public class RecursiveCall {

    public static void main(String[] args) {

        int answer = factorial(5);
        System.out.println(String.format("%d", answer));
    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
