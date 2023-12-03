package app.pai.Controllers.DialogViewsControllers.GeneroView;


import app.pai.models.Model;
import app.pai.models.ModelGenero;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ExcluirGeneroController implements Initializable {

    @FXML public Button excluirBtn;
    @FXML public Label generoTextfield = new Label();

    private ModelGenero modelGenero =  new ModelGenero();

    private String oldGeneroInformer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setGeneroTextfield(String generoTextfield) {
        this.generoTextfield.setText(generoTextfield);
    }

    public void setGeneroInformer(String text) {
        oldGeneroInformer = text;
    }

    public void excluirBtnOnClick() {
        modelGenero.RemoveGeneroInstance(oldGeneroInformer);
        cancelarBtnOnClick();
    }

    public void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) excluirBtn.getScene().getWindow();
        stage.close();
    }
}
