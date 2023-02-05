package com.turnfly.algorithm.practice;

public class BubbleTest {
    public static void swap(int[] oArr, int i, int j) {
        int temp = oArr[i];
        oArr[i] = oArr[j];
        oArr[j] = temp;
    }

    public static void bubbleSort(int[] originArr) {


        for (int i = originArr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (originArr[j] > originArr[j + 1]) {
                    swap(originArr, j, j + 1);
                }
            }
        }

        for (int oa : originArr) {
            System.out.print(oa + " ");
        }
    }


    public static void main(String[] args) {
        bubbleSort(new int[]{5, 3, 1, 3, 6, 1, 4, 4, 5, 2, 3, 2, 1});
    }

}
