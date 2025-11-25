module com.oop.sectionone.cartdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.sectionone.cartdemo to javafx.fxml;
    exports com.oop.sectionone.cartdemo;
}