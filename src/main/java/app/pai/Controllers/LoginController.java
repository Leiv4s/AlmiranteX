package app.pai.Controllers;


import app.pai.models.Venda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import app.pai.App;

import java.text.SimpleDateFormat;

public class LoginController {

    @FXML
    PasswordField passwordField;

    @FXML
    Label label;
@FXML
    public void testeLogin(ActionEvent e){

        label.setText(data+ " " + hora);
    }



}