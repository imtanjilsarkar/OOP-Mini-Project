package project.last_demo_question_solve;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleGoal1(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void handleGoal2(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Goal2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}