package project.demo_final_sec2_01;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataProcessingView2312026Controller
{
    @javafx.fxml.FXML
    private ComboBox <String> zipcodeCB;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, String> locationCol;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, String> licenseCol;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, Integer> areaCol;
    @javafx.fxml.FXML
    private TableView <Pharmacy> pharmecyTable;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, String> owerCol;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, String> zipCol;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, String> nameCol;
    @javafx.fxml.FXML
    private TextField areaFromTF;
    @javafx.fxml.FXML
    private TextField areaToTF;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, Boolean> isChainCol;
    @javafx.fxml.FXML
    private TableColumn <Pharmacy, LocalDate> openingDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        zipcodeCB.getItems().setAll("1229", "1222", "1223", "1245");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        areaCol.setCellValueFactory(new PropertyValueFactory<>("areaInSqFt"));
        owerCol.setCellValueFactory(new PropertyValueFactory<>("owner"));
        openingDateCol.setCellValueFactory(new PropertyValueFactory<>("openingDate"));
        isChainCol.setCellValueFactory(new PropertyValueFactory<>("isChainPharmacy"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("locationType"));
        licenseCol.setCellValueFactory(new PropertyValueFactory<>("licenceNo"));

    }

    @javafx.fxml.FXML
    public void handleLoadTable(ActionEvent actionEvent) {

        ArrayList<Pharmacy> pharmacies = new ArrayList<>();

        try {
            File file = new File("Chair.bin");
            if(!file.exists()){
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    pharmacies.add((Pharmacy) ois .readObject());
                }

            } catch (EOFException e) {
                System.out.println("Bin file read successfully !");
            }

            } catch (Exception e){
            System.out.println("There is an error");
        }

        pharmecyTable.getItems().clear();
        pharmecyTable.getItems().addAll(pharmacies);

        ArrayList <Pharmacy> filterPharmecy = new ArrayList<>();
        String zipcode = zipcodeCB.getValue();

        int fromArea = Integer.parseInt((areaFromTF.getText()));
        int toArea = Integer.parseInt(areaToTF.getText());

        for (Pharmacy pharmacy: pharmacies){
            if (zipcode.equals(pharmacy.getZipCode())) {
                if ((pharmacy.getAreaInSqFt() >= fromArea) && (pharmacy.getAreaInSqFt() <= toArea)) {
                    filterPharmecy.add(pharmacy);
                }

            }

        }
        pharmecyTable.getItems().clear();
        pharmecyTable.getItems().addAll(filterPharmecy);


    }
}