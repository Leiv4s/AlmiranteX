package app.pai.Controllers.DialogViewsControllers.GeneroView;


import app.pai.models.Model;
import app.pai.models.ModelGenero;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarGeneroController {

    @FXML
    public TextField generoTextfield;
    private static String receiver;

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void atualizarGeneroOnClick() {
        String nomeAntigo = receiver;
        String novoNome = generoTextfield.getText();
        ModelGenero modelGenero = new ModelGenero();
        modelGenero.updateGeneroInstance(nomeAntigo,novoNome);
        cancelarBtnOnClick();
    }

    public void cancelarBtnOnClick() {
        Stage stage = (Stage) generoTextfield.getScene().getWindow();
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        stage.close();
    }
}
