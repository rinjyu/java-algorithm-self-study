package com.study.chapter4;

public class BubbleSortTrace {

    public static void main(String[] args) {

        int[] array = {90, 34, 78, 12, 56};
        int index, compare, temp;

        System.out.println("정렬 전 배열");
        printArray(array);

        for (index = 0; index < array.length - 1; index++) {
            System.out.println(String.format("외부 반복문 : %d회", index + 1));
            for (compare = 0; compare < array.length - index - 1; compare++) {
                if (array[compare] > array[compare + 1]) {
                    temp = array[compare];
                    array[compare] = array[compare + 1];
                    array[compare + 1] = temp;
                }

                System.out.println(String.format("내부 반복문 : index = %d, compare = %d, array[%d] = %d", index, compare, compare, array[compare]));
                printArray(array);
            }

            System.out.println(String.format("외부 반복문 : index = %d, compare = %d, array[%d] = %d", index, compare, compare, array[compare]));
            System.out.println(String.format("외부 반복문 : 확장된 정렬 위치 = array[%d] <- %d", compare, array[compare]));

            printArray(array);
        }

        System.out.println(String.format("외부 반복문 : 확장된 정렬 위치 = array[%d] <- %d", 0, array[0]));

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
