package app.pai.Controllers.DialogViewsControllers.GeneroView;


import app.pai.Controllers.ComponentsControllers.GeneroInstanceController;
import app.pai.models.Model;
import app.pai.models.ModelGenero;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CriarGeneroController {

    @FXML public TextField generoTextfield;
    public void criarBtnOnClick() {
        String novoGenero = generoTextfield.getText();
        ModelGenero modelGenero = new ModelGenero();
        modelGenero.createNewGeneroInstance(novoGenero);
        cancelarBtnOnClick();
    }

    public void cancelarBtnOnClick() {
        Stage stage = (Stage)generoTextfield.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
    }
}
