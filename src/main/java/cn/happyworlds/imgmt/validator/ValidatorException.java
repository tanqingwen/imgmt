package cn.happyworlds.imgmt.validator;

public class ValidatorException extends RuntimeException {

    private static final long serialVersionUID = -5053531636010741359L;

    public ValidatorException() {
        super();
    }

    public ValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(Throwable cause) {
        super(cause);
    }

}