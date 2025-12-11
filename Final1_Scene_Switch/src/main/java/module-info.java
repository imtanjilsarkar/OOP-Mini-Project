module project.final1_scene_switch {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens project.final1_scene_switch to javafx.fxml;
    exports project.final1_scene_switch;
}