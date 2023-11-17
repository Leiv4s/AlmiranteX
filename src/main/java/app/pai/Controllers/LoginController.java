package app.pai.Controllers;

import app.pai.models.Model;
import app.pai.models.ValidateUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {


    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Label labelMessage = new Label();

    public void tentativaLogin() {
        ValidateUser validateUser = new ValidateUser();
        String passwordDB = validateUser.getPassword();
        String usernameDB = validateUser.getUsername();

        if (usernameDB.equals(usernameField.getText()) && passwordDB.equals(passwordField.getText())) {
            /*JavaFX doesn't have a way to references a Stage, so this is a way of doing this:
            First you create a Stage variable that takes any controllers of the Stage that you
            wanna close, at the selected controller, apply getScene and getWindow methods. After
            that you need to cast the return of the methods called as Stage (lines 44/45)
            * */
            Stage stage = (Stage)labelMessage.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showUserWindow();

        } else {
            labelMessage.setText("Senha/Usuário inválido. Tente novamente.");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setOnAction(event -> tentativaLogin());
    }
}

