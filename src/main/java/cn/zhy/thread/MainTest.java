package cn.zhy.thread;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new ThreadPrinterA());
        Thread t2 = new Thread(new ThreadPrintB());
        Thread t3 = new Thread(new ThreadPrintC());
//        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
//        t1.start();
        t2.start();
        t3.start();
//        t1.join();
      t2.join(); t3.join();
    }
}
