package project.last_demo_question_solve;

import javafx.scene.control.Alert;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private String name;
    private  String fatherName;
    private  String gender;
    private LocalDate dateOfBirth;

    public User(String name, String fatherName, String gender, LocalDate dateOfBirth) {
        this.name = name;
        this.fatherName = fatherName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public void showPassportAsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Passport Info");
        alert.setContentText(this.toString());
        alert.showAndWait();
    }
}
