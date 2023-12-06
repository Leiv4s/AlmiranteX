package app.pai.Controllers.DialogViewsControllers.CategoriaViews;

import app.pai.models.Model;
import app.pai.models.ModelCategoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ExcluirCategoriaController implements Initializable {

    @FXML
    private Button cancelarBtn;
    @FXML
    private Label categoriaTextfield;
    @FXML
    private Label labelMessage;
    @FXML
    private Button excluirBtn;

    ModelCategoria modelCategoria = new ModelCategoria();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private static ModelCategoria categoriaReceived;
    public void setCategoriaReceiver(ModelCategoria categoriaReceived) {
        ExcluirCategoriaController.categoriaReceived = categoriaReceived;
        categoriaTextfield.setText(categoriaReceived.getNome());
    }

    @FXML
    void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) excluirBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void excluirBtnOnClick() {
        ModelCategoria.removeCategoriaInstance(categoriaReceived.toString());
        cancelarBtnOnClick();
    }


}
