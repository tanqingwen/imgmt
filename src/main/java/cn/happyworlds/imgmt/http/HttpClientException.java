package cn.happyworlds.imgmt.http;

public class HttpClientException extends RuntimeException {

    private static final long serialVersionUID = 3520357663394037371L;

    public HttpClientException() {
        super();
    }

    public HttpClientException(String message, Throwable cause,
                               boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HttpClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpClientException(String message) {
        super(message);
    }

    public HttpClientException(Throwable cause) {
        super(cause);
    }

}
