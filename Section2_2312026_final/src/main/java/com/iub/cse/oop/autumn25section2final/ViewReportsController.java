package com.iub.cse.oop.autumn25section2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewReportsController {
    @javafx.fxml.FXML
    private TableColumn<ProjectReport_2312026, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<ProjectReport_2312026, String> buldingCol;
    @javafx.fxml.FXML
    private TableColumn<ProjectReport_2312026, Integer> totalMarkCol;
    @javafx.fxml.FXML
    private TableColumn<ProjectReport_2312026, String> authorCol;
    @javafx.fxml.FXML
    private TableView<ProjectReport_2312026> markTableView;
    @javafx.fxml.FXML
    private Label messageLabel2;
    @javafx.fxml.FXML
    private Label messageLabel1;

    ArrayList<ProjectReport_2312026> projectReport2312026s = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        buldingCol.setCellValueFactory(new PropertyValueFactory<>("binding"));
        totalMarkCol.setCellValueFactory(new PropertyValueFactory<>("mark"));

    }

    @javafx.fxml.FXML
    public void handleAddReport(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-report.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void handleShowLongestReport(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void handleShowAll(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLoadReport(ActionEvent actionEvent) {
        ArrayList<ProjectReport_2312026> projectReport2312026s = new ArrayList<>();

        try {
            File file = new File("projectReports.bin");
            if (!file.exists()) {
                return;
            }
            FileInputStream fis;
            ObjectInputStream ois;
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            try {
                while (true) {
                    projectReport2312026s.add ((ProjectReport_2312026) ois.readObject());
                    ;
                }

            } catch (EOFException e) {
                messageLabel1.setText("read succeffuly!");
            }
        } catch (Exception e) {
            messageLabel1.setText("Error handle Succefully");

        }
        markTableView.getItems().clear();
        markTableView.getItems().addAll(projectReport2312026s);
    }


    @javafx.fxml.FXML
    public void handleShpwAnimatedReport(ActionEvent actionEvent) {
    }
}

