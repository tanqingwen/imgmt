package cn.happyworlds.imgmt.validator;

public class ConstraintGroup {

    private String field;
    private Constraint[] constraints;

    public ConstraintGroup(String field, Constraint... constraints) {
        this.field = field;
        this.constraints = constraints;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Constraint[] getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraint[] constraints) {
        this.constraints = constraints;
    }
}
