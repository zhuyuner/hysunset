package cn.zhy.thread;

import java.util.*;
import java.util.concurrent.*;

/**
 * fork join , RecursiveTask作为任务得模型，携带Long 返回类型
 */
public class ForkJoinCountThread extends RecursiveTask<Long> {

    // 任务分解得规模
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinCountThread(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 对任务进行分解，拆分成100个小任务
            long step = (start + end) / 100;
            ArrayList<ForkJoinCountThread> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos+step;
                if(lastOne> end) {
                    lastOne = end;
                }
                    ForkJoinCountThread subTask = new ForkJoinCountThread(pos,lastOne);
                    pos+= step+1;
                    //保存所有的子任务
                    subTasks.add(subTask);
                    //提交子任务
                    subTask.fork();
                }
                // 子任务结束，将结果进行再次求和
                for (ForkJoinCountThread t :subTasks){
                    sum+= t.join();
                }
            }
            return sum;
        }

        public static void main (String[]args) throws ExecutionException, InterruptedException {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            ForkJoinCountThread task = new ForkJoinCountThread(0,200000L);
            ForkJoinTask<Long> result = forkJoinPool.submit(task);
            long res = result.get();
            System.out.println("sum=" +res);



        }
    }
