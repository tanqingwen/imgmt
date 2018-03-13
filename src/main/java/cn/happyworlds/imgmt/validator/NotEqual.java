package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * 验证不等于
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class NotEqual implements Constraint {

    private String message;
    private String target;

    public NotEqual(String target) {
        this.target = target;
        this.message = "值必须不等于{0}";
    }

    public NotEqual(String target, String message) {
        this.target = target;
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        if (value.equals(target)) {
            return MessageFormat.format(message, value);
        }
        return null;
    }

}
