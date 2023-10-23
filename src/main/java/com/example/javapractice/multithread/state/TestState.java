package com.example.javapractice.multithread.state;

/**
 * @author: Junqi Chen
 * @time:2023/10/20
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
public class TestState {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("//////");
            }
        });

        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state); // NEW

        // 观察启动后
        thread.start(); // 启动线程
        state = thread.getState();
        System.out.println(state); // RUNNABLE

        while (state != Thread.State.TERMINATED) {// 只要线程不终止，就一直输出状态
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 更新线程状态
            state = thread.getState();// 更新线程状态
            System.out.println(state); // 输出状态
        }


    }
}
