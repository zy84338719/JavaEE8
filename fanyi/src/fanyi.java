import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class fanyi {
    public static final String preUrl= "http://www.baidu.com/s?wd=";

    public static String getContent(String word){
        String newUrl = preUrl+word;

        StringBuffer content= new StringBuffer();
        try {
            //初始化连接
            URL url = new URL(newUrl);
            //建立连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //获取输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //获取信息
            String temp;

            while ((temp = reader.readLine())!= null){
                content.append(temp).append("\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    public static Map<String, String> getMess(String word){
        Map<String, String> dic = new HashMap<String, String>();
        String code = getContent(word);
        Document document = Jsoup.parse(code);
//        Elements content = document.select("div.op_dict_content");
        Elements content = document.select("div.op_dict_content");

        Elements op_dict_text0 = content.select("table.op_dict_table>tbody>tr>td>span");
        Elements op_dict_text1 = content.select("span.op_dict_text1");
        Elements op_dict_text2 = content.select("span.op_dict_text2");
        Element name = op_dict_text0.get(0);
        Elements cx = ()->Elements cx for (int i = 0; i < op_dict_text1.size()-1; i++) {
            cx.set(i,op_dict_text1.get(i));
        }
        dic.put("name",name.html());
        dic.put("cx", )
        for(int i=0,len= op_dict_text1.size();i<len;i++){
            dic.put(op_dict_text1.get(i).html(),op_dict_text2.get(i).html());
        }

        return dic;
    }
}
