module project.demo_final2024_01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.demo_final2024_01 to javafx.fxml;
    exports project.demo_final2024_01;
}