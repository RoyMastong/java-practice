package com.example.javapractice.multithread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Junqi Chen
 * @time:2023/10/20
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
// 模拟倒计时
public class TestSleep2 {

    public static void main(String[] args) {
        // 获取当前系统时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis()); // 更新当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 模拟倒计时
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }
}
