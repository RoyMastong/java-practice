package com.example.javapractice.multithread.demo01;

/**
 * @author: Junqi Chen
 * @time:2023/10/19
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
// 多个线程同时操作同一个对象
// 买火车票的例子
// 发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestThread4 implements Runnable {

    // 票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread.currentThread().getName()获取当前线程的名字
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        TestThread4 ticket = new TestThread4();

        // 创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();
    }
}
