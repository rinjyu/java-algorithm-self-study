package com.study.chapter9;

public class KnapsackGreedy {

    public static void main(String[] args) {

        final int KNAP_MAX = 6;
        final int ITEM_NUMBER = 5;
        int totalWeight = 0;
        int totalValue = 0;

        char[] name = {'E', 'D', 'C', 'B', 'A'};
        int[] weight = {5, 4, 3, 2, 1};
        int[] value = {650, 500, 350, 300, 100};

        for (int i = 0; i < ITEM_NUMBER; i++) {
            if (totalWeight + weight[i] <= KNAP_MAX) {
                System.out.println(String.format("물건 %c를 선택", name[i]));
                totalWeight += weight[i];
                totalValue += value[i];
            } else {
                break;
            }
        }

        System.out.println(String.format("무게의 합계 = %dkg", totalWeight));
        System.out.println(String.format("가치의 합계 = %d원", totalValue));
    }
}
