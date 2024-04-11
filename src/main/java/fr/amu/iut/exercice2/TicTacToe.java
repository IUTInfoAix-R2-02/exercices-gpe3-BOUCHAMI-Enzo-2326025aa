package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToe extends Application {



    public Node aleatoire(){
        ImageView image = new ImageView("exercice2/Croix.png");
        ImageView image2 = new ImageView("exercice2/Rond.png");
        ImageView image3 = new ImageView("exercice2/Vide.png");
        Random random = new Random();
        int nombre = random.nextInt(3);

        if(nombre==0){
            return image2;
        } else if (nombre==1) {
            return image;

        }
        else{
            return image3;
        }
    }




    @Override
    public void start(Stage primaryStage) {


        BorderPane borderpane = new BorderPane();
        GridPane gridpane = new GridPane();
        Label label = new Label();


        GridPane gridpane1 = new GridPane();

        gridpane1.add(aleatoire(),0,0);
        gridpane1.add(aleatoire(),0,1);
        gridpane1.add(aleatoire(),0,2);
        gridpane1.add(aleatoire(),1,0);
        gridpane1.add(aleatoire(),1,1);
        gridpane1.add(aleatoire(),1,2);
        gridpane1.add(aleatoire(),2,0);
        gridpane1.add(aleatoire(),2,1);
        gridpane1.add(aleatoire(),2,2);

        gridpane1.setGridLinesVisible(true);

        borderpane.getChildren().add(gridpane1);

        Scene scene = new Scene(borderpane);
        primaryStage.setScene( scene );
        primaryStage.setWidth( 134 );
        primaryStage.setHeight( 180);
        primaryStage.setTitle("VBox and HBox App");









        primaryStage.show();
    }
}

