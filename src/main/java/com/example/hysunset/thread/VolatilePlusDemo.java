package com.example.hysunset.thread;

/**
 * volatile 关键字不能保证 i++
 * volatile 能保证可见性和有序性
 * @date 2023年1月31日
 */
public class VolatilePlusDemo {

    static volatile int i = 0;
    public static class PlusTask implements  Runnable{
        @Override
        public void run(){
            for(int k=0; k<10000; k++){
                i++;
            }
        }
    }
    public static void main(String[] args ) throws InterruptedException {
        Thread[] threads  = new Thread[10];
        for(int i=0; i<10; i++){
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for(int i=0; i<10;i++){
            threads[i].join();
        }
             System.out.println(i);

    }

}
