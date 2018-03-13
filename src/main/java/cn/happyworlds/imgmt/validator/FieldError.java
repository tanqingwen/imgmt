package cn.happyworlds.imgmt.validator;

public class FieldError {

    private String field;
    private String error;
    private Object value;

    public FieldError() {
    }

    public FieldError(String field, String error, Object value) {
        this.field = field;
        this.error = error;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
