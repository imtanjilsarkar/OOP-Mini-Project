module project.demo69 {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.demo69 to javafx.fxml;
    exports project.demo69;
}