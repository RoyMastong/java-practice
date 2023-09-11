package com.example.javapractice.entity;

/**
 * @author: Junqi Chen
 * @time:2023/9/11
 * @Email:junqiqi77_chen@foxmail.com
 * @desc:
 */

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

/**
 * @author junqi.chen
 */

public class Pipeline {

    private static Properties properties;
    private static String propertiesName = "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote,stem";
    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() {

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    public static StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }


}
