package cn.zhy.thread;

/**
 * 实现suspend() 和 resume()方法功能
 * @date 2023年1月31日
 */
public class GoodSuspend {

    public static  Object u = new Object();

    public static  class ChangeObjectThread extends Thread{
        volatile  boolean suspendme = false;

        public void suspendMe(){
            suspendme = true;
        }

        public void resumeMe(){
            suspendme = false;
            synchronized (this){
                notify();
            }
        }

        @Override
        public void run(){
            while (true){
                synchronized (this){
                    while (suspendme){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    synchronized (u){
                        System.out.println("in ChangeObjectThread");
                    }
                    Thread.yield();
                }
            }
        }
    }

    public static class ReadObjectThread extends  Thread{

        @Override
        public void run(){
            while (true){
                synchronized (u){
                    System.out.println("in ReadObjectThread");
                }
                Thread.yield();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 sec");
        Thread.sleep(20000);
        System.out.println("resume t1");
        t1.resumeMe();
    }

}
