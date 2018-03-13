package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 验证器
 *
 * @author json
 */
public interface Validator {

    Map<String, FieldError> validate(HttpServletRequest request);
}
