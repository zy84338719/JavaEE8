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
        public static final String APP_ID = "";
        public static final String API_KEY = "";
        public static final String SECRET_KEY = "";

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
            System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

            // 调用接口
            HashMap<String, Object> options = new HashMap<String, Object>();
            options.put("per", "1");
            TtsResponse res = client.synthesis("党的十九大报告在充分肯定党的十八大以来坚定不移贯彻新发展理念取得巨大成就的基础上，将坚持新发展理念确立为新时代坚持和发展中国特色社会主义的一条基本方略。去年底召开的中央经济工作会议指出，5年来，我们坚持观大势、谋全局、干实事，成功驾驭了我国经济发展大局，在实践中形成了以新发展理念为主要内容的习近平新时代中国特色社会主义经济思想。这进一步明确了新发展理念的指导地位。我们必须把思想统一到党中央精神上来，结合新时代发展实践，更深入地理解新发展理念的科学内涵和实践要求。", "zh", 1, options);
            byte[] data = res.getData();
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
