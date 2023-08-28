package com.example.javapractice;

import com.alibaba.fastjson.JSONArray;
import com.ibm.icu.text.CaseMap;
import com.ibm.icu.text.Collator;
import com.ibm.icu.text.RuleBasedCollator;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;


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
    public void testTranslate() throws Exception {

        var startTime = System.currentTimeMillis();
        System.out.println("-----test-----");
        String txt = "蔚来是高端智能电动汽车市场的先驱及领跑者。成立于2014年11月，蔚来的使命是创造愉悦的生活方式。" +
                "蔚来旨在打造一个以智能电动汽车为起点的社区，与用户分享欢乐、共同成长。蔚来设计、开发、合作制造及销售高端智能电动汽车，推动自动驾驶、数字技术、电动力总成及电池等新一代技术的创新。" +
                "蔚来通过持续的技术突破及创新使自己脱颖而出，例如我们领先行业的换电技术、电池租用服务(BaaS)、自研的自动驾驶技术及自动驾驶订阅服务(ADaaS)。" +
                "蔚来的产品组合包括六座智能电动旗舰SUV ES8、中大型五座智能电动SUV ES7（或EL7）、五座全场景智能电动SUV ES6、五座智能电动旗舰轿跑SUV EC7、五座智能电动轿跑SUV EC6、智能电动旗舰轿车ET7、中型智能电动轿车ET5及智能电动旅行車ET5 Touring。";
        var g = GT.getInstance();
        System.out.println(g.translateText(txt, "zh", "en"));
        System.out.println(g.translateText("谁能说支持不支持", "auto", "en"));

        var endTime = System.currentTimeMillis();
        var costTime = (double) startTime - endTime / 1000.0;
        System.out.println("总耗时：" + costTime + "s");
    }


    /**
     * 谷歌翻译类
     */
    static class GT {

        private static final String PATH = "https://translate.googleapis.com/translate_a/single"; //地址
        private static final String CLIENT = "gtx";

        private static final String USER_AGENT = "Mozilla/5.0";//"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36";

        private static final Map<String, String> LANGUAGE_MAP = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("auto", "Automatic"),
                new AbstractMap.SimpleEntry<>("af", "Afrikaans"),
                new AbstractMap.SimpleEntry<>("sq", "Albanian"),
                new AbstractMap.SimpleEntry<>("am", "Amharic"),
                new AbstractMap.SimpleEntry<>("ar", "Arabic"),
                new AbstractMap.SimpleEntry<>("hy", "Armenian"),
                new AbstractMap.SimpleEntry<>("az", "Azerbaijani"),
                new AbstractMap.SimpleEntry<>("eu", "Basque"),
                new AbstractMap.SimpleEntry<>("be", "Belarusian"),
                new AbstractMap.SimpleEntry<>("bn", "Bengali"),
                new AbstractMap.SimpleEntry<>("bs", "Bosnian"),
                new AbstractMap.SimpleEntry<>("bg", "Bulgarian"),
                new AbstractMap.SimpleEntry<>("ca", "Catalan"),
                new AbstractMap.SimpleEntry<>("ceb", "Cebuano"),
                new AbstractMap.SimpleEntry<>("ny", "Chichewa"),
                new AbstractMap.SimpleEntry<>("zh_cn", "Chinese Simplified"),
                new AbstractMap.SimpleEntry<>("zh_tw", "Chinese Traditional"),
                new AbstractMap.SimpleEntry<>("co", "Corsican"),
                new AbstractMap.SimpleEntry<>("hr", "Croatian"),
                new AbstractMap.SimpleEntry<>("cs", "Czech"),
                new AbstractMap.SimpleEntry<>("da", "Danish"),
                new AbstractMap.SimpleEntry<>("nl", "Dutch"),
                new AbstractMap.SimpleEntry<>("en", "English"),
                new AbstractMap.SimpleEntry<>("eo", "Esperanto"),
                new AbstractMap.SimpleEntry<>("et", "Estonian"),
                new AbstractMap.SimpleEntry<>("tl", "Filipino"),
                new AbstractMap.SimpleEntry<>("fi", "Finnish"),
                new AbstractMap.SimpleEntry<>("fr", "French"),
                new AbstractMap.SimpleEntry<>("fy", "Frisian"),
                new AbstractMap.SimpleEntry<>("gl", "Galician"),
                new AbstractMap.SimpleEntry<>("ka", "Georgian"),
                new AbstractMap.SimpleEntry<>("de", "German"),
                new AbstractMap.SimpleEntry<>("el", "Greek"),
                new AbstractMap.SimpleEntry<>("gu", "Gujarati"),
                new AbstractMap.SimpleEntry<>("ht", "Haitian Creole"),
                new AbstractMap.SimpleEntry<>("ha", "Hausa"),
                new AbstractMap.SimpleEntry<>("haw", "Hawaiian"),
                new AbstractMap.SimpleEntry<>("iw", "Hebrew"),
                new AbstractMap.SimpleEntry<>("hi", "Hindi"),
                new AbstractMap.SimpleEntry<>("hmn", "Hmong"),
                new AbstractMap.SimpleEntry<>("hu", "Hungarian"),
                new AbstractMap.SimpleEntry<>("is", "Icelandic"),
                new AbstractMap.SimpleEntry<>("ig", "Igbo"),
                new AbstractMap.SimpleEntry<>("id", "Indonesian"),
                new AbstractMap.SimpleEntry<>("ga", "Irish"),
                new AbstractMap.SimpleEntry<>("it", "Italian"),
                new AbstractMap.SimpleEntry<>("ja", "Japanese"),
                new AbstractMap.SimpleEntry<>("jw", "Javanese"),
                new AbstractMap.SimpleEntry<>("kn", "Kannada"),
                new AbstractMap.SimpleEntry<>("kk", "Kazakh"),
                new AbstractMap.SimpleEntry<>("km", "Khmer"),
                new AbstractMap.SimpleEntry<>("ko", "Korean"),
                new AbstractMap.SimpleEntry<>("ku", "Kurdish (Kurmanji)"),
                new AbstractMap.SimpleEntry<>("ky", "Kyrgyz"),
                new AbstractMap.SimpleEntry<>("lo", "Lao"),
                new AbstractMap.SimpleEntry<>("la", "Latin"),
                new AbstractMap.SimpleEntry<>("lv", "Latvian"),
                new AbstractMap.SimpleEntry<>("lt", "Lithuanian"),
                new AbstractMap.SimpleEntry<>("lb", "Luxembourgish"),
                new AbstractMap.SimpleEntry<>("mk", "Macedonian"),
                new AbstractMap.SimpleEntry<>("mg", "Malagasy"),
                new AbstractMap.SimpleEntry<>("ms", "Malay"),
                new AbstractMap.SimpleEntry<>("ml", "Malayalam"),
                new AbstractMap.SimpleEntry<>("mt", "Maltese"),
                new AbstractMap.SimpleEntry<>("mi", "Maori"),
                new AbstractMap.SimpleEntry<>("mr", "Marathi"),
                new AbstractMap.SimpleEntry<>("mn", "Mongolian"),
                new AbstractMap.SimpleEntry<>("my", "Myanmar (Burmese)"),
                new AbstractMap.SimpleEntry<>("ne", "Nepali"),
                new AbstractMap.SimpleEntry<>("no", "Norwegian"),
                new AbstractMap.SimpleEntry<>("ps", "Pashto"),
                new AbstractMap.SimpleEntry<>("fa", "Persian"),
                new AbstractMap.SimpleEntry<>("pl", "Polish"),
                new AbstractMap.SimpleEntry<>("pt", "Portuguese"),
                new AbstractMap.SimpleEntry<>("ma", "Punjabi"),
                new AbstractMap.SimpleEntry<>("ro", "Romanian"),
                new AbstractMap.SimpleEntry<>("ru", "Russian"),
                new AbstractMap.SimpleEntry<>("sm", "Samoan"),
                new AbstractMap.SimpleEntry<>("gd", "Scots Gaelic"),
                new AbstractMap.SimpleEntry<>("sr", "Serbian"),
                new AbstractMap.SimpleEntry<>("st", "Sesotho"),
                new AbstractMap.SimpleEntry<>("sn", "Shona"),
                new AbstractMap.SimpleEntry<>("sd", "Sindhi"),
                new AbstractMap.SimpleEntry<>("si", "Sinhala"),
                new AbstractMap.SimpleEntry<>("sk", "Slovak"),
                new AbstractMap.SimpleEntry<>("sl", "Slovenian"),
                new AbstractMap.SimpleEntry<>("so", "Somali"),
                new AbstractMap.SimpleEntry<>("es", "Spanish"),
                new AbstractMap.SimpleEntry<>("su", "Sundanese"),
                new AbstractMap.SimpleEntry<>("sw", "Swahili"),
                new AbstractMap.SimpleEntry<>("sv", "Swedish"),
                new AbstractMap.SimpleEntry<>("tg", "Tajik"),
                new AbstractMap.SimpleEntry<>("ta", "Tamil"),
                new AbstractMap.SimpleEntry<>("te", "Telugu"),
                new AbstractMap.SimpleEntry<>("th", "Thai"),
                new AbstractMap.SimpleEntry<>("tr", "Turkish"),
                new AbstractMap.SimpleEntry<>("uk", "Ukrainian"),
                new AbstractMap.SimpleEntry<>("ur", "Urdu"),
                new AbstractMap.SimpleEntry<>("uz", "Uzbek"),
                new AbstractMap.SimpleEntry<>("vi", "Vietnamese"),
                new AbstractMap.SimpleEntry<>("cy", "Welsh"),
                new AbstractMap.SimpleEntry<>("xh", "Xhosa"),
                new AbstractMap.SimpleEntry<>("yi", "Yiddish"),
                new AbstractMap.SimpleEntry<>("yo", "Yoruba"),
                new AbstractMap.SimpleEntry<>("zu", "Zulu")
        );

        private static final GT _instance = new GT();

        /**
         * 获取单例
         *
         * @return
         */
        public static GT getInstance() {
            return _instance;
        }

        /**
         * 初始化语言类
         */
        Map<String, String> LANGUAGE_MAP1 = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("auto", "Automatic")
        );


        /**
         * 判断语言是否支持
         *
         * @param language
         * @return
         */
        public boolean isSupport(String language) {
            return LANGUAGE_MAP.containsKey(language);
        }

        /**
         * 获取 语言代码
         * ISO 639-1 code
         *
         * @param desiredLang 语言
         * @return 如果返回null则标示不支持
         */
        public String getCode(String desiredLang) {
            if (LANGUAGE_MAP.containsKey(desiredLang)) {
                return desiredLang;
            }
            var tmp = desiredLang.toLowerCase();
            return LANGUAGE_MAP.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().equalsIgnoreCase(tmp))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);
        }

        /**
         * 翻译文本
         *
         * @param text       文本内容
         * @param sourceLang 文本所属语言。如果不知道，可以使用auto
         * @param targetLang 目标语言。必须是明确的有效的目标语言
         * @return
         * @throws Exception
         */
        public String translateText(String text, String sourceLang, String targetLang) throws Exception {

            if (!(isSupport(sourceLang) || isSupport(targetLang))) {
                throw new Exception("不支持的语言类型");
            }

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("client", CLIENT));
            nvps.add(new BasicNameValuePair("sl", sourceLang));
            nvps.add(new BasicNameValuePair("tl", targetLang));
            nvps.add(new BasicNameValuePair("dt", "t"));
            nvps.add(new BasicNameValuePair("q", text));

            var resp = postHttp(PATH, nvps);
            if (null == resp) {
                throw new Exception("网络异常");
            }
            var jsonObject = JSONArray.parseArray(resp);
            return jsonObject.getJSONArray(0)
                    .stream()
                    .map(o -> ((JSONArray) o).getString(0))
                    .collect(Collectors.joining());
        }

        /**
         * post 请求
         *
         * @param url  请求地址
         * @param nvps 参数列表
         * @return
         * @throws UnsupportedEncodingException
         */
        private String postHttp(String url, List<NameValuePair> nvps) {
            String responseStr = null;
            try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
                HttpPost httpPost = new HttpPost(url);
                httpPost.setHeader("User-Agent", USER_AGENT);
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8")));

                try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                    HttpEntity entity = response.getEntity();
                    responseStr = EntityUtils.toString(entity);
                    EntityUtils.consume(entity);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return responseStr;
        }

    }



}
