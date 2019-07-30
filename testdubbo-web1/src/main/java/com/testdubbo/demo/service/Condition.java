package com.testdubbo.demo.service;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xulei on 2019/6/25.
 */
public class Condition {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("7个人已经聚齐，出发");
                sunmon();
            }
        });

        for(int i=0;i<7;i++){
            int a = i;
            new Thread(() -> {
               System.out.println("第"+a+"个人到了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    public static void sunmon(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("集齐了，开始执行");
            }
        });

        for(int i = 0;i<7;i++){
            int a = i;
            new Thread(() -> {
               System.out.println("第"+a+"集齐");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    class SaveTread extends Thread{

        private String name;

        private MyCount myCount;

        private int cash;

        public void run(){
            myCount.save(cash,name);
        }

    }

    class TakeThread extends Thread{

        private String name;

        private MyCount myCount;

        private int cash;

        public void run(){
            myCount.take(cash,name);
        }
    }

    class MyCount{

        private String id;

        private int cash;

        private int total=100;
        private Lock lock = new ReentrantLock();
        private java.util.concurrent.locks.Condition csave = lock.newCondition();

        private java.util.concurrent.locks.Condition ctake = lock.newCondition();

        public MyCount(String id,int cash){
            this.id=id;
            this.cash=cash;
        }

        private void take(int x,String name){
            while(cash-x<0){
                try {
                    ctake.await();
                    System.out.print("余额不够，中断取钱");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cash-=x;
            System.out.print(name+"取了"+x+",还剩"+cash);
            csave.signalAll();
        }

        private void save(int x,String name){
            lock.lock();
            while (cash==total){
                try {
                    csave.await();
                    System.out.print("钱满了"+name+"停止存钱");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cash+=x;
            System.out.print(name+"存入"+x+"，余额"+cash);
            lock.unlock();
        }
    }
}
