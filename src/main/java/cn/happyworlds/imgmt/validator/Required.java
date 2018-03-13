package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证空字符串或null值
 *
 * @author json.shen@gmail.com
 */
public class Required implements Constraint {

    private String message;

    public Required() {
        this("不能为空");
    }

    public Required(String message) {
        this.message = message;
    }

    public String validate(HttpServletRequest request, Object value) {
        if (value == null || "".equals(value)) {
            return message;
        }
        return null;
    }

}
