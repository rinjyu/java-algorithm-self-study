package com.study.chapter7;

import java.util.Scanner;

public class HashTableSearchTrace {

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
            System.out.println(String.format("해시값 = %d %% 10 = %d", data, hashValue));

            hashTable[hashValue] = data;
            System.out.println(String.format("hashTable[%d]에 %d를 저장", hashValue, data));
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

            if (hashTable[hashValue] == data) {
                System.out.println(String.format("hashTable[%d]값은 %d이므로, 발견된 위치를 표시", hashValue, data));
                System.out.println(String.format("%d번째에서 발견됨", hashValue));
            } else {
                System.out.println(String.format("hashTable[%d]값은 %d이(가) 아니므로, '찾을 수 없음'을 표시함", hashValue, data));
                System.out.println("찾을 수 없음");
            }
        } while (true);
    }
}
