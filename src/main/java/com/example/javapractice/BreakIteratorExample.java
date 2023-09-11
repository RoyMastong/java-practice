package com.example.javapractice;

import com.ibm.icu.text.BreakIterator;

/**
 * @author: Junqi Chen
 * @time:2023/9/11
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
public class BreakIteratorExample {
    public static void main(String[] args) {
        String text = "Hello, Das Wetter ist heute schön！你好，蔚来中国";

        // 使用 Character BreakIterator 查找字符边界并打印结果
        printBoundaries("Character:", BreakIterator.getCharacterInstance(), text);

        // 使用 Word BreakIterator 查找单词边界并打印结果
        printBoundaries("Word:", BreakIterator.getWordInstance(), text);

        // 使用 Sentence BreakIterator 查找句子边界并打印结果
        printBoundaries("Sentence:", BreakIterator.getSentenceInstance(), text);
    }

    public static void printBoundaries(String label, BreakIterator iterator, String text) {
        iterator.setText(text);
        int start = iterator.first();
        int end = iterator.next();
        StringBuilder result = new StringBuilder();
        while (end != BreakIterator.DONE) {
            String boundary = text.substring(start, end);
            result.append(label + " " + boundary + " | ");
            start = end;
            end = iterator.next();
        }
        System.out.println(result.toString());
    }
}
