package com.study.chapter4;

public class MultiplicationTableTrace {

    public static void main(String[] args) {
        int step, number;
        for (step = 1; step <= 9; step++) {
            for (number = 1; number <= 9; number++) {
                System.out.println(String.format("step = %d, number = %d, step * number = %d", step, number, (step * number)));
            }
        }
    }
}
