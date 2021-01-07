package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javax.print.DocFlavor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    private ToggleGroup mainChoice;

    @FXML
    private Label statusLabel;

    @FXML
    private ListView<String> mainList;


    private ObservableList<String> motionsOfList;

    private Gamer gamer;
    private String[][] field = new String[3][3];
    private Cell cell;
    private String motionOfGamer;
    private int flag = 0;
    private int setup = 0;
    @FXML
    void mainRegister(MouseEvent event) {
        try{
            cell = new Cell();
            flag++;
            if(flag == 1){
                setStartArray(field);
            }

            InputStream inputStreamX = getClass().getResourceAsStream("/resource/mainX.png");
            InputStream inputStreamO = getClass().getResourceAsStream("/resource/zero.png");
            if(gamer.getMotion() == "X"){
                Image imageX = new Image(inputStreamX);
                cell.setValue("X");
                getMotionMain(event.getSource(), imageX);
                gamer.setMotion("O");
            } else {
                Image imageO = new Image(inputStreamO);
                cell.setValue("O");
                getMotionMain(event.getSource(), imageO);
                gamer.setMotion("X");
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    void getMotionMain(Object object, Image image){

        if(object == imageOne){
            imageOne.setImage(image);
            imageOne.setDisable(true);

            cell.setPositionX(0);
            cell.setPositionY(0);

        }
        else if (object == imageTwo){
            imageTwo.setImage(image);
            imageTwo.setDisable(true);
            cell.setPositionX(0);
            cell.setPositionY(1);
        }
        else if (object == imageThree){
            imageThree.setImage(image);
            imageThree.setDisable(true);
            cell.setPositionX(0);
            cell.setPositionY(2);

        }
        else if (object == imageFour){
            imageFour.setImage(image);
            imageFour.setDisable(true);

            cell.setPositionX(1);
            cell.setPositionY(0);
        }
        else if (object == imageFive){
            imageFive.setImage(image);
            imageFive.setDisable(true);

            cell.setPositionX(1);
            cell.setPositionY(1);
        }
        else if (object == imageSix){
            imageSix.setImage(image);
            imageSix.setDisable(true);

            cell.setPositionX(1);
            cell.setPositionY(2);
        }
        else if (object == imageSeven){
            imageSeven.setImage(image);
            imageSeven.setDisable(true);

            cell.setPositionX(2);
            cell.setPositionY(0);

        }
        else if (object == imageEight){
            imageEight.setImage(image);
            imageEight.setDisable(true);

            cell.setPositionX(2);
            cell.setPositionY(1);

        }
        else if (object == imageNine){
            imageNine.setImage(image);
            imageNine.setDisable(true);

            cell.setPositionX(2);
            cell.setPositionY(2);
        }
        motionsOfList = FXCollections.observableArrayList();
        motionsOfList.add(": Стр" + cell.getPositionX() +
                "Столб" + cell.getPositionY());
        mainList.setItems(motionsOfList);

        System.out.println(flag);
        field[cell.getPositionX()][cell.getPositionY()] = cell.getValue();
        if(flag >= 5 && flag != 9){
            searchWin(field);
        }else if(flag == 9){
            searchWin(field);
            restartingGame();
        }

    }
    void setStartArray(String[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = " " + setup;
                setup++;
            }
        }
        setup = 0;
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
    void setDisableMain(){
        imageOne.setDisable(false);
        imageTwo.setDisable(false);
        imageThree.setDisable(false);
        imageFour.setDisable(false);
        imageFive.setDisable(false);
        imageSix.setDisable(false);
        imageSeven.setDisable(false);
        imageEight.setDisable(false);
        imageNine.setDisable(false);
    }

    void searchWin(String[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        if(array[0][0] == array[0][1] &&
                array[0][0] == array[0][2]){
            System.out.println("YOU WIN!!!");
            showWin();
            restartingGame();
        } else if(array[1][0]== array[1][1] &&
                array[1][0]== array[1][2]){
            System.out.println("YOU WIN!!!");
            restartingGame();
        }else if(array[2][0]== array[2][1]&&
                array[2][0]== array[2][2]){
            System.out.println("YOU WIN!!!");
            restartingGame();
        }else if(array[0][0]== array[1][0]&&
                array[0][0]== array[2][0]){
            System.out.println("YOU WIN!!!");
            restartingGame();
        }else if(array[0][1]== array[1][1]&&
                array[0][1]== array[2][1]){
            System.out.println("YOU WIN!!!");
            restartingGame();
        }else if(array[0][2]== array[1][2]&&
                array[0][2]== array[2][2]){
            System.out.println("YOU WIN!!!");
            restartingGame();
        }else if(array[0][0]== array[1][1]&&
                array[0][0]== array[2][2]){
            System.out.println("YOU WIN!!!");
            restartingGame();
        }else if(array[0][2]== array[1][1]&&
                array[0][2]== array[2][0]){
            System.out.println("YOU WIN!!!");
            restartingGame();
        }
    }

    @FXML
    void startingGame(){
        gamer = new Gamer("Aleksey", motionOfGamer);
    }
    @FXML
    void restartingGame(){
        clearAll();
        setDisableMain();
        flag = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = "" + setup;
                setup++;
            }
        }
        setup = 0;
    }
    void showWin(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("YOU WIN!");
        alert.setHeaderText("You have a great mind ");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
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
