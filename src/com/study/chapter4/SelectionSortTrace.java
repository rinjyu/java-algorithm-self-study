package com.study.chapter4;

public class SelectionSortTrace {

    public static void main(String[] args) {

        int[] array = {90, 34, 78, 12, 56};
        int index, compare, min, temp;

        System.out.println("정렬 전 배열");
        printArray(array);

        for (index = 0; index < array.length - 1; index++) {
            System.out.println(String.format("외부 반복문 : %d회", index + 1));
            min = index;
            for (compare = index + 1; compare < array.length; compare++) {
                if (array[compare] < array[index]) {
                    min = compare;
                    temp = array[index];
                    array[index] = array[min];
                    array[min] = temp;

                    System.out.println(String.format("배열 요소의 현재 최소값 : array[%d] = %d", index, array[index]));
                    printArray(array);
                }

                System.out.println(String.format("내부 반복문 : index = %d, compare = %d, array[%d] = %d", index, compare, compare, array[compare]));
                printArray(array);
            }

            System.out.println(String.format("외부 반복문 : index = %d, compare = %d, array[%d] = %d", index, compare, index, array[index]));
            printArray(array);
        }

        System.out.println(String.format("외부 반복문 : 확정된 정렬 위치 = array[%d] <- %d", array.length - 1, array[array.length - 1]));

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
