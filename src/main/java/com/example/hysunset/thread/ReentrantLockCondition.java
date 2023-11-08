package com.example.hysunset.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁：RentrantLock
 * Condition 搭配重入锁使用
 * @author zhy
 * @date 2023年2月2日 10:02
 */
public class ReentrantLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockCondition t1 = new ReentrantLockCondition();
        Thread thread = new Thread(t1);
        thread.start();
        Thread.sleep(20000);
        //通知线程t1继续执行
            lock.lock();
            //获得锁
            condition.signal();
            //释放重入锁
            lock.unlock();


    }
}
