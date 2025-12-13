package project.last_demo_question_solve;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Goal1Controller
{
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private ComboBox <String> genderCB;
    @javafx.fxml.FXML
    private DatePicker dateOfBirthDP;
    @javafx.fxml.FXML
    private TextField fathernameTF;

    ArrayList <User> users = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        genderCB.getItems().setAll("Male", "Female", "Other");
    }

    @javafx.fxml.FXML
    public void handleSave(ActionEvent actionEvent) {
        String name = nameTF.getText();
        String gender = genderCB.getValue();
        LocalDate birthDate = dateOfBirthDP.getValue();
        String father = fathernameTF.getText();


        User user = new User(name, father, gender, birthDate);

        File file = new File("user.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(user);
            oos.close();
        } catch (Exception e) {
            System.out.println("There is an error saving to bin file");
        }

    }



    @javafx.fxml.FXML
    public void handleNext(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}