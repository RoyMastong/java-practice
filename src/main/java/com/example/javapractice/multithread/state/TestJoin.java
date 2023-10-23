package com.example.javapractice.multithread.state;

/**
 * @author: Junqi Chen
 * @time:2023/10/20
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
// 测试join方法，想象为插队
public class TestJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip线程来了" + i);
        }

    }

    public static void main(String[] args) {

        // 启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                try {
                    thread.join();//插队
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main" + i);
        }

    }
}
