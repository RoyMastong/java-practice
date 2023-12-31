package com.example.javapractice.multithread.state;

/**
 * @author: Junqi Chen
 * @time:2023/10/20
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();

    }

}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
