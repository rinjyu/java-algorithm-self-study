package com.study.chapter4;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {90, 34, 78, 12, 56};
        int index, compare, min, temp;

        System.out.println("정렬 전 배열");
        printArray(array);

        for (index = 0; index < array.length - 1; index++) {
            min = index;
            for (compare = index + 1; compare < array.length; compare++) {
                if (array[compare] < array[index]) {
                    min = compare;
                    temp = array[index];
                    array[index] = array[min];
                    array[min] = temp;
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
