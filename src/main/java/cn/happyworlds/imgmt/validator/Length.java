package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 验证长度范围，长度用字节数计算
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class Length implements Constraint {

    private String message;
    private long min;
    private long max;

    public Length(long min, long max) {
        this.min = min;
        this.max = max;
        checkConstraint();
        this.message = "长度必须大于或等于{0}且小于或等于{1}";
    }

    public Length(long min, long max, String message) {
        this.min = min;
        this.max = max;
        checkConstraint();
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        int len = value.toString().getBytes().length;
        if (len < min || len > max) {
            return MessageFormat.format(message, min, max);
        }
        return null;
    }

    private void checkConstraint() {
        if (min > max) {
            String e = MessageFormat.format("限制逻辑错误，最小长度[{0}]必须小于或等于最大长度[{1}]", min, max);
            throw new ValidatorException(e);
        }
    }

}
