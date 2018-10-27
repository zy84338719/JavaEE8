import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

//百度TTS 语音测试apiDemo
public class AIPDemo {
    public static class Sample {
        //设置APPID/AK/SK
        public static final String APP_ID = "14430235";
        public static final String API_KEY = "9IWKLuChibsv63k8TH0zV6Bn";
        public static final String SECRET_KEY = "tYl5UOjOFrd4yWGKmGrrY6SdChWSF9Nu";

        public static void main(String[] args) {
            // 初始化一个AipSpeech
            AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);

            // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//            client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//            client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

            // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
            // 也可以直接通过jvm启动参数设置此环境变量
            System.setProperty("aip.log4j.conf", "./log4j.properties");

            // 调用接口
            HashMap<String, Object> options = new HashMap<String, Object>();
            options.put("per", "4");
            TtsResponse res = client.synthesis("　　正在央视播出的《平“语”近人——习近平总书记用典》引起知识界热烈反响。海河之滨，清华园里，西子湖畔，黑土地上，祁连山麓，广大知识分子重温重要讲话，再读经典篇章，深为习近平新时代中国特色社会主义思想所鼓舞，为习近平总书记的语言魅力所折服，为中国优秀传统文化的博大精深所感染。大家一致认为，平语，是习近平总书记的语言，是武装全党、推动工作、指导实践的重要理论依据和根本遵循。平语，是平实晓畅的语言，是党的领导核心与普通百姓的贴心话、连心语，是引领我们创造美好生活的谆谆教导和悉心嘱托。习近平总书记用典是习近平新时代中国特色社会主义思想与中华优秀传统文化的对接与交融，是中国智慧、中国力量、中国风范的当代体现。 　　“治国有常，而利民为本”“政之所兴在顺民心”“究天人之际”“通古今之变”，再次诵读习近平总书记用典，人们更真切地体会到习近平总书记许党许国的爱民情怀和夙夜在公的不懈斗志。 　　东北大学马克思主义学院院长田鹏颖教授表示，习近平新时代中国特色社会主义思想之所以在全社会引起广泛共鸣，最根本的原因在于这一思想把共产党执政规律、社会主义建设规律、人类社会发展规律与广大人民的意志与情感、创造与建构高度统一起来，既符合规律性，又符合目的性。“传统文化”“中国智慧”“人类命运共同体”，都深深地包含规律性和目的性、必然性与选择性。正是由于平语，把以人民为中心作为新时代社会主要矛盾转化的判定依据和发展要求、作为新时代中国特色社会主义事业顶层设计的内在逻辑、作为新时代衡量党和国家一切工作得失的根本标准，广大人民才义无反顾地走近平语，才有平语近人。 　　西北大学中国思想文化研究所副所长谢扬举教授认为，《平“语”近人——习近平总书记用典》第一集就从“人民”这个有温度的中心词切入，抓住了习近平总书记治国理政的关键词和出发点，体现了中国共产党人不忘初心的职责担当和深厚的人民情怀。“利民之事，丝发必兴；厉民之事，毫末必去。”理解了中国共产党人的人民观，就理解了我们今天所坚持的道路和事业。 　　浙江省社会科学院文化研究所副研究员宋雪玲说，执政为民，最终要落实在一件件实事中，这样人民群众才能以德报德，实现党群关系的良性互动。习近平总书记在理论上鲜明提出、在实践上明确要求以人民利益为出发点和落脚点，注重把人民群众关心的事落细落小落实，在习近平总书记的系列重要讲话中，我们总能看到他引用经典，阐释“以百姓之心为心”的发展理念，体现了我们党在理论建设和具体实践中不忘初心的根本特征。 　　河南豫剧院院长、著名豫剧表演艺术家李树建，河南小皇后豫剧团团长、著名豫剧表演艺术家王红丽认为，《平“语”近人——习近平总书记用典》是一档有着厚重文化底蕴的节目，表现形式通俗简洁，令人耳目一新，深受教育。第一集的主题是以人民为中心，作为一名文艺工作者，最根本的就是始终坚持以人民为中心的创作演出导向，始终把社会效益放在第一位，深入到群众中间，把握新时代发展脉搏，创作叫好又叫座的优秀作品。 　　《平“语”近人——习近平总书记用典》充分展示了习近平总书记深入浅出、春风化雨的语言风格，体现了习近平总书记深入基层、结合实际的扎实作风。一次次重要讲话，一回回考察交谈，习近平总书记总能把深刻的道理讲得清清楚楚，把宏伟的蓝图描绘得细腻入微。 　　清华大学马克思主义学院院长艾四林教授认为，习近平总书记的语言风格一是“亲近”，二是“贴近”。亲近就有亲和力。习近平总书记无论用典还是讲道理，都善于说百姓话、大白话、家常话，语言朴实自然，让人感觉亲切亲和，把深刻的道理讲得浅显易懂，易于接受。贴近则是指总书记的讲话贴近民心，有很强的吸引力。看似信手拈来的经典话语，句句微言大义，反映百姓心声，回应百姓关切，读来入脑入心。习近平总书记不仅说到，而且身体力行，知行合一，让人既能明白道理，又能知道如何去做。 　　中国作协影视委员会副主任范咏戈说，习近平总书记用典让我们感受到传统文化的魅力，让我们在重温历史经典中感受文化的美好，在弘扬传统中更加自觉地投入文化的社会实践。在全国宣传思想工作会议上，习近平总书记要求广大文化文艺工作者用健康向上的文艺作品和做人处事陶冶情操、启迪心智、引领风尚。包括文化文艺工作", "zh", 1, options);
            TtsResponse res2 = client.synthesis("徐镇南,你最棒，徐镇南，你真长，徐镇南，你真大", "zh", 1, options);
            byte[] data = res.getData();
            byte[] data1 = res2.getData();
            JSONObject res1 = res.getResult();
            if (data != null) {
                try {
                    Util.writeBytesToFileSystem(data, "output.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (res1 != null) {
                System.out.println(res1.toString(2));
            }

        }
    }

}
