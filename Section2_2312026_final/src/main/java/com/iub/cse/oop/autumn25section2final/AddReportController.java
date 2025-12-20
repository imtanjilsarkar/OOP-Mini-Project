package com.iub.cse.oop.autumn25section2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddReportController
{
    @javafx.fxml.FXML
    private TextField examiner2MarksTF;
    @javafx.fxml.FXML
    private TextField authorTF;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private Label messageLable;
    @javafx.fxml.FXML
    private TextField titleTF;
    @javafx.fxml.FXML
    private TextField examiner1MarksTF;
    @javafx.fxml.FXML
    private ComboBox <String> bindingCB;

    public ArrayList<ProjectReport_2312026> projects = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        bindingCB.getItems().setAll("Spiral","Paperback", "Hard Cover");
    }

    @javafx.fxml.FXML
    public void handleAddReport(ActionEvent actionEvent) {
        String author = authorTF.getText();
        String title = titleTF.getText();
        LocalDate date = dateDP.getValue();
        String binding = bindingCB.getValue();
        int mark1 = Integer.parseInt(examiner1MarksTF.getText());
        int mark2 = Integer.parseInt(examiner2MarksTF.getText());

        if (author.isEmpty() || title.isEmpty() || date.isAfter(date) || binding.isEmpty()) {
            if ((0 < mark1 && mark1 < 50) && (0 < mark1 && mark1 < 50)) {

                ProjectReport_2312026 projects = new ProjectReport_2312026(mark2, mark1, date, binding, author, title);
            }
        }
    }

    @javafx.fxml.FXML
    public void handleShowAllReports(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view-reports.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleSaveToBin(ActionEvent actionEvent) {

        File file = new File("projectReports.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if(file.exists()){
                fos = new FileOutputStream(file,true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(projects);
            oos.close();

        } catch (Exception e) {
            messageLable.setText("Error handle succeffly!");


        }

    }

    private void Clear(ActionEvent actionEvent) {
        projects.clear();


    }
}