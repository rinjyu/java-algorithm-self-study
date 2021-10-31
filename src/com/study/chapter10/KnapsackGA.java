package com.study.chapter10;

import java.util.Scanner;

public class KnapsackGA {

    public static final int KNAP_MAX = 6;
    public static final int ITEM_NUMBER = 5;
    public static final int IND_NUMBER = 8;
    public static final double MUTATE_RATE = 0.1;

    public static char[] itemName = {'A', 'B', 'C', 'D', 'E'};
    public static int[] itemWeight = {1, 2, 3, 4, 5};
    public static int[] itemValue = {100, 300, 350, 500, 650};

    public static int indGeneration;
    public static int[][] indGenerate = new int[IND_NUMBER][ITEM_NUMBER];
    public static int[] indWeight = new int[IND_NUMBER];
    public static int[] indValue = new int[IND_NUMBER];
    public static int[] indFitness = new int[IND_NUMBER];

    public static void createIndividual() {

        int ind, item;
        for (ind = 0; ind < IND_NUMBER; ind++) {
            for (item = 0; item < ITEM_NUMBER; item++) {
                indGenerate[ind][item] = Math.random() > 0.5 ? 0 : 1;
            }
        }
    }

    public static void calculateIndividual() {

        int ind, item;
        for (ind = 0; ind < IND_NUMBER; ind++) {
            indWeight[ind] = 0;
            indValue[ind] = 0;
            for (item = 0; item < ITEM_NUMBER; item++) {
                if (indGenerate[ind][item] == 1) {
                    indWeight[ind] += itemWeight[item];
                    indValue[ind] += itemValue[item];
                }
            }

            if (indWeight[ind] <= KNAP_MAX) {
                indFitness[ind] = indValue[ind];
            } else {
                indFitness[ind] = 0;
            }
        }
    }

    public static void showIndividual() {

        int ind, item;
        System.out.println(String.format("<%d세대>", indGeneration));

        System.out.println(String.format("유전자\t\t무게\t가치\t적응도"));
        for (ind = 0; ind < IND_NUMBER; ind++) {
            for (item = 0; item < ITEM_NUMBER; item++) {
                System.out.print(String.format("[%d]", indGenerate[ind][item]));
            }
            System.out.println(String.format("\t%2dkg\t%4d원\t%4d", indWeight[ind], indValue[ind], indFitness[ind]));
        }
        System.out.println();
    }

    public static void sortIndividual() {

        int pointer, insertion, item, temp;
        for (pointer = 1; pointer < IND_NUMBER; pointer++) {
            insertion = pointer;
            while (insertion >= 1 && indFitness[insertion - 1] < indFitness[insertion]) {
                for (item = 0; item < ITEM_NUMBER; item++) {
                    temp = indGenerate[insertion - 1][item];
                    indGenerate[insertion - 1][item] = indGenerate[insertion][item];
                    indGenerate[insertion][item] = temp;
                }

                temp = indWeight[insertion - 1];
                indWeight[insertion - 1] = indWeight[insertion];
                indWeight[insertion] = temp;

                temp = indValue[insertion - 1];
                indValue[insertion - 1] = indValue[insertion];
                indValue[insertion] = temp;

                temp = indFitness[insertion - 1];
                indFitness[insertion - 1] = indFitness[insertion];
                indFitness[insertion] = temp;

                insertion--;
            }
        }
    }

    public static void selectIndividual() {

        int ind, item;
        for (ind = 0; ind < IND_NUMBER / 2; ind++) {
            for (item = 0; item < ITEM_NUMBER; item++) {
                indGenerate[ind + IND_NUMBER / 2][item] = indGenerate[ind][item];
            }
        }

        System.out.println("하위 50%를 도태시킴");
    }

    public static void crossoverIndividual() {

        int ind, item, crossoverPointer, temp;
        for (ind = IND_NUMBER / 2; ind < (IND_NUMBER - 1); ind += 2) {
            crossoverPointer = (int) (Math.random() * 10000) % (ITEM_NUMBER - 1) + 1;
            for (item = crossoverPointer; item < ITEM_NUMBER; item++) {
                temp = indGenerate[ind][item];
                indGenerate[ind][item] = indGenerate[ind + 1][item];
                indGenerate[ind + 1][item] = temp;
            }
            System.out.println(String.format("개체 %d와 %d를 %d의 위치에서 교차함", ind, ind + 1, crossoverPointer));
        }
    }

    public static void mutateIndividual() {

        int ind, item;
        for (ind = IND_NUMBER / 2; ind < ITEM_NUMBER; ind++) {
            for (item = 0; item < ITEM_NUMBER; item++) {
                if (Math.random() <= MUTATE_RATE) {
                    indGenerate[ind][item] ^= 1;
                    System.out.println(String.format("개체 %d의 %d 위치에서 돌연변이를 생성함", ind, item));
                }
            }
        }
    }

    public static void main(String[] args) {

        int genMax;
        int item;

        Scanner scanner = new Scanner(System.in);
        System.out.print("최대의 세대 = ");
        genMax = scanner.nextInt();

        indGeneration = 1;
        createIndividual();

        calculateIndividual();

        sortIndividual();

        showIndividual();

        indGeneration++;

        while (indGeneration <= genMax) {
            sortIndividual();

            selectIndividual();

            crossoverIndividual();

            mutateIndividual();

            calculateIndividual();

            sortIndividual();

            showIndividual();

            indGeneration++;
        }

        System.out.println("<배낭에 들어있는 물건을 표시>");
        for (item = 0; item < ITEM_NUMBER; item++) {
            if (indGenerate[0][item] == 1) {
                System.out.println(String.format("%c, %dkg, %d원", itemName[item], itemWeight[item], itemValue[item]));
            }
        }

        System.out.println("<정답 표시>");
        System.out.println(String.format("무게의 합계 = %dkg", indWeight[0]));
        System.out.println(String.format("가치의 최대값 = %d원", indValue[0]));
    }
}
