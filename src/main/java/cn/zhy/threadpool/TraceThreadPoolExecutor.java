package cn.zhy.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 由于ThreadPoolExecutor 线程池，很有可能会迟到程序抛出的异常，所以需要对它进行扩展，将
 * 堆栈异常信息进行打印
 * 线程池扩展，方便打印堆栈信息
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void execute(Runnable task){
        super.execute(wrap(task,clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace(){
        return new Exception("Client stack trace");
    }

    /**
     *
     * @param task
     * @param clientStask   任务的线程堆栈信息
     * @param clientThreadName
     * @return
     */
    private Runnable wrap (final  Runnable task,final Exception clientStask,String clientThreadName){
        return  new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStask.printStackTrace();
                    throw e;
                }
            }
        };
    }

}
