package com.study.chapter9;

public class KnapsackDP {

    public static final int KNAP_MAX = 6;
    public static final int ITEM_NUMBER = 5;

    public static char[] name = {'A', 'B', 'C', 'D', 'E'};
    public static int[] weight = {1, 2, 3, 4, 5};
    public static int[] value = {100, 300, 350, 500, 650};

    public static int[][] maxValue = new int[ITEM_NUMBER][KNAP_MAX + 1];
    public static int[] lastItem = new int[KNAP_MAX + 1];

    public static void showKnap(int item) {

        int knap;

        System.out.println(String.format("<%c, %dkg, %d원을 고려한 결과>", name[item], weight[item], value[item]));

        for (knap = 0; knap <= KNAP_MAX; knap++) {
            System.out.println(String.format("%dkg", knap));
        }
        System.out.println();

        for (knap = 0; knap <= KNAP_MAX; knap++) {
            System.out.println(String.format("%d원", maxValue[item][knap]));
        }
        System.out.println();

        for (knap = 0; knap <= KNAP_MAX; knap++) {
            if (lastItem[knap] != -1) {
                System.out.println(String.format("%c", name[lastItem[knap]]));
            } else {
                System.out.println("없음");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int item = 0;
        int knap;
        int selectValue;
        int totalWeight;

        for (knap = 0; knap <= KNAP_MAX; knap++) {
            if (weight[item] <= knap) {
                maxValue[item][knap] = value[item];
                lastItem[knap] = item;
            } else {
                maxValue[0][knap] = 0;
                lastItem[knap] = -1;
            }
        }

        showKnap(item);

        for (item = 1; item < ITEM_NUMBER; item++) {
            for (knap = 0; knap <= KNAP_MAX; knap++) {
                if (weight[item] <= knap) {
                    selectValue = maxValue[item - 1][knap - weight[item]] + value[item];

                    if (selectValue > maxValue[item - 1][knap]) {
                        maxValue[item][knap] = selectValue;
                        lastItem[knap] = item;
                    } else {
                        maxValue[item][knap] = maxValue[item - 1][knap];
                    }
                } else {
                    maxValue[item][knap] = maxValue[item - 1][knap];
                }
            }

            showKnap(item);
        }

        System.out.println("<배낭에 들어 있는 물건을 조사>");
        totalWeight = 0;

        for (knap = KNAP_MAX; knap > 0; knap -= weight[item]) {
            item = lastItem[knap];
            System.out.println(String.format("%dkg의 배날에 마지막으로 넣은 물건 : %c", knap, name[item]));

            totalWeight += weight[item];
            System.out.println(String.format(" %c, %dkg, %d원", name[item], weight[item], value[item]));
            System.out.println(String.format(" %dkg - %dkg = %dkg", knap, weight[item], knap - weight[item]));
        }

        System.out.println("<정답 표시>");
        System.out.println(String.format("무게의 합계 = %dkg", totalWeight));
        System.out.println(String.format("가치의 최대값 = %d원", maxValue[ITEM_NUMBER - 1][KNAP_MAX]));
    }
}
