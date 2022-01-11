package com.turnfly.algorithm.practice;

public class gcd {
    public static int gcd(int p,int q){
        if(q == 0) return p;
        int r = p%q;
        return gcd(q,r);
    }
    public static void main(String args[]){
        String a = "123";
        a.replace("1","2");
        String b = new String(new char[]{'a', 'b'});

        String c =",a,,b,";
//        List<String> list = Splitter.on(',')
//                .trimResults()// 去掉空格
//                .omitEmptyStrings()// 去掉空值
//                .splitToList(a);
        //gcd2(3,5);
        //System.out.println("sfd:"+gcd(3,5));
        //System.out.println(Arrays.toString(arr));
    }

    public static void gcd2(int m, int n){
        int gcd = calculateGCD(m,n);
        System.out.println(m+","+n+"的最大公约数是：" + gcd+",最小公倍数是：" +m*n/gcd);
    }
    static int calculateGCD(int m, int n){
        while (true){
            if ((m = m % n) == 0)
                return n;
            if ((n = n % m) == 0)
                return m;
        }
    }
}
