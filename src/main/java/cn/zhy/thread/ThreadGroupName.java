package cn.zhy.thread;

/**
 * 线程组
 * @date 2023年1月30日
 */
public class ThreadGroupName implements  Runnable{

    public static void main(String[] args){
        ThreadGroup tg = new ThreadGroup("printGr");
        Thread t1 = new Thread(tg,new ThreadGroupName(),"T1");
        Thread t2 = new Thread(tg,new ThreadGroupName(),"T2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();

    }


    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()+"-" + Thread.currentThread().getName();
        while (true){
            System.out.println("I AM " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
