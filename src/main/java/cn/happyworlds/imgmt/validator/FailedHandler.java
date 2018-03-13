package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface FailedHandler {

    Object failedHandle(HttpServletRequest request, Map<String, FieldError> errors);
}
