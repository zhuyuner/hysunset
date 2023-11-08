package com.example.hysunset.thread;

/**
 * volatile 关键字不能保证 i++
 * volatile 能保证可见性和有序性
 *
 * @date 2023年1月31日
 */
public class VolatileNoVisibilityDemo {

    private static boolean ready;
    private static int number;

    public static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.println(number);
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
        Thread.sleep(10000);
    }

}
