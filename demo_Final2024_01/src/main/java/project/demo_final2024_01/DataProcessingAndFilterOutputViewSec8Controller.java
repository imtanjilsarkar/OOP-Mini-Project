package project.demo_final2024_01;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataProcessingAndFilterOutputViewSec8Controller {
    @javafx.fxml.FXML
    private TableColumn <Passport, String> ZipCodeCol;
    @javafx.fxml.FXML
    private TableColumn <Passport, LocalDate> dateOfIssueCol;
    @javafx.fxml.FXML
    private TableColumn <Passport, String> ppTypeCol;
    @javafx.fxml.FXML
    private TableColumn <Passport, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn <Passport, String> ppNoCol;
    @javafx.fxml.FXML
    private ComboBox <String> passportTypeCB;
    @javafx.fxml.FXML
    private TableColumn <Passport, LocalDate> dateOfExpireCol;
    @javafx.fxml.FXML
    private TableView <Passport> passportTableView;
    @javafx.fxml.FXML
    private ComboBox <String> zipCodeCB;

   // ArrayList<Passport> passports = new ArrayList<>();
   //ArrayList <Passport> passports = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize () {
        passportTypeCB.getItems().addAll("Type 1", "Type 2");
        zipCodeCB.getItems().addAll("1111", "1234", "3213");

        ppNoCol.setCellValueFactory(new PropertyValueFactory<>("ppNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        ppTypeCol.setCellValueFactory(new PropertyValueFactory<>("passportType"));
        ZipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        dateOfIssueCol.setCellValueFactory(new PropertyValueFactory<>("dateOfIssue"));
        dateOfExpireCol.setCellValueFactory(new PropertyValueFactory<>("dateOfExpire"));


    }

    @javafx.fxml.FXML
    public void handleFilterButton(ActionEvent actionEvent) {

        ArrayList <Passport> passports = new ArrayList<>();

        try {
            File file = new File("Passport.bin");
            if (!file.exists()){
                return;
            }
            FileInputStream fis;
            ObjectInputStream ois;

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    passports.add((Passport) ois.readObject());

                }
            } catch (EOFException e) {
                System.out.println("Bin file read successfully!");
            }
        } catch (Exception e){
            System.out.println("There is an error");

        }
        passportTableView.getItems().clear();
        passportTableView.getItems().addAll(passports);


        ArrayList <Passport> filterpassport = new ArrayList<>();


        String passportType = passportTypeCB.getValue();
        String zipcodeComboBox = zipCodeCB.getValue();

        for (Passport passport : filterpassport) {
            if(passport.getPassportType() == passportType && passport.getZipCode() == zipcodeComboBox){
                filterpassport.addAll(passports);
            }
        }

        passportTableView.getItems().clear();
        passportTableView.getItems().addAll(filterpassport);
    }
}
