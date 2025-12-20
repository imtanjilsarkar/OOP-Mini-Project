module com.iub.cse.oop.autumn25section1final {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.iub.cse.oop.autumn25section2final to javafx.fxml;
    exports com.iub.cse.oop.autumn25section2final;
}