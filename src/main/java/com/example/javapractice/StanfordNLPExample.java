package com.example.javapractice;

import com.example.javapractice.entity.Pipeline;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

/**
 * @author: Junqi Chen
 * @time:2023/9/11
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */
public class StanfordNLPExample {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        // 文本
        String text = "The men ate too much.";
        // 创建文本处理对象
        CoreDocument doc = new CoreDocument(text);
        // 处理文本
        stanfordCoreNLP.annotate(doc);
        // 获取词型还原的结果
        for (CoreLabel token : doc.tokens()) {
            String word = token.originalText(); // 原始词汇
            String lemma = token.lemma(); // 词型还原后的词汇
            String pos = token.tag(); // 词性标签
            System.out.println("原始词汇: " + word);
            System.out.println("词型还原: " + lemma);
            System.out.println("词性标签: " + pos);
            System.out.println("--------------------");
        }
    }
}
