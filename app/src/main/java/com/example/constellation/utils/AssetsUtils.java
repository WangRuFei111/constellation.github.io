package com.example.constellation.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.constellation.bean.StarBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *读取Assets文件夹中的工具类
 */
public class AssetsUtils {

    private static Map<String,Bitmap>logoImgMap;
    private static Map<String,Bitmap>contentLogoImgMap;
    /* 读取Assets文件夹当中得内容，存放到字符串当中 */
    public static String getJsonFromAssets(Context context,String filename){
//        1、获取Assets文件管理器
        AssetManager am = context.getResources().getAssets();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        2、获取文件输入流
        try {
            InputStream is = am.open(filename);
//            读取内容存放到内存流当中
            int hasRead = 0;
            byte[]buf = new byte[1024];
            while (true){
                hasRead = is.read(buf);
                if (hasRead == -1) {
                    break;
                }
                baos.write(buf,0,hasRead);
            }
            String msg = baos.toString();
            is.close();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* 读取Assets文件夹中的图片，返回Bitmap对象 */
    public static Bitmap getBitmapFormAssets(Context context,String filename){
        Bitmap bitmap = null;
//        获取文件夹管理者
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream is = am.open(filename);
//            通过位图管理器，将输入流转换成位图对象
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    /*
    * @des 将Assets文件夹当中得图片一起读取放置到内存当中，便于管理
    *
    * */
    public static void savaBitmapFormAssets(Context context, StarBean starInfoBean){
        logoImgMap = new HashMap<>();
        contentLogoImgMap = new HashMap<>();
        List<StarBean.StarinfoBean> starList = starInfoBean.getStarinfo();
        for (int i = 0; i < starList.size(); i++) {
            String logoname = starList.get(i).getLogoname();
            String filename = "xzlogo/"+logoname+".png";
            Bitmap logoBm = getBitmapFormAssets(context, filename);
            logoImgMap.put(logoname,logoBm);

            String contentName = "xzcontentlogo/"+logoname+".png";
            Bitmap bitmap = getBitmapFormAssets(context, contentName);
            contentLogoImgMap.put(logoname,bitmap);
        }
    }

    public static Map<String, Bitmap> getLogoImgMap() {
        return logoImgMap;
    }

    public static Map<String, Bitmap> getContentLogoImgMap() {
        return contentLogoImgMap;
    }
}
