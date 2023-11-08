package cn.zhy.thread;


import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class Account {

    private  final  ReentrantLock lock = new ReentrantLock();


    private String accountNo ;
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount){

        if(balance>=drawAmount){
            System.out.println(Thread.currentThread().getName() +"取钱成功呢！ 吐出钞票");

            try {
                lock.lock();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -=drawAmount;
            System.out.println("\t余额为："+ balance);
        }else{
            System.out.println(Thread.currentThread().getName() +"余额不足，取钱失败！");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj != null && obj.getClass() ==Account.class){
            Account target  = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return  false;
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
