package cn.zhy.thread;

/**
 * 线程不安全问题
 * @date 2023年1月17日
 */
public class DrawThread  extends Thread{
    private Account account;

    private  double drawAmount;
    public DrawThread(String name, Account account,double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run(){
        /*if(account.getBalance() >=drawAmount){
            System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //修改余额
            account.setBalance(account.getBalance() -drawAmount);
            System.out.println("\t余额为：" + account.getBalance());
        }else {
            System.out.println(getName() +"取钱失败！余额不足！");
        }
*/
        account.draw(drawAmount);
    }

    public static void main(String[] args){
        Account acct = new Account("112323",1000);
        new DrawThread("小明",acct,800).start();
        new DrawThread("小红",acct,800).start();

    }
}
