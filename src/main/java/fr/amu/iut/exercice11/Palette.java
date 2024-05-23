package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
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

    IntegerProperty nbFois = new SimpleIntegerProperty();
    StringProperty nomDuBouton = new SimpleStringProperty();

    StringProperty couleurDuPanneau = new SimpleStringProperty("#FFFFFF");


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");


        nbFois.setValue(0);



        /* VOTRE CODE ICI */

        boutons.getChildren().addAll(vert, rouge, bleu);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbVert+=1;
            nbFois.setValue(nbVert);
            nomDuBouton.setValue("Vert");
            couleurDuPanneau.setValue("green");

        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbRouge+=1;
            nbFois.setValue(nbRouge);
            nomDuBouton.setValue("Rouge");
            couleurDuPanneau.setValue("red");

        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbBleu+=1;
            nbFois.setValue(nbBleu);
            nomDuBouton.setValue("Bleu");
            couleurDuPanneau.setValue("blue");

        });

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);
        createBindings();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void createBindings(){
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty();
        pasEncoreDeClic.bind(nbFois.isEqualTo(0));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic).then(Bindings.concat("Cliquez sur le bouton")).otherwise(Bindings.concat(nomDuBouton," choisi ",nbFois," fois")));;
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color:", couleurDuPanneau));

        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClic).then(Bindings.concat("")).otherwise(Bindings.concat("Le ",nomDuBouton," est une jolie couleur ! ")));
        texteDuBas.styleProperty().bind(Bindings.when(pasEncoreDeClic).then(Bindings.concat("-fx-text-fill:white")).otherwise(Bindings.concat("-fx-text-fill:",couleurDuPanneau)));
    }
}