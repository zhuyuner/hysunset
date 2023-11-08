package cn.zhy.thread;

/**
 * wait() 和notify() 线程协作
 */
public class ThreadSimpleWN {

    final static Object obj = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            //T1 获取object对象监视器
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ":T1 start !");

                try {
                    System.out.println(System.currentTimeMillis() + "T1 wait for object");
                    //执行wait() 方法后，释放object对象锁
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end !");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            // 获得object对象锁
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread");
                obj.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end !");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();

        Thread.sleep(100000);
    }

}
