package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {
    private String lettresDevinees = "";
    private int tentativesRestantes;
    Label tentativesRestes;
    private Button devinerButton = new Button("Devinez");
    Dico dico = new Dico();
    Label mot = new Label(dico.getMot());
    ImageView imageView;

    private void updateTentativesLabel(Label tentativesRestes) {
        tentativesRestes.setText("Tentatives restantes : " + tentativesRestantes);
    }

    private void gameOver(String message,Label tentativesRestes ) {
        mot.setDisable(true);
        tentativesRestes.setText(message);
    }

    private void updateImg(){
        Image imagedeRemplacement= new Image("exercice6/pendu"+tentativesRestantes+".png");
        imageView.setImage(imagedeRemplacement);
        System.out.println(tentativesRestantes);
    }

    private void devinerLettre(Label motADecorous, Label tentativesRestes) {
        String lettre = mot.getText().toLowerCase();
        if (lettre.length() == 1 && Character.isLetter(lettre.charAt(0))) {
            if (!lettresDevinees.contains(lettre)) {
                lettresDevinees += lettre;
                //updateMotCacheLabel();
                if (!motADecorous.getText().contains(lettre)) {
                    tentativesRestantes--;
                    updateImg();
                    updateTentativesLabel(tentativesRestes);
                }

            }
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // A completer
        VBox vbox= new VBox();
        vbox.setStyle("-fx-background-color: #AFEEEE;");
        Dico dico = new Dico();
        Label mot = new Label(dico.getMot());
        TextField field = new TextField();


        //nb vie et affichage image
        int nb_vie=7;
        ImageView imageView = new ImageView("exercice6/pendu"+nb_vie+".png");
        Label vie = new Label("Nombre de vies : "+nb_vie);
        vbox.getChildren().add(vie);

        String motcacher = new String();
        for(int i= 0;i<mot.getText().length();i++){
            motcacher+="*";
        }
        Label motcacherOnScreen = new Label(motcacher);

        tentativesRestes =new Label();
        updateTentativesLabel(tentativesRestes);

        devinerButton.setOnAction(e -> devinerLettre(mot,tentativesRestes));

        vbox.getChildren().addAll(imageView,tentativesRestes,mot,devinerButton);

        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(motcacherOnScreen);

        vbox.getChildren().addAll(field);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        Scene scene = new Scene(vbox);
        primaryStage.setScene( scene );
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
