package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.InputStream;

public class Controller {

    @FXML
    private Button btnStart;

    @FXML
    private Button btnRestart;

    @FXML
    private ImageView imageOne;

    @FXML
    private ImageView imageTwo;

    @FXML
    private ImageView imageThree;

    @FXML
    private ImageView imageFour;

    @FXML
    private ImageView imageFive;

    @FXML
    private ImageView imageSix;

    @FXML
    private ImageView imageSeven;

    @FXML
    private ImageView imageEight;

    @FXML
    private ImageView imageNine;

    @FXML
    void mainRegister(MouseEvent event) {
        InputStream inputStream = getClass().getResourceAsStream("/resource/x.png");
        Image image = new Image(inputStream);
        imageOne.setImage(image);
    }


}
