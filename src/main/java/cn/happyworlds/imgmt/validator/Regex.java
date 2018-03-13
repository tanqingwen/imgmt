package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式验证，相当强大
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class Regex implements Constraint {

    private String message;
    private String regex;

    public Regex(String regex) {
        this.regex = regex;
        this.message = "值不符合规则";
    }

    public Regex(String regex, String message) {
        this.regex = regex;
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        Matcher matcher = Pattern.compile(regex).matcher(value.toString());
        if (!matcher.matches()) {
            return message;
        }
        return null;
    }

}
