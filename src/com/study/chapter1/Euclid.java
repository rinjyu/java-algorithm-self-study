package com.study.chapter1;

import java.util.Scanner;

public class Euclid {

    public static void main(String[] args) {
        int number1 = inputNumbers();
        int number2 = inputNumbers();
        calculate(number1, number2);
    }

    private static int inputNumbers() {
        System.out.println("숫자를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void calculate(int number1, int number2) {
        while (number1 != number2) {
            if (number1 > number2) {
                number1 -= number2;
            } else {
                number2 -= number1;
            }
        }

        System.out.println(String.format("결과는 %d입니다.", number1));
    }
}
