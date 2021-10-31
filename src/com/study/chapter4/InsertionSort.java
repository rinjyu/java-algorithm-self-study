package com.study.chapter4;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = {90, 34, 78, 12, 56};
        int index, compare, temp;

        System.out.println("정렬 전 배열");
        printArray(array);

        for (index = 1; index < array.length; index++) {
            temp = array[index];
            for (compare = index - 1; compare >= 0; compare--) {
                if (array[compare] > temp) {
                    array[compare + 1] = array[compare];
                } else {
                    break;
                }
            }

            array[compare + 1] = temp;
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
