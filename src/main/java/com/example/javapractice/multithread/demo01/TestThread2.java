package com.example.javapractice.multithread.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author: Junqi Chen
 * @time:2023/10/19
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */

// 练习Thread，实现多线程同步下载图片
public class TestThread2 implements Runnable {

    private String url; // 网络图片地址
    private String name; // 保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        // 给一个图片能打开的网址，不要这个https://img-blog.csdnimg.cn/20211019105948109.png，这个打不开

        TestThread2 t1 = new TestThread2("https://upload-images.jianshu.io/upload_images/2411388-b39ceb1c2dc5a569.png", "1.png");
        TestThread2 t2 = new TestThread2("https://upload-images.jianshu.io/upload_images/2411388-d80b6825cd00fb0d.png", "2.png");
        TestThread2 t3 = new TestThread2("https://upload-images.jianshu.io/upload_images/2411388-654b2a938885224c.png", "3.png");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}


// 下载器
class WebDownloader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}