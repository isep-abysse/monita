package main.java.app.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

@Data
public class Classroom implements Serializable {

    @Id
    private String id;
    private String name;
    private List<String> teachers;
    private List<String> students;


    public List<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<String> teachers) {
        this.teachers = teachers;
    }
}
