package com.example.javapractice;

import org.tartarus.snowball.ext.PorterStemmer;

/**
 * @author: Junqi Chen
 * @time:2023/9/11
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
public class PorterStemmingExample {

    public static void main(String[] args) {
        // 创建一个Porter Stemmer实例
        PorterStemmer stemmer = new PorterStemmer();

        // 要进行词干提取的单词
        String word = "fisher";

        // 设置要提取的单词
        stemmer.setCurrent(word);

        // 执行词干提取
        if (stemmer.stem()) {
            // 获取提取后的词干
            String stem = stemmer.getCurrent();
            System.out.println("Word: " + word + ", 词干提取结果Stem: " + stem);
        }
    }

}
