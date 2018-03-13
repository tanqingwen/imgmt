package cn.happyworlds.imgmt.service;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.context.VenaProperties;

@Service("uploadUtilService")
public class UploadUtilService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UploadUtilService.class);
	
	@Autowired
	private VenaProperties venaProperties;
	
	//本地路径
	private static String filePath;
	//服务器接口
	private static String uploadInt;
	
	
	/**
	 * PC端上传掌纹文件路径文件夹
	 */
	public String filePath(){
		filePath = venaProperties.getFilePath();
		return filePath;
	}
	
	/**
	 * 服务器接口路径
	 */
	public String uploadInt() {
		//uploadInt = venaProperties.getUploadInt();
		return uploadInt;
	}
	
	
	/**
	 * @param 客户端文件路径
	 * @param 服务器目的地址
	 * @return
	 * 
	 * @author Hugh
	 */
	public int sendUrlData(String barcode){
		
		int result=0;
		//本地路径
		String uploadFile=filePath()+barcode;
		System.out.println("输出: " + uploadFile);
		//上传服务器接口路径
		String writeUrl = uploadInt();
		
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		try{
			  result=1;
			  URL url = new URL(writeUrl);  
	          HttpURLConnection con = (HttpURLConnection) url.openConnection();  
	          /* 允许Input、Output，不使用Cache */  
	          con.setDoInput(true);  
	          con.setDoOutput(true);  
	          con.setUseCaches(false);  
	          /* 设置传送的method=POST */  
	          con.setRequestMethod("POST");  
	          /* setRequestProperty */  
	          con.setRequestProperty("Connection", "Keep-Alive");  
	          con.setRequestProperty("Charset", "UTF-8");  
	          con.setRequestProperty("Content-Type",  
	                  "multipart/form-data;boundary=" + boundary);  
	          /* 设置DataOutputStream */  
	          DataOutputStream ds = new DataOutputStream(con.getOutputStream());  
	          ds.writeBytes(twoHyphens + boundary + end);  
	        //添加商品:uploadFile 为本地磁盘照片路径
	          FileInputStream fStream = new FileInputStream(uploadFile);
        	  ds.writeBytes("Content-Disposition: form-data; "  
	                  + "name=\"file1\";filename=\"" + barcode + "\"" + end);  
	          ds.writeBytes(end);  
	          /* 设置每次写入1024bytes */  
	          int bufferSize = 1024;  
	          byte[] buffer = new byte[bufferSize];  
	          int length = -1;  
	          /* 从文件读取数据至缓冲区 */  
	          while ((length = fStream.read(buffer)) != -1) {  
	              /* 将资料写入DataOutputStream中 */  
	              ds.write(buffer, 0, length);  
	          }  
	          ds.writeBytes(end);  
	          ds.writeBytes(twoHyphens + boundary + twoHyphens + end);  
	          /* close streams */  
	          fStream.close();  
	          ds.flush();  
	          /* 取得Response内容 */  
	          InputStream is = con.getInputStream();  
	          int ch;  
	          StringBuffer b = new StringBuffer();  
	          while ((ch = is.read()) != -1) {  
	              b.append((char) ch);  
	          }  
	          /* 将Response显示于Dialog */ 
	          LOG.warn("同步服务器成功!");
	          /* 关闭DataOutputStream */  
	          ds.close();  
		}catch(Exception e){
			result=0;
			LOG.warn("同步服务器失败!");
			e.printStackTrace();
		}
		return result;
	}
}
