package cn.zhy.shejimoshi;

/**
 * 懒汉设计模式
 * @author zhy
 *
 */
public class DoubleCheckLock {
    //volatile 可以禁止指令重排
    private  volatile static  DoubleCheckLock instance;
    private DoubleCheckLock(){}
    public static DoubleCheckLock getInstance(){
        if(instance ==null){
            synchronized (DoubleCheckLock.class){
                if(instance ==null){
                    //多线程环境下可能会出现问题，原因在于某一个线程执行到第一次检测，读取到的instance 不为null 时，instnce
                    //的引用对象可能完全没有初始化
                    // new DoubleCheck() 分为3步完成，1. 分配对象内存空间  2. 初始化对象 3. 设置instance 指向刚分配的内存地址，
                    //此时 instance ！=null
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
