package com.study.chapter8;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {4, 7, 1, 6, 2, 5, 3};
        printArray(array);

        sortArray(array, 0, array.length - 1);
        printArray(array);
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println();
    }

    public static int divideArray(int[] array, int head, int tail) {

        int left, right, temp;
        left = head + 1;
        right = tail;

        while (true) {
            while (left < tail && array[head] > array[left]) {
                left++;
            }

            while (array[head] < array[right]) {
                right--;
            }

            if (left >= right) {
                break;
            }

            temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

        temp = array[head];
        array[head] = array[right];
        array[right] = temp;

        return right;
    }

    public static void sortArray(int[] array, int start, int end) {

        int pivot;

        if (start < end) {
            pivot = divideArray(array, start, end);

            sortArray(array, start, pivot - 1);

            sortArray(array, pivot + 1, end);
        }
    }
}
