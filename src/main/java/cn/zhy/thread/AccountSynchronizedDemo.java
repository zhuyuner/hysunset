package cn.zhy.thread;

/**
 * 线程安全，synchronized 同步方法
 *
 * @date 2023年1月31日
 */
public class AccountSynchronizedDemo {

    static AccountingSync instance = new AccountingSync();
    static int i = 0;

    public static class AccountingSync implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 10000000; j++) {
                synchronized (instance) {
                    i++;
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
