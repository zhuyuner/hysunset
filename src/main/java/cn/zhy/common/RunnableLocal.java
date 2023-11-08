package cn.zhy.common;


public class RunnableLocal  implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +" " +i);
        }
    }
    public static void main(String[] args){
        for(int i = 0; i< 100; i++){
            System.out.println(Thread.currentThread().getName() +"" + i);
            if(i ==20){

                new Thread(new RunnableLocal(),"新线程1").start();
                new Thread(new RunnableLocal(),"新线程2").start();
            }
        }
    }
}
