package cn.zhy.common;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableLocal {
    public static void main(String[] args) {
        CallableLocal rt = new CallableLocal();
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "" + i);

            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "" + i);
            if (i == 20) {
                new Thread(task, "有返回的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
