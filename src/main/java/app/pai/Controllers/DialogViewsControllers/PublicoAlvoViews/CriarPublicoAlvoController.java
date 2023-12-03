package app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews;

import app.pai.models.Model;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CriarPublicoAlvoController {

    @FXML
    private Button criarBtn;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField publicoAlvoTextfield;
    @FXML
    private Button cancelarBtn;


    public CriarPublicoAlvoController() {
    }






    public void criarBtnOnClick(){
        ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
        modelPublicoAlvo.createNewPublicoAlvoInstance(new SimpleStringProperty(getPublicoAlvoInserido()));
        cancelarBtnOnClick();
    }
    public String getPublicoAlvoInserido() {
        return publicoAlvoTextfield.getText();
    }


    public void cancelarBtnOnClick() {
        Stage stage = (Stage)labelMessage.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
    }

    public void editarBtnOnClick(){
        Stage stage = (Stage)labelMessage.getScene().getWindow();

    }




}
