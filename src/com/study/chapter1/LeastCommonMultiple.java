package com.study.chapter1;

import java.util.Scanner;

public class LeastCommonMultiple {

    public static void main(String[] args) {
        int number1 = inputNumbers();
        int number2 = inputNumbers();
        int gcd = gcd(number1, number2);
        int lcm = (number1 * number2) / gcd;
        System.out.println(String.format("%d와 %d의 최소공배수는 %d입니다.",
                number1, number2, lcm));
    }

    private static int inputNumbers() {
        System.out.println("숫자를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int gcd(int number1, int number2) {
        while (number1 % number2 != 0) {
            int mod = number1 % number2;
            number1 = number2;
            number2 = mod;
        }

        return number2;
    }
}
