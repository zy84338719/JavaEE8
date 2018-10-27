
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
import java.util.Set;

public class Main {

    //搜索地址


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //输入单词
        String word = in.next();
        //拼接搜索结果
        Map<String,String> a = fanyi.getMess(word);
        Set<String> w = a.keySet();
        for(String ww:w){
            System.out.println(ww+" "+a.get(ww));
        }
    }

}
