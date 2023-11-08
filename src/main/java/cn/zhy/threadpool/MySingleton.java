package cn.zhy.threadpool;

/**
 * 双重加锁单例模式
 * @2023年8月21日
 * @author zhy
 */
public class MySingleton {

    private static  MySingleton  INSTANCE;


    private MySingleton(){

    }
    public static  MySingleton getInstance(){
        if(INSTANCE == null){
            synchronized (MySingleton.class){
                if(INSTANCE ==null){
                    INSTANCE = new MySingleton();
                }
            }
        }
        return INSTANCE;
    }

    public static void testIo(final  MySingleton singleton){
        synchronized (MySingleton.class){
            System.out.println(singleton);
        }

    }
}
