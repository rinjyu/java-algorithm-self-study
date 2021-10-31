package com.study.chapter4;

public class MultiplicationTable {

    public static void main(String[] args) {
        int step, number;
        for (step = 1; step <= 9; step++) {
            System.out.print(String.format("%d단", step));
            for (number = 1; number <= 9; number++) {
                System.out.print(String.format("%2d", step * number));
            }

            System.out.println();
        }
    }
}
