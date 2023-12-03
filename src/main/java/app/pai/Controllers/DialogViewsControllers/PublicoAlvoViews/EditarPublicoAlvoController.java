package app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews;


import app.pai.models.Model;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarPublicoAlvoController {
    @FXML
    private Button atualizarBtn;

    @FXML
    private Button cancelarBtn;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField publicoAlvoTextfield;

    public void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage)publicoAlvoTextfield.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }



    String oldPublicoAlvo;
    public void setOldPublicoAlvo(String oldPublicoAlvo) {
        this.oldPublicoAlvo = oldPublicoAlvo;
    }
    public void atualizarPublicoAlvoOnClick() {
        ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
        StringProperty newData = new SimpleStringProperty(this.publicoAlvoTextfield.getText());
        StringProperty oldData = new SimpleStringProperty(oldPublicoAlvo);
        modelPublicoAlvo.updatePublicoAlvo(oldData, newData);
    }
}
