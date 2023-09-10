package com.example.javapractice;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author: Junqi Chen
 * @time:2023/9/10
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
public class ResourceBundleExample {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); // 设置默认语言环境为英语

        ResourceBundle bundle = ResourceBundle.getBundle("MyResources");

        String greeting = bundle.getString("greeting");
        System.out.println("默认语言环境：" + Locale.getDefault());
        System.out.println("问候语：" + greeting);//输出：Hello, World!

        Locale frenchLocale = new Locale("fr", "FR");
        bundle = ResourceBundle.getBundle("MyResources", frenchLocale);

        greeting = bundle.getString("greeting");
        System.out.println("\n法语语言环境：" + frenchLocale);
        System.out.println("问候语：" + greeting);//输出：Bonjour, le Monde !
    }
}
