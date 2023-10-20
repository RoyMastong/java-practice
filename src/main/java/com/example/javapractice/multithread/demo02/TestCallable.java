package com.example.javapractice.multithread.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author: Junqi Chen
 * @time:2023/10/19
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
// 线程创建方式3：实现Callable接口

/**
 * callable的好处
 * 1. 可以定义返回值
 * 2. 可以抛出异常
 */

public class TestCallable implements Callable<Boolean> {

    private String url; // 网络图片地址
    private String name; // 保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TestCallable t1 = new TestCallable("https://upload-images.jianshu.io/upload_images/2411388-b39ceb1c2dc5a569.png", "1.png");
        TestCallable t2 = new TestCallable("https://upload-images.jianshu.io/upload_images/2411388-d80b6825cd00fb0d.png", "2.png");
        TestCallable t3 = new TestCallable("https://upload-images.jianshu.io/upload_images/2411388-654b2a938885224c.png", "3.png");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 获取结果

        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        // 关闭服务
        ser.shutdownNow();

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
