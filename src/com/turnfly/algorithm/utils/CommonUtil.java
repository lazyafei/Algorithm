package com.turnfly.algorithm.utils;

public class CommonUtil {
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }
    public static void showArray(int arr[]){
        for(Integer x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void showArray_colors(int arr[], int target){
        for(Integer x : arr){
            if (x == target) {
                System.out.print(ColorEnum.getColor(3) + x + " ");
            } else {
                System.out.print(ColorEnum.getColor(0)+x+" ");
            }
        }
        System.out.println();
    }

    public static <E> void showArray(E arr[]){
        for(E x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
