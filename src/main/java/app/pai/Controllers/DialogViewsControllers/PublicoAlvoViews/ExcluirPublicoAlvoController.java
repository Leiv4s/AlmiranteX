package app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews;

import app.pai.models.Model;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ExcluirPublicoAlvoController implements Initializable {



    @FXML
    private Label publicoAlvoTextfield;

    @FXML
    private Button cancelarBtn;

    @FXML
    private Button excluirBtn;

    @FXML
    private Label labelMessage;

    public void setPublicoAlvoTextfield(String publicoAlvoTextfield) {
        this.publicoAlvoTextfield.setText(publicoAlvoTextfield);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        publicoAlvoTextfield.setText(publicoAlvoParaRemocao);
    }

    @FXML
    void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) publicoAlvoTextfield.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }


    private String publicoAlvoParaRemocao;

    public void setPublicoAlvoParaRemocao(String publicoAlvoParaRemocao) {
        this.publicoAlvoParaRemocao = publicoAlvoParaRemocao;
    }

    @FXML
    void excluirBtnOnClick() {
        publicoAlvoTextfield.setText(publicoAlvoParaRemocao);
        StringProperty publicoAlvoRemovido = new SimpleStringProperty(publicoAlvoParaRemocao);
        ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
        modelPublicoAlvo.deletePublicoAlvo(publicoAlvoRemovido);
        cancelarBtnOnClick();
    }
}


