import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;
import org.junit.Test;

import java.io.*;
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
            options.put("spd","5");
            TtsResponse res = client.synthesis(ReadText(), "zh", 5, options);
//            TtsResponse res2 = client.synthesis("徐镇南,你最棒，徐镇南，你真长，徐镇南，你真大", "zh", 1, options);
            byte[] data = res.getData();
//            byte[] data1 = res2.getData();
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

    public static String ReadText(){
        File file = new File("/opt/dev/java/Maven/word.txt");
        StringBuffer sb = new StringBuffer();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader) ){
            System.out.println("开始读取文本");
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                sb.append(line);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文本读取失败");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("读取文本成功");
            return sb.toString();
        }
    }

    @Test
    public void demo(){
        String a = ReadText();
        System.out.println(a);
    }
}
