package com.example.hysunset.thread;

public class DrawSyncClassTest extends Thread {
    private Account account;
    private double drawAmount;

    public DrawSyncClassTest(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        //使用account 作为同步监视器，任何线程进入下面同步代码块之前，必须先获得account账户的锁定-----其他线程无法获得锁，也就无法进行修改
        //这种做法符合：”加锁---修改---释放锁“的逻辑
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("\t余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "取钱失败！余额不足！");
            }
        }
    }

    public static void main(String[] args) {
        Account acct = new Account("112323", 1000);
        new DrawSyncClassTest("小明", acct, 800).start();
        new DrawSyncClassTest("小红", acct, 800).start();

    }
}
