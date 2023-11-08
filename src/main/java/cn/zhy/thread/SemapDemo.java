package cn.zhy.thread;

import java.util.concurrent.*;

public class SemapDemo implements Runnable {
    //定义信号量，以及其准入数
    // 允许5个线程同时访问
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+":done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semp.release();
        }
    }

    public static void main(String[] args){
        ExecutorService exec = new ThreadPoolExecutor(5,10,5,TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000));
        final SemapDemo demo = new SemapDemo();
        for (int i=0; i<20;i++){
            exec.submit(demo);
        }
    }
}
