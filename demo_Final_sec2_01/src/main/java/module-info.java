module project.demo_final_sec2_01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.demo_final_sec2_01 to javafx.fxml;
    exports project.demo_final_sec2_01;
}