package cn.happyworlds.imgmt.http;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import cn.happyworlds.imgmt.util.IOs;

public class HttpClients {
	
	public static String get(final String uri, Map<String, String> params) {
		return send(uri, HttpGet.METHOD_NAME, params);
	}
	
	public static String post(final String uri, Map<String, String> params) {
		return send(uri, HttpPost.METHOD_NAME, params);
	}

	private static String send(final String uri, final String method, Map<String, String> params) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse resp = null;
		try {
			RequestBuilder builder = RequestBuilder.create(method);
			if(params !=null && params.size() > 0) {
				for(String key : params.keySet()) {
					builder.addParameter(key, params.get(key));
				}
			}
			HttpUriRequest req = builder.setUri(uri).build();
			System.err.println("构建"+req.getMethod()+"请求完成，开始发送HTTP请求...");
			httpClient = org.apache.http.impl.client.HttpClients.createDefault();
			resp = httpClient.execute(req);
			
			System.err.println("HTTP请求发送完成，开始检查HTTP响应状态...");
			StatusLine sc  = resp.getStatusLine();
			if(sc.getStatusCode() != HttpStatus.SC_OK) {
				System.err.println("HTTP响应状态‘{}’异常，退出处理：" + sc.getStatusCode());
			}
			
			System.err.println("HTTP响应状态‘{}’正常，开始业务逻辑处理：" +  sc.getStatusCode());
			HttpEntity entity = resp.getEntity();
			System.err.println("HTTP响应内容长度：" + entity.getContentLength());
			String result = EntityUtils.toString(entity).trim();
			EntityUtils.consumeQuietly(entity);
			System.err.println("HTTP响应内容：" + result);
			
			return result;
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOs.closeQuietly(resp);
			IOs.closeQuietly(httpClient);
		}
		return null;
	}
	
	public static String send(final String uri, final String method, final String content, final String charset) {
		try {
			HttpEntity entity = send(uri, method, new StringEntity(content, charset), charset);
			System.err.println("HTTP响应内容长度：" + entity.getContentLength());
			String result = EntityUtils.toString(entity, charset).trim();
			EntityUtils.consumeQuietly(entity);
			System.err.println("HTTP响应内容：" + result);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static HttpEntity send(final String uri, final String method, HttpEntity httpEntity, String charset) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse resp = null;
		try {
			HttpUriRequest req = RequestBuilder.create(method).setUri(uri).setEntity(httpEntity).build();
			System.err.println("构建" + req.getMethod() + "请求完成，开始发送HTTP请求...");
			httpClient = org.apache.http.impl.client.HttpClients.createDefault();
			resp = httpClient.execute(req);

			System.err.println("HTTP请求发送完成，开始检查HTTP响应状态...");
			StatusLine sc = resp.getStatusLine();
			if (sc.getStatusCode() != HttpStatus.SC_OK) {
				System.err.println("HTTP响应状态‘{}’异常，退出处理：" + sc.getStatusCode());
			}

			System.err.println("HTTP响应状态‘{}’正常，开始业务逻辑处理：" + sc.getStatusCode());
			return resp.getEntity();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			IOs.closeQuietly(resp);
			IOs.closeQuietly(httpClient);
		}
	}
}
