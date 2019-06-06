package main.java.app.models;

import lombok.Data;

@Data
public class Mark {

    private double value;
    private String comment;
    private String type;
    private int coefficient;

    public Mark() {}

    public Mark(double value, String comment, String type, int coefficient) {
        this.value = value;
        this.comment = comment;
        this.type = type;
        this.coefficient = coefficient;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
}