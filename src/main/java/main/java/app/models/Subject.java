package main.java.app.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class Subject implements Serializable {

    @Id
    private String id;
    private String name;
    private Mark[] marks;
    private double average;
    private String resit;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}