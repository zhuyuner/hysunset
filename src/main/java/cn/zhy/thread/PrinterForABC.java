package cn.zhy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterForABC {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();


    public void printABC(String ch) {
        try {
            lock.lock();
            System.out.println(ch);
            if (ch.equals("A")) {
                conditionB.signal();
                conditionA.await();
            } else if (ch.equals("B")) {
                conditionC.signal();
                conditionB.await();
            } else if (ch.equals("C")) {
                conditionA.signal();
                conditionC.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static class PrintThread implements Runnable {
        String ch;
        PrinterForABC tool;

        public PrintThread(String ch, PrinterForABC tool) {
            this.ch = ch;
            this.tool = tool;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (true) {
                    tool.printABC(ch);
                    Thread.sleep((long) (Math.random() * 100));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        PrinterForABC tool = new PrinterForABC();
        Thread t1 = new Thread(new PrintThread("A", tool));
        Thread t2 = new Thread(new PrintThread("B", tool));
        Thread t3 = new Thread(new PrintThread("C", tool));

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();


    }
}
