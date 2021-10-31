package com.study.chapter2;

import java.util.Scanner;

public class SequentialSearch {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
        int x, pointer, i;

        System.out.print("x = ");
        x = scanner.nextInt();
        pointer = -1;

        for (i = 0; i < array.length && pointer == -1; i++) {
            if (array[i] == x) {
                pointer = i;
            }
        }

        System.out.println(String.format("pointer = %d", pointer));
    }
}
