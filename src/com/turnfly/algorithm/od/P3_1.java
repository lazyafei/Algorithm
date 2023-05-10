package com.turnfly.algorithm.od;


import java.util.Scanner;

public class P3_1 {

    /**
     * 网上商城优惠活动
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] discount_sort = in.nextLine().split(" ");
        int[] discount_nums = new int[3];
        discount_nums[0] = Integer.valueOf(discount_sort[0]);
        discount_nums[1] = Integer.valueOf(discount_sort[1]);
        discount_nums[2] = Integer.valueOf(discount_sort[2]);
        int person_num = Integer.valueOf(in.nextLine());

        int line = 0;
        while (in.hasNextLine()) {
            int init_price = Integer.valueOf(in.nextLine());
            int c_100 = Math.min(discount_nums[0], init_price/100);
            int c_92 = Math.min(discount_nums[1], 1);

            if (init_price < 100) {
                //先92 再 5
                int after_price = d5(d92(init_price, c_92), discount_nums[2]);
                int count = c_92 +  discount_nums[2];
                System.out.println(after_price + " " + count);
            } else {
                //大于等于
                int after_price;
                int count;

                if (d100(init_price, c_100) <= d92(init_price, c_92)) {
                    //小于5/0.08 = 62.5用92折没有无门槛划算
                    //1,3   1,2 最小值
                    int a = d5(d100(init_price, c_100), discount_nums[2]);
                    int b = d92(d100(init_price, c_100),c_92);
                    after_price = Math.min(a, b);
                    if (a > b) {
                        count = c_92 + c_100;
                    } else {
                        count = c_100 + discount_nums[2];
                    }
                } else {
                    //2,1 2,3 最小值
                    int a = d100(d92(init_price, c_92), c_100);
                    int b = d5(d92(init_price, c_92), discount_nums[2]);
                    after_price = Math.min(a, b);
                    if (a < b) {
                        count = c_92 + c_100;
                    } else {
                        count = c_92 + discount_nums[2];
                    }
                }
                System.out.println(after_price + " " + count);
            }
            line++;
            if (line == person_num) break;
        }
    }

    public static int d100(int n, int num) {
        return n >= 100 ? n - 10 * num : n;
    }

    public static int d92(int n, int num) {
        if(num == 0) return n;
        int t =  (int) (n * 0.92);
        return n > 0 ? t : n;
    }
    public static int d5(int n, int num) {
        return n > 0 ? n - 5 * num : n;
    }




}
