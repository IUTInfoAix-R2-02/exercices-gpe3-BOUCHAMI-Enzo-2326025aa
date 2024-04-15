package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Fantome extends Personnage {

    private Rectangle basCorps;


    private Circle oeilGauche;
    private Circle retineGauche;

    private Circle oeilDroit;
    private Circle retineDroite;


    public Fantome() {
        super("droite", Color.BLUE, Color.BLUE);
        basCorps = new Rectangle(0, 10, 20, 10);
        basCorps.setFill(Color.BLUE);

        oeilGauche = new Circle(6, 6, 2, Color.WHITE);
        //regarde vers la droite
        retineGauche = new Circle(oeilGauche.getCenterX() + 1, 6, 1, Color.BLACK);

        oeilDroit = new Circle(14, 6, 2, Color.WHITE);
        //regarde vers la droite
        retineDroite = new Circle(oeilDroit.getCenterX() + 1, 6, 1, Color.BLACK);


        super.getChildren().add(basCorps);
        super.getChildren().add(oeilGauche);
        super.getChildren().add(retineGauche);
        super.getChildren().add(oeilDroit);
        super.getChildren().add(retineDroite);
    }

    @Override
    public void deplacerAGauche() {
        super.deplacerAGauche();
        //regarde vers la gauche
        retineGauche.setCenterX(5);
        retineDroite.setCenterX(13);

        retineGauche.setCenterY(6);
        retineDroite.setCenterY(6);
    }

    @Override
    public void deplacerADroite(double largeurJeu) {
        super.deplacerADroite(largeurJeu);
        retineGauche.setCenterX(7);
        retineDroite.setCenterX(15);

        retineGauche.setCenterY(6);
        retineDroite.setCenterY(6);
    }

    @Override
    public void deplacerEnBas(double hauteurJeu) {
        super.deplacerEnBas(hauteurJeu);
        retineGauche.setCenterX(6);
        retineDroite.setCenterX(14);

        retineGauche.setCenterY(7);
        retineDroite.setCenterY(7);
    }

    @Override
    public void deplacerEnHaut() {
        super.deplacerEnHaut();
        retineGauche.setCenterX(6);
        retineDroite.setCenterX(14);

        retineGauche.setCenterY(5);
        retineDroite.setCenterY(5);
    }

}
