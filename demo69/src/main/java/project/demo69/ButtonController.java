package project.demo69;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ButtonController
{
    @javafx.fxml.FXML
    private TextField fatherTF;
    @javafx.fxml.FXML
    private TextField nameTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleButton(ActionEvent actionEvent) {
        String names = nameTF.getText();
        String fathers = fatherTF.getText();


       // ArrayList<User> users = new ArrayList<>();

        User users = new User(names, fathers);
        File file = new File("user.bin");
        FileOutputStream fos ;
        ObjectOutputStream oos;

        try {
            if (file.exists()){
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(users);
            oos.close();

        } catch (Exception e) {
            System.out.println("The error properly handle!");

        }

    }
}