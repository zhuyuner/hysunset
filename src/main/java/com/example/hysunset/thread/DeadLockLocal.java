package com.example.hysunset.thread;

public class DeadLockLocal implements Runnable{
    DeadLockA a = new DeadLockA();
    DeadLockB  b = new DeadLockB();
    public void init(){
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入主线程后");
    }
    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        b.bar(a);
        System.out.println("进入了副线程之后");
    }

    public static void main(String[] args){
        DeadLockLocal lockLocal= new DeadLockLocal();
        new Thread(lockLocal).start();
        lockLocal.init();
    }
}
