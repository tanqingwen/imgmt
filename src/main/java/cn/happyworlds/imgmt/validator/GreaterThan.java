package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 验证大于
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class GreaterThan implements Constraint {

    private String message;
    private long min;

    public GreaterThan(long min) {
        this.min = min;
        this.message = "值必须大于{0}";
    }

    public GreaterThan(long min, String message) {
        this.min = min;
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        long v = Long.parseLong(value.toString());
        if (v <= min) {
            return MessageFormat.format(message, min);
        }
        return null;
    }

}
