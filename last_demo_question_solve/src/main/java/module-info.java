module project.last_demo_question_solve {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens project.last_demo_question_solve to javafx.fxml;
    exports project.last_demo_question_solve;
}