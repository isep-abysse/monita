package main.java.app.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;
    private String password;
    private String role; // Allowed values: "prof", "student"
    private List<Subject> subjects;

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, username='%s', password='%s']",
                id, email, password);
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public String getEmail() {
        return email;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getRole() {
        return role;
    }

    public void setRoleStudent() {
        this.role = "student";
    }

    public void setRoleProf() {
        this.role = "prof";
    }
}