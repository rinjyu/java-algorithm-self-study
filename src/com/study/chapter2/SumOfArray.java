package com.study.chapter2;

public class SumOfArray {

    public static void main(String[] args) {
        int[] array = {72, 68, 92, 88, 41, 53, 97, 84, 39, 55};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println(String.format("배열의 합은 %d입니다.", sum));
    }
}
