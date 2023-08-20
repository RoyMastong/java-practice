package com.example.javapractice;

import com.ibm.icu.text.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Locale;

@SpringBootTest
class JavaPracticeApplicationTests {

    @Test
    void test1() throws Exception {
//        System.out.println("hello junqi");
//        var i = "ewrr";
//        var k = 5;
//        System.out.println(i);
//        System.out.println(k);
//
//        String rule = "Any-Latin;Latin-Devanagari"; // 翻译规则
//        String sourceText = "Hello, world!"; // 源文本
//
//        Transliterator transliterator = Transliterator.getInstance(rule);
//        String translatedText = transliterator.transliterate(sourceText);
//
//        System.out.println("Translated text: " + translatedText);
//        var fdf = 4;






//
//        // 源文本
//        String text = "Hello! How are you doing? ICU is a powerful library for text processing.";
////        String text = "蔚来全新et5重磅来袭，大家可以凭蔚来app到各地nio house参观。冲啊！！！！";
//
//        // 使用 Sentence BreakIterator 查找句子边界
//        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance();
//        sentenceIterator.setText(text);
//
//        int sentenceStart = sentenceIterator.first();
//        int sentenceEnd = sentenceIterator.next();
//        while (sentenceEnd != BreakIterator.DONE) {
//            String sentence = text.substring(sentenceStart, sentenceEnd);
//            System.out.println("Sentence: " + sentence);
//
//            sentenceStart = sentenceEnd;
//            sentenceEnd = sentenceIterator.next();
//        }
//
//        System.out.println("-----------");
//
//        // 使用 Word BreakIterator 查找单词边界
//        BreakIterator wordIterator = BreakIterator.getWordInstance();
//        wordIterator.setText(text);
//
//        int wordStart = wordIterator.first();
//        int wordEnd = wordIterator.next();
//        while (wordEnd != BreakIterator.DONE) {
//            String word = text.substring(wordStart, wordEnd);
//            System.out.println("Word: " + word);
//
//            wordStart = wordEnd;
//            wordEnd = wordIterator.next();
//        }



        var input = "hello world! i am a girl";
        var turkishLocale = new Locale("tr", "TR");

        // 将字符串转换为大写
        var upperCase = CaseMap.toUpper().apply(turkishLocale, input);
        System.out.println("Upper Case: " + upperCase);

        // 将字符串转换为小写
        var lowerCase = CaseMap.toLower().apply(null, input);
        System.out.println("Lower Case: " + lowerCase);

        // 首字母大写
        var titleCase = CaseMap.toTitle().apply(null,null, input);
        System.out.println("Title Case: " + titleCase);

        var title = CaseMap.toTitle();

        // 大小写互换





        // 获取英语环境下的Collator
        Collator collator = Collator.getInstance(Locale.ENGLISH);

        // 待排序的字符串数组
        String[] strings = {"apple", "banana", "Orange", "grape"};

        // 对字符串数组进行排序
        Arrays.sort(strings, collator);

        // 打印排序后的结果
        System.out.println("Sorted strings:");
        for (String str : strings) {
            System.out.println(str);
        }



        // 自定义排序规则，将大写字母排在前面，小写字母排在后面
        // 自定义排序规则，将大写字母排在前面，小写字母排在后面
        String customRule = "&a < b < c < d < e < f < g < h < i < j < k < l < m < n < o < p < q < r < s < t < u < v < w < x < y < z";

        // 使用自定义规则创建 RuleBasedCollator
        var customCollator = new RuleBasedCollator(customRule);

        // 待排序的字符串数组
        String[] strings11111 = {"apple", "Banana", "Orange", "grape"};

        // 对字符串数组使用自定义规则进行排序
        Arrays.sort(strings11111, customCollator);

        // 打印排序后的结果
        System.out.println("Sorted strings using custom rule:");
        for (String str : strings11111) {
            System.out.println(str);
        }


    }

    @Test
    void testTranslate() throws Exception {

    }


}
