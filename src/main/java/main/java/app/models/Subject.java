package main.java.app.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Subject {

    @Id
    private String id;
    private Mark[] marks;
    private double average;
    private String resit;

    public Subject() {}

    public Subject(Mark[] marks) {
        this.marks = marks;
    }

    public Mark[] getMarks() {
        return marks;
    }

    public void setMarks(Mark[] marks) {
        this.marks = marks;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getResit() {
        return resit;
    }

    public void setResit(String resit) {
        this.resit = resit;
    }
}