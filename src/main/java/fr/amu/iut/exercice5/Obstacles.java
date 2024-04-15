package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Obstacles extends Rectangle {
    Obstacles(double x,double y,double width,double weight){
        super(x,y,width,weight);
        setFill(Color.RED);
    }

}
