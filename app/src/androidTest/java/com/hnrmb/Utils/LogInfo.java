package com.hnrmb.Utils;

import android.Manifest;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by liming on 2020/3/24.
 */

public class LogInfo {

    public static String TAG = "qatest";

    public static void i(String l){
        Log.i(TAG,l);
        save(DataInfo.getDayFormatForLog()+":"+l);
    }

    public static void d(String l){
        Log.d(TAG,l);
        save(DataInfo.getDayFormatForLog()+":"+l);
    }

    public static void e(String l){
        Log.e(TAG,l);
        save(DataInfo.getDayFormatForLog()+":"+l);
    }

    public static void w(String l){
        Log.w(TAG,l);
        save(DataInfo.getDayFormatForLog()+":"+l);
    }

    public static void save(String content) {
        File file = new File("/sdcard/hnrmblog/"+DataInfo.formatData(DataInfo.getDayPostponeDay(0),"yyyy-MM-dd")+".log");
        if (!file.exists()) {
            try {
                file.createNewFile(); //如果文件不存在则创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        writeInFile(file, content);   //写入文件
    }

    private static void writeInFile(File file, String content) {
        Writer writer = null;
        StringBuilder outputString = new StringBuilder();
        try {
            outputString.append(content + "\r\n");
            writer = new FileWriter(file, true); // true表示追加
            writer.write(outputString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

}
