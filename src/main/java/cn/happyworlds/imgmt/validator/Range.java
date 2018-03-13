package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 验证数字大小范围
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class Range implements Constraint {

    private String message;
    private long min;
    private long max;

    public Range(long min, long max) {
        this.min = min;
        this.max = max;
        this.message = "值必须大于或等于{0}且小于或等于{1}";
    }

    public Range(long min, long max, String message) {
        if (min > max) {
            String e = MessageFormat.format("限制逻辑错误，最小值[{0}]必须小于或等于最大值[{1}]", min, max);
            throw new ValidatorException(e);
        }
        this.min = min;
        this.max = max;
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        long v = Long.parseLong(value.toString());
        if (v < min || v > max) {
            return MessageFormat.format(message, min, max);
        }
        return null;
    }

}
