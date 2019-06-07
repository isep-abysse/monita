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
    private User teacher;
    private List<User> students;


    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public void addStudent(User student) {
        List<User> students = getStudents();
        students.add(student);
    }
}
