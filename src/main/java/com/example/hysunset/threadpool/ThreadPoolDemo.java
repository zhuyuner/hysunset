package com.example.hysunset.threadpool;

import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static class Mytask implements  Runnable{
        int a,b;
        public  Mytask(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":Thread ID:" +Thread.currentThread().getId()) ;
            double re = a/b;
            System.out.println("商结果：" +re);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("CPU：" +Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor pools  =new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        for(int i= 0; i<5;i++){
            pools.execute(new Mytask(100,i));
        }
    }
}

