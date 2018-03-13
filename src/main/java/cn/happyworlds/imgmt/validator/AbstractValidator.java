package cn.happyworlds.imgmt.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 验证过滤器
 *
 * @author json.shen@gmail.com (Json Shen)
 */
public abstract class AbstractValidator implements Validator {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractValidator.class);

    private boolean shortCircuit = false;
    private Map<String, FieldError> errors;
    private List<ConstraintGroup> constraintGroups = new ArrayList<ConstraintGroup>();

    public Map<String, FieldError> validate(HttpServletRequest request) {
        this.errors = null;
        try {
            defineConstraints();
            for (ConstraintGroup cg : constraintGroups) {
                for (Constraint c : cg.getConstraints()) {
                    LOG.debug("Check '{}' field '{}' constraint", cg.getField(), c);
                    String v = request.getParameter(cg.getField());
                    String e = c.validate(request, v);
                    LOG.debug("Value '{}' error '{}'", v, e);
                    if (e != null) {
                        addError(cg.getField(), e, v);
                        break;
                    }
                }
                if (shortCircuit && errors != null) {
                    break;
                }
            }
            if (errors != null) {
                FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
                Map<String, String[]> paramMap = request.getParameterMap();
                for (String field : paramMap.keySet()) {
                    String[] values = paramMap.get(field);
                    if (null == values || values.length == 0) {
                        continue;
                    }
                    if (values.length == 1) {
                        flashMap.put(field, values[0]);
                    } else {
                        flashMap.put(field, values);
                    }
                }
                handleErrors();
            }
        } catch (ValidatorException e) {
            e.printStackTrace();
        }
        return errors;
    }

    /**
     * Use validate method to validate the parameters of this action.
     */
    protected abstract void defineConstraints();

    /**
     * Handle the validate error.
     */
    public void handleErrors() {
        // hook method
    }

    protected void setShortCircuit(boolean shortCircuit) {
        this.shortCircuit = shortCircuit;
    }

    protected Map<String, FieldError> getErrors() {
        return errors;
    }

    protected void constraints(String field, Constraint... constraints) {
        this.constraintGroups.add(new ConstraintGroup(field, constraints));
    }

    /**
     * Add message when validate failure.
     */
    private void addError(String field, String error, Object value) {
        if (errors == null) {
            errors = new LinkedHashMap<String, FieldError>();
        }
        LOG.debug("Add field: '{}' error: '{}' value: '{}'", field, error, value);
        errors.put(field, new FieldError(field, error, value));
    }

    /**
     * 必须的
     *
     * @return
     */
    protected Constraint reqd() {
        return new Required();
    }

    /**
     * 必须的
     *
     * @param message 错误提示消息
     * @return
     */
    protected Constraint reqd(String message) {
        return new Required(message);
    }

    protected Constraint range(long min, long max) {
        return new Range(min, max);
    }

    protected Constraint range(long min, long max, String message) {
        return new Range(min, max, message);
    }

    protected Constraint len(long min, long max) {
        return new Length(min, max);
    }

    protected Constraint len(long min, long max, String message) {
        return new Length(min, max, message);
    }

    protected Constraint regex(String regex) {
        return new Regex(regex);
    }

    protected Constraint regex(String regex, String message) {
        return new Regex(regex, message);
    }

    protected Constraint email() {
        return new Email();
    }

    protected Constraint email(String message) {
        return new Email(message);
    }

    protected Constraint phone() {
        return new Phone();
    }

    protected Constraint phone(String message) {
        return new Phone(message);
    }

    protected Constraint eq(String target) {
        return new Equal(target);
    }

    protected Constraint eq(String target, String message) {
        return new Equal(target, message);
    }

    protected Constraint ne(String target) {
        return new NotEqual(target);
    }

    protected Constraint ne(String target, String message) {
        return new NotEqual(target, message);
    }

    protected Constraint ge(long min) {
        return new GreaterEqual(min);
    }

    protected Constraint ge(long min, String message) {
        return new GreaterEqual(min, message);
    }

    protected Constraint gt(long min) {
        return new GreaterThan(min);
    }

    protected Constraint gt(long min, String message) {
        return new GreaterThan(min, message);
    }

    protected Constraint le(long max) {
        return new LessEqual(max);
    }

    protected Constraint le(long max, String message) {
        return new LessEqual(max, message);
    }

    protected Constraint lt(long max) {
        return new LessThan(max);
    }

    protected Constraint lt(long max, String message) {
        return new LessThan(max, message);
    }

}