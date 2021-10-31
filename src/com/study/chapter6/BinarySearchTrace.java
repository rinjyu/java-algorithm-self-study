package com.study.chapter6;

class BST {
    public int data;
    public int left;
    public int right;
}

public class BinarySearchTrace {

    public static BST[] tree = new BST[10];

    public static int rootIndex = 0;

    public static int newIndex = 0;

    public static void addBST(int data) {
        int currentIndex;
        boolean addFlag;

        tree[newIndex].data = data;
        tree[newIndex].left = -1;
        tree[newIndex].right = -1;

        if (newIndex != rootIndex ) {
            currentIndex = rootIndex;
            addFlag = false;
            do {
                if (data < tree[currentIndex].data) {
                    if (tree[currentIndex].left == -1) {
                        tree[currentIndex].left = newIndex;
                        addFlag = true;
                    } else {
                        currentIndex = tree[currentIndex].left;
                    }
                } else {
                    if (tree[currentIndex].right == -1) {
                        tree[currentIndex].right = newIndex;
                        addFlag = true;
                    } else {
                        currentIndex = tree[currentIndex].right;
                    }
                }
            } while (addFlag == false);

            newIndex++;
        }
    }

    public static void printPhysicalBST() {
        int i;
        for (i = 0; i < newIndex; i++) {
            System.out.println(String.format("tree[%d] : data = %d, left = %d, right = %d",
                    i, tree[i].data, tree[i].left, tree[i].right));
        }
    }

    public static void printLogicalBST(int currentIndex) {
        if (currentIndex != -1) {
            System.out.println(String.format("tree[%d] : data = %d, left = %d, right = %d",
                    currentIndex, tree[currentIndex].data, tree[currentIndex].left, tree[currentIndex].right));

            printLogicalBST(tree[currentIndex].left);
            printLogicalBST(tree[currentIndex].right);
        }
    }

    public static int searchBST(int x) {
        int index = -1;
        int currentIndex = rootIndex;

        while (currentIndex != -1) {
            if (tree[currentIndex].data == x) {
                index = currentIndex;
                break;
            } else if (tree[currentIndex].data > x) {
                currentIndex = tree[currentIndex].left;
            } else {
                currentIndex = tree[currentIndex].right;
            }
        }

        return index;
    }

    public static int searchRectangleBST(int x, int currentIndex) {
        if (currentIndex == -1) {
            return -1;
        } else {
            if (tree[currentIndex].data == x) {
                return currentIndex;
            } else if (tree[currentIndex].data > x) {
                return searchRectangleBST(x, tree[currentIndex].left);
            } else {
                return searchRectangleBST(x, tree[currentIndex].right);
            }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new BST();
        }

        addBST(4);
        addBST(6);
        addBST(5);
        addBST(2);
        addBST(3);
        addBST(7);
        addBST(1);

        printPhysicalBST();

        System.out.println("======================================");
        printLogicalBST(rootIndex);

        System.out.println(String.format("data 값이 '5'일 때의 물리적 위치 탐색 결과 = tree[%d]", searchBST(5)));
        System.out.println(String.format("data 값이 '8'일 때의 물리적 위치 탐색 결과 = tree[%d]", searchBST(8)));

        System.out.println("======================================");

        System.out.println(String.format("data 값이 '5'일 때의 물리적 위치 탐색 결과 = tree[%d]", searchRectangleBST(5, rootIndex)));
        System.out.println(String.format("data 값이 '8'일 때의 물리적 위치 탐색 결과 = tree[%d]", searchRectangleBST(8, rootIndex)));
    }
}
