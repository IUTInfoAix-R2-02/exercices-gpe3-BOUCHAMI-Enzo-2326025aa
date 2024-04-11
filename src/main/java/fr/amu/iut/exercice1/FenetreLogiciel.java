package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création du conteneur principal
        BorderPane borderPane = new BorderPane();

        //Creation du menuBar
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Edit");
        Menu menu3 = new Menu("Help");

        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);

        //Sous menu1
        MenuItem menuItem1 = new MenuItem("New");
        MenuItem menuItem2 = new MenuItem("Open");
        MenuItem menuItem3 = new MenuItem("Save");
        MenuItem menuItem4 = new MenuItem("Close");
        menu1.getItems().addAll(menuItem1,menuItem2,menuItem3,menuItem4);

        //Sous menu2
        MenuItem menuItem12 = new MenuItem("Cut");
        MenuItem menuItem22 = new MenuItem("Copy");
        MenuItem menuItem32 = new MenuItem("Paste");
        menu2.getItems().addAll(menuItem12,menuItem22,menuItem32);


        // Création de la ligne de séparation
        Separator sep = new Separator();
        Separator sep2 = new Separator(Orientation.VERTICAL);
        // Création du bandeau en bas de la fenêtre
        VBox bottomControls = new VBox();
        Text label = new Text("Ceci est un label de bas de page");
        bottomControls.setAlignment(Pos.CENTER);
        bottomControls.getChildren().addAll(
                sep,
                label
        );

        //Creation partie de gauche
        VBox gauche = new VBox(10);
        Text boutons = new Text("Boutons :");
        Button bouton1 = new Button("Bouton 1");
        Button bouton2 = new Button("Bouton 2");
        Button bouton3 = new Button("Bouton 3");
        gauche.setAlignment(Pos.CENTER);
        gauche.getChildren().addAll(
                boutons,
                bouton1,
                bouton2,
                bouton3
        );
        HBox gauche1 = new HBox();
        gauche1.getChildren().addAll(gauche,sep2);


        //center
        GridPane center = new GridPane();
        Text name = new Text("Name:");
        center.add(name,0,0);
        TextField champ = new TextField();
        center.add(champ,1,0);
        Text email = new Text("Email:");
        center.add(email,0,1);
        TextField champ2 = new TextField();
        center.add(champ2,1,1);
        Text password = new Text("Password:");
        center.add(password,0,2);
        TextField champ3 = new TextField();
        center.add(champ3,1,2);

        center.setHgap(10);
        center.setVgap(10);
        HBox mid = new HBox(10);
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        mid.getChildren().addAll(
            submit,
            cancel
       );
        VBox mid1 = new VBox();
        mid1.getChildren().addAll(mid);
        center.add(mid1,1,3);
        center.setAlignment(Pos.CENTER);
//        VBox center = new VBox();
//        HBox center1 = new HBox();
//        Text name = new Text("Name:");
//        TextField champ = new TextField();
//        center1.getChildren().addAll(name,champ);
//        center1.setAlignment(Pos.CENTER);
//        HBox center2 = new HBox();
//        Text email = new Text("Email:");
//        TextField champ2 = new TextField();
//        center2.setAlignment(Pos.CENTER);
//        center2.getChildren().addAll(email,champ2);
//        HBox center3 = new HBox();
//        Text password = new Text("Password:");
//        TextField champ3 = new TextField();
//        center3.getChildren().addAll(password,champ3);
//        center3.setAlignment(Pos.CENTER);
//
//        Button submit = new Button("Submit");
//        center.getChildren().addAll(
//                sep2,
//                center1,
//                center2,
//                center3
//        );
        // Ajout des contrôleurs au conteneur principal
        borderPane.setTop(menuBar);
        borderPane.setLeft(gauche1);
        borderPane.setCenter(center);
        borderPane.setBottom(bottomControls);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(borderPane );

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

