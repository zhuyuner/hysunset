package cn.zhy.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 并发下的hashMap,线程不安全
 * 下面的示例会造成死循环，尤其是jdk1.7版本的HashMap，1.8其内部实现做了很大规模的调整，规避了死循环问题，但是
 * 多线程环境下使用，依然会导致内部数据不一致。最好的解决方案，使用concurrentHashMap 代替HashMap
 * @author zhy
 * @date  2023年2月1日 15:58
 */
public class HashMapMultiThread {

    static Map<String ,String> map = new HashMap<String,String>();
    public static class  AddThread implements  Runnable{
        int start = 0;
        public AddThread(int start){
            this.start = start;
        }
        @Override
        public void run(){
            for(int i=start; i<100000; i+=2){
                map.put(Integer.toString(i),Integer.toString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new HashMapMultiThread.AddThread(0));
        Thread t2 = new Thread(new HashMapMultiThread.AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }

}
