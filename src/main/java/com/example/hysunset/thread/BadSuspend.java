package com.example.hysunset.thread;

import java.util.Objects;

/**
 * 2.2.5　挂起（suspend）和继续执行（resume）线程
 */
public class BadSuspend {
    public static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("T1");
    static ChangeObjectThread t2 = new ChangeObjectThread("T2");
    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run(){
            synchronized (u){
                System.out.println("in " +getName());
                //线程挂起
                Thread.currentThread().suspend();
                System.out.println("AAAA :" + getName());
            }
        }
    }
    public static void main(String[] args ) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        //线程唤醒
        t1.resume();
        //resume 并没有生效，t2永远被挂起，因为线程1suspend() 并不会释放资源
        t2.resume();
        t1.join();
        t2.join();
    }
}
