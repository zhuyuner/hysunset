package cn.zhy.thread;

/**
 * Integer 是不变对象,一旦创建，就不可能被修改
 * 所以两个线程每次加锁，都是加在不通的对象实例上
 * @author  zhy
 * @date 2023年2月1日 17:12
 */
public class BadLockOnInteger implements Runnable {
    public static  Integer i = 0 ;
    static BadLockOnInteger instance =  new BadLockOnInteger();

    @Override
    public void run() {
        for (int j= 0 ; j<1000000; j++){
//            synchronized (i){
                // 修改，优化，锁加在instance 上
                synchronized (instance){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2= new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
