package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    TextField usId=new TextField();
    @FXML
    PasswordField pwd = new PasswordField();
    @FXML
    Button ok = new Button();
    @FXML
    Button cancel = new Button();

    public void okClicked() {
        System.out.println(usId.getText());

    }

    public void cancelClicked() {
        usId.clear();
        pwd.clear();
    }
}