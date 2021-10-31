package com.study.chapter2;

public class SumOfArrayTrace {

    public static void main(String[] args) {
        int[] array = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
        int sum = 0;
        int i;
        for (i = 0; i < array.length; i++) {
            sum += array[i];
            System.out.println(String.format("반복 실행 중 i=%d, sum=%d", i, sum));
        }

        System.out.println(String.format("sum=%d", sum));
        System.out.println(String.format("반복 실행 후 i=%d, sum=%d", i, sum));
    }
}
