package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 验证小于等于
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class LessEqual implements Constraint {

    private String message;
    private long max;

    public LessEqual(long max) {
        this.max = max;
        this.message = "值必须小于或等于{0}";
    }

    public LessEqual(long max, String message) {
        this.max = max;
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        long v = Long.parseLong(value.toString());
        if (v > max) {
            return MessageFormat.format(message, max);
        }
        return null;
    }

}
