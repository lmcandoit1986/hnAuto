package com.hnrmb.Server;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.hnrmb.Utils.LogInfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

public class Request {

    public static JSONObject requestPost(String targetUrl, String Body) {
        HttpURLConnection connection = connect(targetUrl);

        /**
         * 设置header字段
         */
        HashMap<String, String> HeaderMap = new HashMap<String, String>();
        HeaderMap.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        HeaderMap.put("User-Agent", "PAHealth/3.15.0 (iPhone; iOS 12.1.1; Scale/3.00)");
        SetHeader(connection, HeaderMap);

        /**
         * 设置参数
         */
        try {
            connection.addRequestProperty("encoding", "UTF-8");// 添加请求属性
            connection.setDoInput(true);// 允许输入
            connection.setDoOutput(true);// 允许输出
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        /**
         * 服务器请求
         */
        OutStream(connection, Body);
        String Res = InStream(connection);
        LogInfo.i(Res);

        /**
         * 转json
         */
        JSONObject ob = JSONObject.parseObject(Res);
        return ob;
        /**
        System.out.println(ob.get("msg"));
        System.out.println(JSONPath.read(Res, "$.couponDetailId"));
         */

    }

    public static void SetHeader(HttpURLConnection connection, HashMap<String, String> obj) {
        for (String Key : obj.keySet()) {
            LogInfo.i(String.format("change header ,key=%s,vaule=%s", Key, obj.get(Key)));
            connection.setRequestProperty(Key, obj.get(Key));
        }

    }

    public static HttpURLConnection connect(String targetUrl) {
        try {
            URL url = new URL(targetUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void OutStream(HttpURLConnection connection, String Body) {
        try {
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(Body);
            bw.flush();
            bw.close();
            osw.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String InStream(HttpURLConnection connection) {
        try {
            InputStream in = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();
            isr.close();
            in.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
