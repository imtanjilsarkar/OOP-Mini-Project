package com.oop.sectionone.cartdemo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class CartController
{
    @javafx.fxml.FXML
    private TextField priceField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField quantityField;
    @javafx.fxml.FXML
    private Label priceLabel;

    List<CartItem> itemList = new ArrayList<>();
    @javafx.fxml.FXML
    private TableView<CartItem> tableView;
    @javafx.fxml.FXML
    private TableColumn<CartItem,String> productNameCol;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Double> priceCol;
    @javafx.fxml.FXML
    private TableColumn<CartItem,Integer> quantityCol;
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private TextField filterPriceField;

    @javafx.fxml.FXML
    public void initialize() {
        productNameCol.setCellValueFactory(
                new PropertyValueFactory<>("productName")
        );
        priceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    @javafx.fxml.FXML
    public void display(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(itemList);
    }

    @javafx.fxml.FXML
    public void addToCart(ActionEvent actionEvent) {
        try {
            String productName = nameField.getText();
            if (productName.isBlank()) {
                infoLabel.setText("Please enter a valid product name.");
                return;
            }

            double unitPrice = Double.parseDouble(priceField.getText());
            if (unitPrice <= 0) {
                infoLabel.setText("Price must be a positive number.");
                return;
            }

            int quantity = Integer.parseInt(quantityField.getText());
            if (quantity <= 0) {
                infoLabel.setText("Quantity must be a positive integer.");
                return;
            }

            for (CartItem item : itemList) {
                if (productName.equals(item.getProductName())) {
                    // this productName already exists
                    int newQuantity = item.getQuantity() + quantity;
                    item.setQuantity(newQuantity);
                    infoLabel.setText("Product is already in the cart. Quantity updated.");
//                    infoLabel.setText("Product Name must be unique!");
                    return;
                }
            }

            CartItem item = new CartItem(productName, unitPrice, quantity);
            itemList.add(item);
            infoLabel.setText("Product added successfully: " + item);

//            display(actionEvent);
//            checkout(actionEvent);
        } catch (NumberFormatException e) {
            infoLabel.setText("Please enter valid numbers for price and quantity");
        }
    }

    @javafx.fxml.FXML
    public void checkout(ActionEvent actionEvent) {
        double sum = 0.0;
        for (CartItem item : itemList) {
            double subtotal = item.quantity * item.unitPrice;
            sum += subtotal;
        }
        priceLabel.setText("Total Price: " + sum);
    }

    @javafx.fxml.FXML
    public void filter(ActionEvent actionEvent) {
        double maxPrice = Double.parseDouble(filterPriceField.getText());

        tableView.getItems().clear();
        for(CartItem item : itemList) {
            if (item.getUnitPrice() <= maxPrice) {
                tableView.getItems().add(item);
            }
        }
    }

    @javafx.fxml.FXML
    public void resetFilter(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(itemList);
    }
}