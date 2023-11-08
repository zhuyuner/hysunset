package com.example.hysunset.common;

public class YieldThread extends Thread{
    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        for(int i= 0; i<50; i++){
            System.out.println(getName() + " " + i );
            if(i == 20){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args){
        //启动两个并发线程
        YieldThread yt = new YieldThread("高级");
        //将yt线程设置成最高优先级
//        yt.setPriority(Thread.MAX_PRIORITY);
        yt.start();
        YieldThread yt1 = new YieldThread("低级");
//        yt1.setPriority(Thread.MIN_PRIORITY);
        yt1.start();
    }
}
