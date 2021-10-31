package com.study.chapter1;

import java.util.Scanner;

public class BodyMassIndex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("키를 입력해주세요.");
        double height = scanner.nextDouble();

        System.out.println("몸무게를 입력해주세요.");
        double weight = scanner.nextDouble();

        double bmi = calculate(height, weight);

        System.out.println(String.format("당신의 BMI는 %.2f입니다.", bmi));
    }

    private static double calculate(double height, double weight) {
        return weight / (height * height) * 10000;
    }
}
