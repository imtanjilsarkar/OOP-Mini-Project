package project.demo_final_sec2_01;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataCreationView2312026Controller
{
    @javafx.fxml.FXML
    private ComboBox <String> locationCB;
    @javafx.fxml.FXML
    private TextField areaTF;
    @javafx.fxml.FXML
    private TextField tradeLicenseTF;
    @javafx.fxml.FXML
    private CheckBox isChainPharmacyCB;
    @javafx.fxml.FXML
    private TextField pharmacyNameTF;
    @javafx.fxml.FXML
    private TextField ownerTF;
    @javafx.fxml.FXML
    private DatePicker openingDateDP;
    @javafx.fxml.FXML
    private ComboBox <String> zipCodeCB;

    @javafx.fxml.FXML
    public void initialize() {
        zipCodeCB.getItems().setAll("1229", "1222", "1223", "1245");
        locationCB.getItems().setAll("Mall", "SuperShop", "Local");

    }

    @javafx.fxml.FXML
    public void handleGoToDataProcessingView(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataProcessingViewYourID.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        //Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Data processing View");
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleToAddObjectBin(ActionEvent actionEvent) {
        String name = pharmacyNameTF.getText();
        String owner = ownerTF.getText();
        LocalDate openingDate = openingDateDP.getValue();
        String zipCode = zipCodeCB.getValue();
        String location = locationCB.getValue();
        String tradeLicense = tradeLicenseTF.getText();

        int area = Integer.parseInt(areaTF.getText());
        boolean isChain = isChainPharmacyCB.isSelected();

        List <Pharmacy> pharmacyList = new ArrayList<>();

        if (isChain) {
            if(!(area >= 500) ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Chain Pharmacy must be bigger then or equal 500 SQF");
                alert.showAndWait();
                return;
            }
        }
        else {
            if (!((area >= 100) && (area <= 499))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Non Chain Pharmacy must be 100 to 499 SQF");
                alert.showAndWait();
                return;
            }
        }
        //public Pharmacy(String name, String zipCode, int areaInSqFt, String owner, LocalDate openingDate, Boolean isChainPharmacy, String locationType, String licenceNo)

        Pharmacy pharmacy = new Pharmacy(name, zipCode, area, owner, openingDate, isChain, location, tradeLicense);
        //File file = new File("Chair.bin");

//        try (ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(file, true)))
//        {
//            obs.writeObject(pharmacy);
//        } catch ( IOException e) {
//            System.out.println("There is an error");
        File file = new File("Chair.bin");
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
            oos.writeObject(pharmacy);
            oos.close();
        } catch (Exception e) {
            System.out.println("There is an error saving to bin file");
        }



        }





}
