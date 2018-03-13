package cn.happyworlds.imgmt.http;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Map;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.util.Assert;

public class HttpUtils {

    public static CloseableHttpClient createHttpsClient() {
        return createHttpsClient("TLS", null, new EmptyX509TrustManager(), null);
    }

    public static CloseableHttpClient createHttpsClient(String protocol) {
        return createHttpsClient(protocol, null, new EmptyX509TrustManager(), null);
    }

    public static CloseableHttpClient createHttpsClient(String protocol, TrustManager trustManager) {
        return createHttpsClient(protocol, null, trustManager, null);
    }

    public static CloseableHttpClient createHttpsClient(String protocol, TrustManager trustManager, SecureRandom secureRandom) {
        return createHttpsClient(protocol, null, trustManager, secureRandom);
    }

    /**
     * Create a HTTPS protocol client.
     *
     * @param protocol     TLS or SSL
     * @param keyManager
     * @param trustManager
     * @param secureRandom
     * @return A HTTPS protocol client.
     */
    public static CloseableHttpClient createHttpsClient(String protocol,
                                                        KeyManager keyManager, TrustManager trustManager,
                                                        SecureRandom secureRandom) {
        try {
            KeyManager[] keyManagers = keyManager == null ? null : new KeyManager[]{keyManager};
            TrustManager[] trustManagers = trustManager == null ? null : new TrustManager[]{trustManager};
            SSLContext context = SSLContexts.custom().useProtocol(protocol).build();
            context.init(keyManagers, trustManagers, secureRandom);
            SSLConnectionSocketFactory socketFactory = SSLConnectionSocketFactory.getSocketFactory();
            return HttpClients.custom().setSSLSocketFactory(socketFactory).build();
        } catch (Exception e) {
            throw new HttpClientException(e);
        }
    }

    public static CloseableHttpResponse send(CloseableHttpClient httpClient, String method,
                                             String uri) {
        return send(httpClient, method, uri, null, null);
    }

    public static CloseableHttpResponse send(CloseableHttpClient httpClient, String method,
                                             String uri, Map<String, String> params) {
        return send(httpClient, method, uri, null, params);
    }

    /**
     * Send a HTTP message.
     *
     * @param httpClient
     * @param method
     * @param uri
     * @param headers
     * @param params
     * @return
     */
    public static CloseableHttpResponse send(CloseableHttpClient httpClient, String method,
                                             String uri, Map<String, String> headers, Map<String, String> params) {
        Assert.isNull(httpClient, "Http client can't null");
        Assert.isNull(method, "Http request method can't null");
        Assert.isNull(uri, "Http request uri can't null");
        RequestBuilder builder = RequestBuilder.create(method).setUri(uri);
        if (headers != null) {
            for (String name : headers.keySet()) {
                builder.addHeader(name, headers.get(name));
            }
        }
        if (params != null) {
            for (String name : params.keySet()) {
                builder.addParameter(name, params.get(name));
            }
        }
        HttpUriRequest request = builder.build();
        try {
            return httpClient.execute(request);
        } catch (IOException e) {
            throw new HttpClientException(e);
        }
    }
}
