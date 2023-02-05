package com.turnfly.algorithm;


import com.turnfly.algorithm.basesort.MySort;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class RunMethod {


    public static void main(String args[]) {
        /*Scanner sc = new Scanner(System.in);
        List<Integer> charList = new ArrayList<>();
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            System.out.println(n);
            if(n == 0)break;
            int tmp = 0;
            while(sc.hasNext()){
                tmp += sc.nextInt();

            }
            if(tmp!=0){
                charList.add(tmp);
                //System.out.println(tmp);
            }


        }*/


        System.out.println(recursive(5));


    }
    public static double recursive(int i){
        if(i<=1)return 1;
        return Math.pow(i,2)+recursive(i-1);
    }




}


