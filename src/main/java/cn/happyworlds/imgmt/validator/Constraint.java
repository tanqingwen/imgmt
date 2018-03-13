package cn.happyworlds.imgmt.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证器接口，验证一个值是否符合特定的规则
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public interface Constraint {

    /**
     * 验证方法签名
     *
     * @param req   请求动作上下文对象
     * @param value 要被验证的值
     * @return 错误消息，返回null表示验证通过
     */
    String validate(HttpServletRequest req, Object value);
}
