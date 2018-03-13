package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证邮箱
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class Email implements Constraint {

    private static final String EMAIL_REGEX = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";

    private String message;

    public Email() {
        this.message = "邮件格式错误";
    }

    public Email(String message) {
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        Regex r = new Regex(EMAIL_REGEX, message);
        return r.validate(request, value);
    }

}
