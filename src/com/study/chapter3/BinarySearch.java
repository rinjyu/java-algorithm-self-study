package com.study.chapter3;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {39, 41, 53, 55, 68, 72, 84, 88, 92, 97};
        int x, pointer, left, right, middle;

        System.out.print("x = ");
        x = scanner.nextInt();
        pointer = -1;
        left = 0;
        right = array.length - 1;

        while (pointer == -1 && left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == x) {
                pointer = middle;
            } else if (array[middle] > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        System.out.println(String.format("pointer = %d", pointer));
    }
}
