package com.study.chapter4;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {90, 34, 78, 12, 56};
        int index, compare, temp;

        System.out.println("정렬 전 배열");
        printArray(array);

        for (index = 0; index < array.length - 1; index++) {
            for (compare = 0; compare < array.length - index - 1; compare++) {
                if (array[compare] > array[compare + 1]) {
                    temp = array[compare];
                    array[compare] = array[compare + 1];
                    array[compare + 1] = temp;
                }
            }
        }

        System.out.println("정렬 후 배열");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }

        System.out.println();
    }
}
