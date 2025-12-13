package project.demo_final2024_01;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class DataCreationToFileViewSec8Controller {
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private DatePicker dateExpireDP;
    @javafx.fxml.FXML
    private TextField newPassportTF;
    @javafx.fxml.FXML
    private TextField nidTF;
    @javafx.fxml.FXML
    private CheckBox previousPassportCheckB;
    @javafx.fxml.FXML
    private ComboBox <String> passportTypeCB;
    @javafx.fxml.FXML
    private TextField previousPassportTF;
    @javafx.fxml.FXML
    private DatePicker dateOfIssueDP;
    @javafx.fxml.FXML
    private ComboBox <String> zipCodeCB;

    @javafx.fxml.FXML
    public void initialize() {
        passportTypeCB.getItems().addAll("Type 1", "Type 2");
        zipCodeCB.getItems().addAll("1111", "1234", "3213");
    }

    @javafx.fxml.FXML
    public void handleToSaveBin(ActionEvent actionEvent) {
        String ppNo = newPassportTF.getText();
        String nId = nidTF.getText();
        String name = nameTF.getText();
        String zipCode = zipCodeCB.getValue();
        String prevPassportNo = previousPassportTF.getText();
        String  passportType = passportTypeCB.getValue();

        LocalDate dateOfIssue = dateOfIssueDP.getValue();
        LocalDate dateOfExpire = dateExpireDP.getValue();

        Boolean hasPreviousPassport = previousPassportCheckB.isSelected();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        if (dateOfIssue.isAfter(dateOfExpire)){
            alert.setContentText("Issue date us after expair date");
            alert.showAndWait();
        }

        if (! hasPreviousPassport){
            if (! prevPassportNo.isBlank()){
                alert.setContentText("If no previous passport then pre passsport is blank");
                alert.showAndWait();
                return;
            }

        }

        Passport passport = new Passport(ppNo, nId, name,zipCode, prevPassportNo, passportType, dateOfIssue, dateOfExpire, hasPreviousPassport);

        File file = new File("Passport.bin");
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
            oos.writeObject(passport);
            oos.close();
        } catch (Exception e) {
            System.out.println("There is an error saving to bin file");
        }

    }

    @javafx.fxml.FXML
    public void handleGotoDataLoading(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DataProcessingAndFilterOutputViewSec8.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
