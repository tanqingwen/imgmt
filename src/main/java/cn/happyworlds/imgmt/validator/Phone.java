package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证中国手机号
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public class Phone implements Constraint {

    private static final String PHONE_REGEX = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(170))\\d{8}$";

    private String message;

    public Phone() {
        this.message = "手机号不符合规则";
    }

    public Phone(String message) {
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        Regex r = new Regex(PHONE_REGEX, message);
        return r.validate(request, value);
    }

}
