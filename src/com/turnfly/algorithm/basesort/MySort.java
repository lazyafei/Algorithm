package com.turnfly.algorithm.basesort;

public class MySort {
    static void showArray(int arr[]){
        for(Integer x : arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }


    /**
     * 冒泡
     */
    static void swap(int[] arr,int i,int j){
        int tmp = arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }





    /**
     * 希尔排序
     */
    static void shellSort(int arr[]){
        int length=arr.length;
        for(int delta=length/2;delta>0;delta/=2){
            for(int i=delta;i<arr.length;i++){
                int last = arr[i],j;
                for(j = i; j>=delta && arr[j-delta] > last; j-=delta){
                    arr[j]=arr[j-delta]; //大的右移
                }
                arr[j]=last;
            }
        }
        showArray(arr);
    }


    /**
     * 快速排序
     */
    static int meidan3(int[] arr,int left,int right){
        //返回三取样中位数
        int center = (left+right)/2;
        if(arr[left]>arr[center])
            swap(arr,left,center);
        if(arr[left]>arr[right])
            swap(arr,left,right);
        if(arr[center]>arr[right])
            swap(arr,center,right);
        swap(arr,center,right-1); /* 将中位数放到倒数第二个位置，只需要考虑A[Left+1] … A[Right-2] */
        showArray(arr);
        return arr[right-1]; /* 返回基准Pivot */
    }

    static void qs(int[] arr,int left,int right){
        if(left >= right)return;
        int pivot = meidan3(arr,left,right);
        //双指针，i从左至右判断比pivot小的元素，j从右至左判断比pivot大的元素
        int i=left,j=right-1; //right-1=length-2
        while(true) {
            while (arr[++i] < pivot) {}//小了继续,大于或等于暂停！
            while (arr[--j] > pivot) {}//大了继续，小于或等于暂停！
            if(i<j){ //i<j证明中间还有其他元素
                swap(arr, i, j);
            }else{
                break;
            }
        }
        //将pivot放在最终正确位置
        swap(arr,i,right-1);
        qs(arr,left,i-1);
        qs(arr,i+1,right);
    }

    static void qs2(int[] arr,int left,int right){
        if(left >= right)return;
        int pivot = arr[left]; //取第一个元素为pivot，0～n-1
        //双指针，i从左至右判断比pivot小的元素，j从右至左判断比pivot大的元素
        int i=left,j=right;
        while(true) {
            //循环下标范围 1～n-1
            while (i+1<=right && arr[++i] < pivot) { }//小了继续，大于等于暂停
            while (arr[j] > pivot) {if(j-1>=left) j--; }//大了继续
            if(i<j){ //i<j证明中间还有其他元素
                swap(arr, i, j);
            }else{
                //i，j重合或者i已经到j右边i>j,说明该次循环结束，记得在循环外把pivot放到最终位置(下标为i或j的位置)
                break;
            }
        }
        //将pivot放在最终正确位置,pivot左边开始放在最后小的一边j，pivot右边开始放在最终大的一边i
        swap(arr,j,left);
        qs2(arr,left,j-1);
        qs2(arr,j+1,right);
    }

    static void quickSort(int arr[]){
        qs(arr,0,arr.length-1);
        showArray(arr);
    }


    /**
     *
     */
    static void insertSort3(int arr[]){
        showArray(arr);
    }


    /**
     *
     */
    static void insertSort4(int arr[]){
        showArray(arr);
    }

    /**
     *
     */

    public static void main(String[] args) {
        quickSort(new int[]{4,1,3,7,2,5,8,9,6});
    }
}
