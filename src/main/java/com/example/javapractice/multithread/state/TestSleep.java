package com.example.javapractice.multithread.state;

/**
 * @author: Junqi Chen
 * @time:2023/10/20
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
// 模拟网络延时：放大问题的发生性
public class TestSleep implements Runnable {
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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread.currentThread().getName()获取当前线程的名字
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        // 创建Runnable接口的实现类对象
        TestSleep ticket = new TestSleep();

        // 创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛党").start();
    }

}
