package app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews;

import app.pai.models.Model;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CriarPublicoAlvoController {

    @FXML
    private Button criarBtn;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField publicoAlvoTextfield;

    public CriarPublicoAlvoController() {
    }

    public String getPublicoAlvoInserido() {
        return publicoAlvoTextfield.getText();
    }

    public void criarBtnOnClick(){
        ModelPublicoAlvo.createPublicoAlvo(new SimpleStringProperty(getPublicoAlvoInserido()));
    }


}
