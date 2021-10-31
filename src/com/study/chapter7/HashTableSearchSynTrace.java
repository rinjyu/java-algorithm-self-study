package com.study.chapter7;

import java.util.Scanner;

public class HashTableSearchSynTrace {

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
            System.out.println(String.format("해시값 = %d %% 10 = %d", data, hashValue));

            pointer = hashValue;
            System.out.println(String.format("저장 위치 pointer = %d", pointer));

            while (hashTable[pointer] != -1) {
                pointer++;

                if (pointer >= hashTable.length) {
                    pointer = 0;
                }
                System.out.println(String.format("저장 위치 pointer = %d", pointer));

                if (pointer == hashValue) {
                    break;
                }
            }

            if (hashTable[pointer] == -1) {
                hashTable[pointer] = data;
                System.out.println(String.format("hashTable[%d]에 %d을(를) 저장함", pointer, data));
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
            System.out.println(String.format("해시값 = %d %% 10 = %d", data, hashValue));

            pointer = hashValue;
            System.out.println(String.format("저장 위치 pointer = %d", pointer));

            while (hashTable[pointer] != -1 && hashTable[pointer] != data) {
                pointer++;

                if (pointer >= hashTable.length) {
                    pointer = 0;
                }
                System.out.println(String.format("탐색 위치 pointer = %d", pointer));

                if (hashTable[pointer] == -1 || pointer == hashValue) {
                    break;
                }
            }

            if (hashTable[hashValue] == data) {
                System.out.println(String.format("hashTable[%d]값은 %d이므로, 발견한 위치를 표시함", pointer, data));
                System.out.println(String.format("%d번째에서 발견됨", hashValue));
            } else {
                System.out.println(String.format("hashTable[%d]값은 %d이(가) 아니므로, '찾을 수 없음'을 표시함", hashValue, data));
                System.out.println("찾을 수 없음");
            }
        } while (true);
    }
}