package com.study.chapter7;

import java.util.Scanner;

public class HashTableSearch {

    public static int[] hashTable = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static int hashFunction(int data) {
        return data % 10;
    }

    public static void main(String[] args) {

        int data, hashValue;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.print("저장할 데이터 = ");
            data = scanner.nextInt();

            if (data < 0) {
                break;
            }

            hashValue = hashFunction(data);

            hashTable[hashValue] = data;
        } while (true);

        do {
            System.out.println();
            System.out.print("탐색할 데이터 = ");
            data = scanner.nextInt();

            if (data < 0) {
                break;
            }

            hashValue = hashFunction(data);

            if (hashTable[hashValue] == data) {
                System.out.println(String.format("%d번째에서 발견됨", hashValue));
            } else {
                System.out.println("찾을 수 없음");
            }
        } while (true);
    }
}
