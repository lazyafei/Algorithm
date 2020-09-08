package com.turnfly.algorithm;

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
}
