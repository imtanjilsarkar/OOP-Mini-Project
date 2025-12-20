package project.last_demo_question_solve;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Goal2Controller
{
    @javafx.fxml.FXML
    private TableView <User>  userTableView;
    @javafx.fxml.FXML
    private ComboBox <String> genderCB;
    @javafx.fxml.FXML
    private TableColumn <User, String > nameCol;
    @javafx.fxml.FXML
    private TableColumn <User, String > fathernameCol;
    @javafx.fxml.FXML
    private TableColumn <User, String > genderCol;
    @javafx.fxml.FXML
    private TableColumn <User, LocalDate> birthCol;

    @javafx.fxml.FXML
    public void initialize() {
        genderCB.getItems().setAll("Male", "Female", "Other");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        fathernameCol.setCellValueFactory(new PropertyValueFactory<>("fatherName"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        birthCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

    }

    @javafx.fxml.FXML
    public void handleFilter(ActionEvent actionEvent) {
        ArrayList <User> users = new ArrayList<>();

        try {
            File file = new File("user.bin");
            if (!file.exists()) {
                return;
            }
            FileInputStream fis;
            ObjectInputStream ois;

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            try {
                while (true){
                    users.add((User) ois.readObject());
                }
            }catch (EOFException e){
                System.out.println("Bin file read successfully!");

            }
        }catch (Exception e) {
            System.out.println("Bin file handle successfully!");

        }
        userTableView.getItems().clear();
        userTableView.getItems().addAll(users);

        ArrayList <User> filterusers = new ArrayList<>();
        String gender = genderCB.getValue();

        for (User user: users){
            if (gender.equals(user.getGender())) {
                filterusers.add(user);
            }

        }
        userTableView.getItems().clear();
        userTableView.getItems().addAll(filterusers);
    }

}

//Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Error");
//        if (dateOfIssue.isAfter(dateOfExpire)){
//        alert.setContentText("Issue date us after expair date");
//            alert.showAndWait();
