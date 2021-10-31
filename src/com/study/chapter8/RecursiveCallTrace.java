package com.study.chapter8;

public class RecursiveCallTrace {

    public static void main(String[] args) {

        int answer = factorial(5);
        System.out.println(String.format("%d", answer));
    }

    public static int factorial(int number) {

        System.out.println(String.format("factorial(%d)이(가) 호출됨", number));
        if (number == 0) {
            System.out.println(String.format("factorial(%d)이 1을 반환함", number));
            return 1;
        } else {
            int result = number * factorial(number - 1);
            System.out.println(String.format("factorial(%d)이(가) %d를 반환함", number, result));
            return result;
        }
    }
}
