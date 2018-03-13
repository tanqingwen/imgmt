package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 验证小于
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class LessThan implements Constraint {

    private String message;
    private long max;

    public LessThan(long max) {
        this.max = max;
        this.message = "值必须小于{0}";
    }

    public LessThan(long max, String message) {
        this.max = max;
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        long v = Long.parseLong(value.toString());
        if (v >= max) {
            return MessageFormat.format(message, max);
        }
        return null;
    }

}
