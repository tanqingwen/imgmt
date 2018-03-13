package cn.happyworlds.imgmt.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 测试调用一些meeting第三方接口
 *
 * @author  
 */
public class HttpPostUtil {

    /**
     * @param args
     */
	private static final Logger LOG = LoggerFactory.getLogger(HttpPostUtil.class);
   /*public static void main(String[] args) {

        String url = "http://58.246.102.52:2015/openapi/v2/happyworld/network/purchase";
        String message = String.format("{\"cardNo\":\"%s\"}", "12313");
        String data= null;
        Map<String,String> params = new HashMap<String,String>();
        params.put("cbRecommenderNo", "HWCARD0000000099"); 
        params.put("amount", "150");
        params.put("hwchannel", "2");
        params.put("paytype", "2");
       params.put("type", "2");
        JSONObject jsonObj = JSONObject.fromObject(params); 
        System.out.println(jsonObj.toString());
        String receive = HttpPostUtil.doPost(url, jsonObj.toString());
        System.out.println(receive);


        url = "http://192.168.1.206:9000/pvenroll";
        message = String.format("{\"cardNo\":\"%s\"}", "12313");
        System.out.println(message);
        receive = HttpPostUtil.doPost(url, message);
        System.out.println(receive);
    }*/

    /**
     * 发送xml数据请求到server端
     *
     * @param url xml请求数据地址
     * @param data 发送的数据流
     * @return null发送失败，否则返回响应内容
     */
    public static String doPost( String url,String data) {
        //创建httpclient工具对象   
        HttpClient client = new HttpClient();
        //创建post请求方法   
        PostMethod myPost = new PostMethod(url);
        //设置请求超时时间   
        client.setConnectionTimeout(5 * 60 * 1000);//5分钟
        String responseString = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream bos = null;

        try {
            myPost.setRequestEntity(new StringRequestEntity(data, "application/json", "UTF-8"));
            int statusCode = client.executeMethod(myPost);
            if (statusCode == HttpStatus.SC_OK) {
                bis = new BufferedInputStream(myPost.getResponseBodyAsStream());
                byte[] bytes = new byte[1024];
                bos = new ByteArrayOutputStream();
                int count = 0;
                while ((count = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, count);
                }
                byte[] strByte = bos.toByteArray();
                responseString = new String(strByte, 0, strByte.length, "utf-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException ex) {
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException ex) {
                }
            }
        }
        if (myPost != null) {
            myPost.releaseConnection();
        }
        return responseString;
    }
    
    public static String sendPost(String url, String reqStr){
		LOG.info("json请求url:{},reqStr:{}", url, reqStr);
		String result = "";
        BufferedReader in = null;
        PrintWriter out = null;
        try {
        	URL realUrl = new URL(url);
        	URLConnection connection = realUrl.openConnection();
        	connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(connection.getOutputStream());
            // 发送请求参数
            out.print(reqStr);
            // flush输出流的缓冲
            out.flush();
            // 建立实际的连接
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), Charset.forName("UTF-8")));
            String line;
            while ((line = in.readLine()) != null){
                result += line;
            }
        }catch(Exception e){
        	throw new RuntimeException("REST请求异常", e);
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
            	throw new RuntimeException("REST请求异常", e2);
            }
        }
        return result;
	}   

}
