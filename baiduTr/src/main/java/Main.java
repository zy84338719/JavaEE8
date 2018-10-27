
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
import java.util.Scanner;

public class Main {

    //搜索地址
    public static final String preUrl= "http://www.baidu.com/s?wd=";

    public static void main(String[] args){


        Scanner in = new Scanner(System.in);
        //输入单词
        String word = in.next();
        //拼接搜索结果
        String a = getMessage(word).html();
        System.out.println(a);
    }
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
    public static Elements getMessage(String word){
        String code = getContent(word);
        Document document = Jsoup.parse(code);
        Elements content = document.select("div.op_dict_content");
        return content;
    }
}
