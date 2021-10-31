package com.study.chapter1;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        int user = user();
        int computer = computer();
        System.out.println(String.format("결과는 %s입니다.", result(user, computer)));
    }

    private static int computer() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    private static int user() {
        int user = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("가위(1), 바위(2), 보(3) 중 하나를 입력해주세요.");
            user = scanner.nextInt();
        } while (!(user > 0 && user < 4));
        return user;
    }

    private static String result(int user, int computer) {
        if (user > computer) {
            return "사용자 승리";
        } else if (user == computer) {
            return "무승부";
        } else {
            return "사용자 패배";
        }
    }
}
