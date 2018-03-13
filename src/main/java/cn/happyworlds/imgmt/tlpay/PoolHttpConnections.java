package cn.happyworlds.imgmt.tlpay;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import cn.happyworlds.imgmt.util.Requests;

public class PoolHttpConnections {

	private static PoolingHttpClientConnectionManager clientConnectionManager=null;
	private static CloseableHttpClient httpClient=null;
	private static RequestConfig config = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
	private final static Object syncLock = new Object();
	//http://localhost:2015/openapi/v2/happyworld/network/test/test
//	private static final String domain = "127.0.0.1";
//	private static final String path = "/openapi/v2/happyworld/network/test/test";
	private static final String domain = "vsp.allinpay.com";
	private static final String path = "/apiweb/unitorder/pay";
	
	/**
	 * 创建httpclient连接池并初始化
	 */
	@PostConstruct
	private void init(){
		try {
			//添加对https的支持，该sslContext没有加载客户端证书
			// 如果需要加载客户端证书，请使用如下sslContext,其中KEYSTORE_FILE和KEYSTORE_PASSWORD分别是你的证书路径和证书密码
			//KeyStore keyStore  =  KeyStore.getInstance(KeyStore.getDefaultType()
			//FileInputStream instream =   new FileInputStream(new File(KEYSTORE_FILE));
			//keyStore.load(instream, KEYSTORE_PASSWORD.toCharArray());
			//SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore,KEYSTORE_PASSWORD.toCharArray())
			// .loadTrustMaterial(null, new TrustSelfSignedStrategy())
			//.build();
			@SuppressWarnings("deprecation")
			SSLContext sslContext = SSLContexts.custom()
					.loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.getDefaultHostnameVerifier());
			
			org.apache.http.config.Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("https", sslsf)
					.register("http", PlainConnectionSocketFactory.getSocketFactory())
					.build();
			clientConnectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			clientConnectionManager.setMaxTotal(50);
			clientConnectionManager.setDefaultMaxPerRoute(25);
		}catch (Exception e){
			System.out.println("httpUtils init get exception:");
			e.printStackTrace();
		}
	}
	public static CloseableHttpClient getHttpClient(){
		if(httpClient == null){
			synchronized (syncLock){
				if(httpClient == null){
					CookieStore cookieStore = new BasicCookieStore();
					BasicClientCookie cookie = new BasicClientCookie("sessionID", Requests.getSession().getId());
					cookie.setDomain(domain);
					cookie.setPath(path);
					cookieStore.addCookie(cookie);
					ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {

				        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				            // Honor 'keep-alive' header
				            HttpHost target = (HttpHost) context.getAttribute( HttpClientContext.HTTP_TARGET_HOST);
				            if ("vsp.allinpay.com".equalsIgnoreCase(target.getHostName())) {
				                // Keep alive for 1 hour only
				                return 48 * 3600 * 1000;
				            } else {
				                // otherwise keep alive for 10 hour
				                return 48 * 3600 * 1000;
				            }
				        }

				    };
					httpClient =HttpClients.custom().setKeepAliveStrategy(myStrategy).setConnectionManager(clientConnectionManager).setDefaultCookieStore(cookieStore).setDefaultRequestConfig(config).build();
				}
			}
		}
		return httpClient;
	}
	/**
	 * get请求
	 * @param url
	 * @param headers
	 * @return
	 */
	public static HttpEntity httpGet(String url, Map<String,Object> headers){
		CloseableHttpClient httpClient = getHttpClient();
		HttpRequest httpGet = new HttpGet(url);
		if(headers!=null&&!headers.isEmpty()){
			httpGet = setHeaders(headers, httpGet);
		}
		CloseableHttpResponse response = null;
		try{
			response =httpClient.execute((HttpGet)httpGet);
			HttpEntity entity = response.getEntity();
			return entity;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * post请求,使用json格式传参
	 * @param url
	 * @param headers
	 * @param data
	 * @return
	 */
	public static HttpEntity httpPost(String url,Map<String,Object> headers,String data){
		CloseableHttpClient httpClient = getHttpClient();
		
		
		HttpRequest request = new HttpPost(url);
		if(headers!=null&&!headers.isEmpty()){
			request = setHeaders(headers,request);
		}
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = (HttpPost) request;
			System.out.println("data:" + data);
			httpPost.setEntity(new StringEntity(data, ContentType.create("application/json", "UTF-8")));
			response=httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			return entity;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String httpPostByMap(String url,Map<String,Object> headers,Map<String,String> params) throws UnsupportedEncodingException{
		CloseableHttpClient httpClient = getHttpClient();
		StringBuilder outBuf = new StringBuilder();
		boolean isNotFirst = false;
		for (Map.Entry<String, String> entry: params.entrySet()){
			if (isNotFirst)
				outBuf.append('&');
			isNotFirst = true;
			outBuf
				.append(entry.getKey())
				.append('=')
				.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();
		UrlEncodedFormEntity uefEntity;
		for (Map.Entry<String, String> entry: params.entrySet()){
			formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
		
		HttpRequest request = new HttpPost(url);
		if(headers!=null&&!headers.isEmpty()){
			request = setHeaders(headers,request);
		}
		if(headers!=null&&!headers.isEmpty()){
			request = setHeaders(headers,request);
		}
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = (HttpPost) request;
			httpPost.setEntity(uefEntity);
			response=httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 使用表单键值对传参
	 * @param url
	 * @param headers
	 * @param data
	 * @return
	 */
	public static HttpEntity PostForm(String url,Map<String,Object> headers,List<org.apache.http.NameValuePair> data){
		CloseableHttpClient httpClient = getHttpClient();
		HttpRequest request = new HttpPost(url);
		if(headers!=null&&!headers.isEmpty()){
			request = setHeaders(headers,request);
		}
		CloseableHttpResponse response = null;
		UrlEncodedFormEntity uefEntity;
		try {
			HttpPost httpPost = (HttpPost) request;
			uefEntity = new UrlEncodedFormEntity(data,"UTF-8");
			httpPost.setEntity(uefEntity);
			response=httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			return entity;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 设置请求头信息
	 * @param headers
	 * @param request
	 * @return
	 */
	private static HttpRequest setHeaders(Map<String,Object> headers, HttpRequest request) {
		for (Map.Entry entry : headers.entrySet()) {
			if (!entry.getKey().equals("Cookie")) {
				request.addHeader((String) entry.getKey(), (String) entry.getValue());
			}else {
				Map<String, Object> Cookies = (Map<String, Object>) entry.getValue();
				for (Map.Entry entry1 : Cookies.entrySet()) {
					request.addHeader(new BasicHeader("Cookie", (String) entry1.getValue()));
				}
			}
		}
		return request;
	}
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static Map<String,String> getCookie(String url){
		CloseableHttpClient httpClient = getHttpClient();
		HttpRequest httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		try{
			response =httpClient.execute((HttpGet)httpGet);
			org.apache.http.Header[] headers = response.getAllHeaders();
			Map<String,String> cookies=new HashMap<String, String>();
			for(org.apache.http.Header header:headers){
				cookies.put(header.getName(),header.getValue());
			}
			return cookies;
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
