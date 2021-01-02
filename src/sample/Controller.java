package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button btnStart;

    @FXML
    private Button btnRestart;

    @FXML
    void initialize(){
        btnStart.setOnAction( actionEvent -> {
            System.out.println("Hello");
        });
    }
}

