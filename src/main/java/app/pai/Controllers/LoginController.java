package app.pai.Controllers;

import app.pai.models.ValidateUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {


    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Label labelMessage = new Label();



    public void tentativaLogin(ActionEvent event) {
        ValidateUser validateUser = new ValidateUser();
        String passwordDB = validateUser.getPassword();
        String usernameDB = validateUser.getUsername();

        if (usernameDB.equals(usernameField.getText()) && passwordDB.equals(passwordField.getText())) { // Use equals para comparar strings

            labelMessage.setText("Você fez login!");

        } else {
            labelMessage.setText("Senha/Usuário inválido. Tente novamente.");

        }
    }


}

