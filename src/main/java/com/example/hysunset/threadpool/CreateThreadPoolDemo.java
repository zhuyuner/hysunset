package com.example.hysunset.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateThreadPoolDemo {

    public static final int SLEEP_CAP = 500;

    static class TargetTask implements Runnable {

        static AtomicInteger taskNo = new AtomicInteger(1);
        private String taskName;

        public TargetTask() {
            taskName = "task-" + taskNo.get();
            taskNo.incrementAndGet();
        }

        @Override
        public void run() {
            System.out.println("任务：" + taskName + "doing");
            try {
                Thread.sleep(SLEEP_CAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + "运行结束");
        }
    }

    public void split(int[] array,int left ,int right){
       int temp = array[left];
       array[left] = array[right];
       array[right] = temp;
    }


        public static  void main(String[] args) throws InterruptedException {
            // 第一种：单个线程池
//            ExecutorService pool = Executors.newSingleThreadExecutor();
            //第二种 固定线程池
//            ExecutorService pool = Executors.newFixedThreadPool(3);
            //第三种：可缓冲线程池
//            ExecutorService pool = Executors.newCachedThreadPool();
       /*     for (int i = 0; i < 5; i++) {
                pool.execute(new TargetTask());
                pool.submit(new TargetTask());
            }
            Thread.sleep(1000);
            pool.shutdown();
        }*/
            ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(2);
            for(int i = 0; i<2; i++){
                scheduled.scheduleAtFixedRate(new TargetTask(),0,500, TimeUnit.MILLISECONDS);
            }
            Thread.sleep(1000);
            scheduled.shutdown();


    }


}
