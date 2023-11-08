package com.example.hysunset.tengxunkt;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * 并发—可见性
 * -Djava.compiler=NONE —> JIT 关闭
 */

@Slf4j
public class Jmm03CodeVisibility {
//    private volatile static  boolean initFlag = false;

    private  static  boolean initFlag = false;
    private static int current = 0;
//    private static Integer current = 0;

    public static  void reflesh(){
        log.info("refresh data.....");
        initFlag = true;
        log.info("refresh data success....");
    }

    public static void main(String[] args){
        Thread threadA = new Thread(()->{
            while (!initFlag){
                current++;
            }
            log.info("线程："+Thread.currentThread().getName()+"当前线程嗅到initFlag的状态改变");
        });
        threadA.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadB = new Thread(()->{
            reflesh();

        });
        threadB.start();
    }



}
