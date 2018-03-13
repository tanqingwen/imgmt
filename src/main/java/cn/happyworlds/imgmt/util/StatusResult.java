package cn.happyworlds.imgmt.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Hugh on 2016/8/11.
 */
public final class StatusResult<T> implements Serializable {

	private static final long serialVersionUID = -6493624493578101518L;
	
	private String status;
    private String comment;
	private T value;

    public StatusResult(String status, String comment) {
        this.status = status;
        this.comment = comment;
    }

    public StatusResult(T value) {
        this.status = "OK";
        this.value = value;
    }

    public StatusResult(String status, T value) {
        this.status = status;
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isOk() {
        return status.equals("OK");
    }

    public boolean isError() {
        return !isOk();
    }

    public static <T> StatusResult<T> create(String status, String comment) {
        return new StatusResult<>(status, comment);
    }

    public static <T> StatusResult<T> create(T value) {
        return new StatusResult<>(value);
    }

    public static <T> StatusResult<T> create(String status, T value) {
        return new StatusResult<>(status, value);
    }

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
    
}
