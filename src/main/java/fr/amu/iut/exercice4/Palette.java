package fr.amu.iut.exercice4;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création d'un conteneur
        root = new BorderPane();
        //init
        vert = new Button("vert");
        rouge = new Button("rouge");
        bleu = new Button("bleu");
        label = new Label("");
        panneau = new Pane();
        //
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbVert+=1;
            label.setText( "Vert choisi "+nbVert+" fois" );
            panneau.setStyle("-fx-background-color : green");
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbRouge+=1;
            label.setText( "Rouge choisi "+nbRouge+" fois" );
            panneau.setStyle("-fx-background-color : red");
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbBleu+=1;
            label.setText( "Bleu choisi "+nbBleu+" fois" );
            panneau.setStyle("-fx-background-color : blue");
        });

        // partie basse
        bas = new HBox(10);
        bas.getChildren().addAll(
                vert,
                rouge,
                bleu
        );
        bas.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(label,Pos.CENTER);
        root.setTop(label);
        root.setCenter(panneau);
        bas.setPadding(new Insets(10));
        root.setBottom(bas);
        // Création de la scene
        Scene scene = new Scene( root );

        primaryStage.setScene( scene );

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}

