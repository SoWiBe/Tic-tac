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

    private Gamer gamer;
    private String motionOfGamer;
    @FXML
    void mainRegister(MouseEvent event) {
        InputStream inputStreamX = getClass().getResourceAsStream("/resource/x.png");
        InputStream inputStreamO = getClass().getResourceAsStream("/resource/zero.png");

        if(gamer.getMotion() == "X"){
            Image imageX = new Image(inputStreamX);
            getMotionMain(event.getSource(), imageX);
        } else {
            Image imageO = new Image(inputStreamO);
            getMotionMain(event.getSource(), imageO);
        }
    }
    void getMotionMain(Object object, Image image){
        if(object == imageOne)
            imageOne.setImage(image);
        else if (object == imageTwo)
            imageTwo.setImage(image);
        else if (object == imageThree)
            imageThree.setImage(image);
        else if (object == imageFour)
            imageFour.setImage(image);
        else if (object == imageFive)
            imageFive.setImage(image);
        else if (object == imageSix)
            imageSix.setImage(image);
        else if (object == imageSeven)
            imageSeven.setImage(image);
        else if (object == imageEight)
            imageEight.setImage(image);
        else if (object == imageNine)
            imageNine.setImage(image);
    }
    void clearAll(){
        imageOne.setImage(null);
        imageTwo.setImage(null);
        imageThree.setImage(null);
        imageFour.setImage(null);
        imageFive.setImage(null);
        imageSix.setImage(null);
        imageSeven.setImage(null);
        imageEight.setImage(null);
        imageNine.setImage(null);
    }
    @FXML
    void startingGame(){
        gamer = new Gamer("Aleksey", motionOfGamer);
    }
    @FXML
    void restartingGame(){
        clearAll();
    }

    @FXML
    void setO(MouseEvent event) {
        motionOfGamer = "O";
    }

    @FXML
    void setX(MouseEvent event) {
        motionOfGamer = "X";
    }

}
