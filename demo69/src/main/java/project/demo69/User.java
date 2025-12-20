package project.demo69;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String fatherName;

    public User(String name, String fatherName) {
        this.name = name;
        this.fatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                '}';
    }
}
