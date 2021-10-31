package com.study.chapter2;

import java.util.Scanner;

public class SequentialSearchTrace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
        int x, pointer, i;

        System.out.print("x = ");
        x = scanner.nextInt();
        pointer = -1;
        System.out.println(String.format("반복 실행 전 x = %d", x));
        System.out.println(String.format("반복 실행 전 pointer = %d", pointer));

        for (i = 0; i < array.length; i++) {
            if (array[i] == x) {
                pointer = i;
            }

            System.out.println(String.format("반복 실행 중 pointer=%d, i=%d", pointer, i));
        }

        System.out.println(String.format("pointer = %d", pointer));
        System.out.println(String.format("반복 실행 후 pointer=%d, i=%d", pointer, i));
    }
}
