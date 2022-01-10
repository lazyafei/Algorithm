package com.turnfly.algorithm.basesort;


import com.turnfly.algorithm.CommonUtil;

public class QuickSort {
    static int getPivot(int[] arr,int l,int r){
        int mid = (l+r)/2;
        if(arr[l]>arr[mid]) CommonUtil.swap(arr,l,mid);
        if(arr[l]>arr[r]) CommonUtil.swap(arr,l,r);
        if(arr[mid]>arr[r]) CommonUtil.swap(arr,r,mid);
        CommonUtil.swap(arr,mid,r-1);
        CommonUtil.showArray(arr);
        return arr[r-1];
    }

    static void quickSort(int[] arr,int l,int r){
        if(l >= r) return;
        if(r-l>1){      //三个元素（或自定义n个）以上走快排
            //pivot放在倒数第二的位置(下标n-1)，查找下标范围[1,n-2]
            int pivot = getPivot(arr,l,r);
            //双指针，i从左至右判断比pivot小的元素，j从右至左判断比pivot大的元素
            int lo=l,hi=r-1; //right-1=length-2
            while(true){
                while(arr[++lo]<pivot){}  //小了继续,大于或等于暂停！
                while(arr[--hi]>pivot){}  //注意i,j的边界条件先++|--是跳过下标为0及n-2的两个元素！
                if(lo<hi){  //中间还有其它元素,可以交换元素
                    CommonUtil.swap(arr,lo,hi);
                }else{
                    break;
                }
            }
            //将pivot放在最终正确的位置
            CommonUtil.swap(arr,lo,r-1);
            quickSort(arr,l,lo-1);
            quickSort(arr,lo+1,r);
        }else{
            //可以走其他排序算法，此时l==r
            if(arr[l]>arr[r]){
                CommonUtil.swap(arr,l,r);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr =new int[]{4,1,3,7,2,5,8,9,6};
       // int[] arr =new int[]{1,0};
        quickSort(arr,0,arr.length-1);
        System.out.print("final result: ");
        int a = 1;

        CommonUtil.showArray(arr);
    }
}


