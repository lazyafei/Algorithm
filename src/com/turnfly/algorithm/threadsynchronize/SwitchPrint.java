package com.turnfly.algorithm.threadsynchronize;

import java.util.concurrent.Semaphore;

public class SwitchPrint implements Runnable{
    private static int tmp = 0;
    Object o = new Object();

    @Override
    public void run() {
        while(tmp<=100){
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+" : "+tmp++);
                try {
                    o.notify();
                    if(tmp<=100) {
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //两个线程交替打印 0～100
    public static void main(String[] args) {
        SwitchPrint sp = new SwitchPrint();
        new Thread(sp).start();
        new Thread(sp).start();
    }

}
