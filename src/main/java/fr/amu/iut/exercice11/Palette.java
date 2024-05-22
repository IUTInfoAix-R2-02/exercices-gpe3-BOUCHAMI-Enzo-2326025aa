package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;


    @Override
    public void start(Stage primaryStage) {
        // Création d'un conteneur
        root = new BorderPane();
        //init
        vert = new Button("vert");
        rouge = new Button("rouge");
        bleu = new Button("bleu");
        Label label = new Label("Cliquez sur le bouton");
        panneau = new Pane();
        //
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbVert+=1;
            label.setText( "Vert choisi "+nbVert+" fois" );
            panneau.setStyle("-fx-background-color : green");
            texteDuBas.setText("Le Vert est une jolie couleur !");
            texteDuBas.setTextFill(Paint.valueOf("008000FF"));
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbRouge+=1;
            label.setText( "Rouge choisi "+nbRouge+" fois" );
            panneau.setStyle("-fx-background-color : red");
            texteDuBas.setText("Le Rouge est une jolie couleur !");
            texteDuBas.setTextFill(Paint.valueOf("FF0000FF"));
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbBleu+=1;
            label.setText( "Bleu choisi "+nbBleu+" fois" );
            panneau.setStyle("-fx-background-color : blue");
            texteDuBas.setText("Le Bleu est une jolie couleur !");
            texteDuBas.setTextFill(Paint.valueOf("0000FFFF"));
        });
        VBox basP = new VBox();
        // partie basse
         HBox bas = new HBox(10);
        bas.getChildren().addAll(
                vert,
                rouge,
                bleu
        );
        bas.setAlignment(Pos.CENTER);
        HBox bas2 = new HBox(10);
        texteDuBas = new Label("");
        bas2.setAlignment(Pos.CENTER_RIGHT);
        bas2.getChildren().add(texteDuBas);
        basP.getChildren().addAll(
                bas,
                bas2
        );

        BorderPane.setAlignment(label,Pos.CENTER);
        root.setTop(label);
        root.setCenter(panneau);
        bas.setPadding(new Insets(10));
        root.setBottom(basP);
        // Création de la scene
        Scene scene = new Scene( root );

        primaryStage.setScene( scene );

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}

