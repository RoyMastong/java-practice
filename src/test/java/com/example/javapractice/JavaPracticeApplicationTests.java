package com.example.javapractice;

import com.ibm.icu.text.Transliterator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaPracticeApplicationTests {

    @Test
    void test1() {
        System.out.println("hello junqi");
        var i = "ewrr";
        var k = 5;
        System.out.println(i);
        System.out.println(k);

        String rule = "Any-Latin;Latin-Devanagari"; // 翻译规则
        String sourceText = "Hello, world!"; // 源文本

        Transliterator transliterator = Transliterator.getInstance(rule);
        String translatedText = transliterator.transliterate(sourceText);

        System.out.println("Translated text: " + translatedText);
        var fdf = 4;

    }

}
