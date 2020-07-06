package com.example.constellation.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    public static String getJSONFromNet(String path){
            String json = "";
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        1.将路径转换成url对象
            try {
                URL url = new URL(path);
//            2.获取网络连接对象
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            3.开始连接
                conn.connect();
//            4.读取输入流当中内容
                InputStream is = conn.getInputStream();
//            5.读取流
                int hasRead = 0;
                byte[]buf = new byte[1024];
//            循环读取
                while (true){
                    hasRead = is.read(buf);
                    if (hasRead == -1) {
                        break;
                    }
                    baos.write(buf,0,hasRead);
                }
                is.close();
                json = baos.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }


            return json;
        }
}
