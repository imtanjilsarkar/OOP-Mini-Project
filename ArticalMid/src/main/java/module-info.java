module home.articalmid {
    requires javafx.controls;
    requires javafx.fxml;


    opens home.articalmid to javafx.fxml;
    exports home.articalmid;
}