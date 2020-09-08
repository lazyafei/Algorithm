package com.turnfly.algorithm.leetcode;

import java.util.Stack;

public class Practice {

    /**
     * 最大子列和
     * */
    public static int maxSubList1(int[] arr){
        int length = arr.length;
        int maxSubListValue = 0;
        for(int i=0; i<length; i++){
            //j<=i
            for(int j=i; j<length; j++){
                int currentListValue = 0;
                for(int k=i; k<=j; k++){
                    currentListValue += arr[k];
                }
                if(currentListValue > maxSubListValue){
                    maxSubListValue = currentListValue;
                }
            }
        }
        return maxSubListValue;
    }

    //对于相同的i不同的j，只要在j-1次的循环基础上累加1项即可
    public static int maxSubList2(int[] arr){
        int length = arr.length;
        int maxSubListValue = 0;
        for(int i=0; i<length; i++){
            int currentListValue = 0;
            //j<=i
            for(int j=i; j<length; j++){
                currentListValue += arr[j];
                if(currentListValue > maxSubListValue){
                    maxSubListValue = currentListValue;
                }
            }
        }
        return maxSubListValue;
    }

    /***
     * 最大子列和-分治法
     * 1、找到中分点，递归求得两边子列的最大和
     * 2、从中线向左及右扫描，求跨分界线的最大子列和
     * 3、返回"治"的结果
     */
    /* 返回3个整数中的最大值 */
    static int Max3( int A, int B, int C ){
        return A > B ? Math.max(A, C) : Math.max(B, C);
    }
    public static int divideAndConquer(int[] list,int left,int right){
        int MaxLeftSum, MaxRightSum; /* 存放左右子问题的解 */
        int MaxLeftBorderSum, MaxRightBorderSum; /*存放跨分界线的结果*/

        int LeftBorderSum, RightBorderSum;
        int center, i;

        if( left == right )  { /* 递归的终止条件，子列只有1个数字 */
            if( list[left] > 0 )  return list[left];
            else return 0;
        }

        /* 下面是"分"的过程 */
        center = ( left + right ) / 2; /* 找到中分点 */
        /* 递归求得两边子列的最大和 */
        MaxLeftSum = divideAndConquer( list, left, center );
        MaxRightSum = divideAndConquer( list, center+1, right );

        /* 下面求跨分界线的最大子列和 */
        MaxLeftBorderSum = 0; LeftBorderSum = 0;
        for( i=center; i>=left; i-- ) { /* 从中线向左扫描 */
            LeftBorderSum += list[i];
            if( LeftBorderSum > MaxLeftBorderSum )
                MaxLeftBorderSum = LeftBorderSum;
        } /* 左边扫描结束 */

        MaxRightBorderSum = 0; RightBorderSum = 0;
        for( i=center+1; i<=right; i++ ) { /* 从中线向右扫描 */
            RightBorderSum += list[i];
            if( RightBorderSum > MaxRightBorderSum )
                MaxRightBorderSum = RightBorderSum;
        } /* 右边扫描结束 */

        /* 下面返回"治"的结果 */
        return Max3( MaxLeftSum, MaxRightSum, MaxLeftBorderSum + MaxRightBorderSum );
    }

    /**
     * 最大子列和-在线处理法
     * 在线的意思是每输入一个数据就进行即时处理
     */
    public static int maxSubList4(int[] arr){
        int length = arr.length;
        int maxSubListValue =0;
        int currentListValue = 0;
        for(int i=0; i<length; i++){
            //向右累加
            currentListValue += arr[i];
            if(currentListValue > maxSubListValue){
                maxSubListValue = currentListValue;
            }else if(currentListValue < 0){
                currentListValue = 0;
            }
        }
        return maxSubListValue;
    }


    /**
     * 两个整数序列pushA[]-入栈序列,popA[]-出栈序列，根据入栈序列判断出栈序列是否合法
     * 思路：
     * 1、创建辅助栈stack，将pushA整数序列依次入栈；
     * 2、每次压入栈之后判断栈顶元素与出栈序列popA第一个元素比较是否相等，相等则将栈顶元素弹出 且 将pushA首元素去掉；
     * 3、余下的popA与pushA递归2的操作；
     * ps：stack pop()移除栈顶元素并返回其值
     */

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        int j = 0;
        Stack<Integer> stack = new Stack<Integer>();
        //for循环完，大概率剩余部分元素没弹出，j也未增长到popA.size()-1
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            //辅助栈栈顶元素 与 出栈序列首元素 是否相等
            while(!stack.isEmpty() && stack.peek()==popA[j]){
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}
