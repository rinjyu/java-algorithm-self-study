package com.study.chapter7;

import java.util.Scanner;

public class HashTableSearchSyn {

    public static int[] hashTable = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public static int hashFunction(int data) {
        return data % 10;
    }

    public static void main(String[] args) {

        int data, hashValue;
        int pointer;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.print("저장할 데이터 = ");
            data = scanner.nextInt();

            if (data < 0) {
                break;
            }

            hashValue = hashFunction(data);
            pointer = hashValue;

            while (hashTable[pointer] != -1) {
                pointer++;

                if (pointer >= hashTable.length) {
                    pointer = 0;
                }

                if (pointer == hashValue) {
                    break;
                }
            }

            if (hashTable[pointer] == -1) {
                hashTable[pointer] = data;
            } else {
                System.out.println("해시 테이블이 가득참");
            }
        } while (true);

        do {
            System.out.println();
            System.out.print("탐색할 데이터 = ");
            data = scanner.nextInt();

            if (data < 0) {
                break;
            }

            hashValue = hashFunction(data);

            pointer = hashValue;

            while (hashTable[pointer] != -1 && hashTable[pointer] != data) {
                pointer++;

                if (pointer >= hashTable.length) {
                    pointer = 0;
                }

                if (hashTable[pointer] == -1 || pointer == hashValue) {
                    break;
                }
            }

            if (hashTable[hashValue] == data) {
                System.out.println(String.format("%d번째에서 발견됨", hashValue));
            } else {
                System.out.println("찾을 수 없음");
            }
        } while (true);
    }
}