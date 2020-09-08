package com.turnfly.algorithm.practice;

import com.turnfly.algorithm.CommonUtil;

/**希尔排序
 * 又称分组的直接插入排序，缩小增量排序,是直接插入排序的改进方法（直接插入排序只交换相邻元素，只能消去一个逆序对）
 * 1、每次消去不止一个逆序对
 * 2、每次消去间隔较远的两个元素
 * 思路：设定一个增量，标记每个增量范围的第一个元素，初始为序列长度的一半，每次循环/2,直到为1为止；
 * */
public class ShellSort {

    public static void shellsort(int[] arr) {
        CommonUtil.showArray(arr);
        //设定一个增量，初始为序列长度的一半，每次循环/2,直到为1为止
        for(int delta = arr.length/2;delta>0;delta/=2){

            //COPY - insert-sort.....
            //外层循环 - 无序区域有n-delta个元素,n-delta次循环
            for(int i=delta; i<arr.length; i++){
                int cur = arr[i],j;  //取出无序区第一个元素的值，在有序区从右至左与其比较的过程中，这个位置会被覆盖；
                //内层循环 - 有序区间有j=i-delta个元素，j次循环
                for(j=i-delta; j>=0 && arr[j]>cur; j-=delta){
                    //遇到比无序区域第一个元素大的，把这个值往后移，腾出位置！
                    arr[j+delta] = arr[j]; //j+1最多也就是i不担心越界
                }
                //直到遇到比cur小的arr[j]，在其后插入
                arr[j+delta] = cur;
            }
        }
        CommonUtil.showArray(arr);
    }
    public static void main(String[] args) {
        shellsort(new int[]{9,8,7,6,5,4,3,2,1});
    }
}
