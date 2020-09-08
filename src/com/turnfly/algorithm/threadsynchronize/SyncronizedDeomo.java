package com.turnfly.algorithm.threadsynchronize;

public class SyncronizedDeomo implements Runnable{
    static SyncronizedDeomo sd = new SyncronizedDeomo();
    Object lock1 = new Object();
    Object lock2 = new Object();


    @Override
    public void run() {
        synchronized (lock1){
            System.out.println("我是lock1:"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":lock1运行结束");
        }

        synchronized (lock2){
            System.out.println("我是lock2:"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":lock2运行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(sd);
            Thread t2 = new Thread(sd);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        System.out.println("finished");
    }
}
