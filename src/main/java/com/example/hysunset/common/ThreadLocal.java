package com.example.hysunset.common;

/**
 * @author zhy
 * @date 2023年1月16日
 */
public class ThreadLocal extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+" " +i);
        }
    }

    public static void main(String[] args){
        for(int i = 0; i< 100; i++){
            System.out.println(Thread.currentThread().getName() +"" + i);
            if(i ==20){
                new ThreadLocal().start();
                new ThreadLocal().start();
            }
        }

    }
}
