package cn.happyworlds.imgmt.codec;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLCodec {

    private static final String DEFAULT_ENCODING = "UTF-8";

    private URLCodec() {
    }

    public static String encode(final String url) {
        return encode(url, DEFAULT_ENCODING);
    }

    public static String encode(final String url, final String encoding) {
        try {
            return URLEncoder.encode(url, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decode(final String url) {
        return decode(url, DEFAULT_ENCODING);
    }

    public static String decode(final String url, final String encoding) {
        try {
            return URLDecoder.decode(url, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
