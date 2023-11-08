package cn.zhy.tengxunkt;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 并发特性—原子性
 * -Djava.compiler=NONE —> JIT 关闭
 */

@Slf4j
public class Jmm04CodeAtomic {

    private  volatile static  int counter = 0;
   private  static Object obj = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (obj) {
                        counter++; //分三步 读，自加 ，写
                    }
                }
            });
            thread.start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);


    }


}
