package com.study.chapter5;

class StationList {
    public String name;
    public int next;
}

public class LinkedList {
    public static StationList[] stationLists = new StationList[10];

    public static int head;

    public static void initStationList() {
        for (int i = 0; i < stationLists.length; i++) {
            stationLists[i] = new StationList();
        }

        stationLists[0].name = "부산";
        stationLists[0].next = -1;
        stationLists[1].name = "대전";
        stationLists[1].next = 3;
        stationLists[2].name = "서울";
        stationLists[2].next = 4;
        stationLists[3].name = "동대구";
        stationLists[3].next = 0;
        stationLists[4].name = "천안아산";
        stationLists[4].next = 1;

        head = 2;
    }

    public static void insertStationList(int index, String name, int prevIndex) {
        stationLists[index].name = name;
        stationLists[index].next = stationLists[prevIndex].next;
        stationLists[prevIndex].next = index;
    }

    public static void deleteStationList(int index, int prevIndex) {
        stationLists[prevIndex].next = stationLists[index].next;
    }

    public static void printStationList() {
        int index = head;
        while (index != -1) {
            System.out.print("[" + stationLists[index].name + "] -> ");
            index = stationLists[index].next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        initStationList();
        printStationList();

        insertStationList(5, "광명", 2);
        printStationList();

        deleteStationList(5, 2);
        printStationList();
    }
}
