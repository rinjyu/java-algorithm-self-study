package com.study.chapter4;

public class InsertionSortTrace {

    public static void main(String[] args) {

        int[] array = {90, 34, 78, 12, 56};
        int index, compare, temp;

        System.out.println("정렬 전 배열");
        printArray(array);

        for (index = 1; index < array.length; index++) {
            System.out.println(String.format("외부 반복문 : temp <- array[%d] %d", index, array[index]));
            temp = array[index];
            for (compare = index - 1; compare >= 0; compare--) {
                System.out.println(String.format("내부 반복문 : index = %d, compare = %d, temp = %d", index, compare, temp));
                if (array[compare] > temp) {
                    array[compare + 1] = array[compare];
                } else {
                    System.out.println("break로 중단");
                    break;
                }

                printArray(array);
            }

            System.out.println(String.format("외부 반복문 : index = %d, compare = %d, temp = %d", index, compare, temp));
            System.out.println(String.format("외부 반복문 : 확정된 삽입 위치 = array[%d] <- temp", compare + 1));

            array[compare + 1] = temp;

            System.out.println("삽입 위치 확정 후 중간 결과");
            printArray(array);
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
