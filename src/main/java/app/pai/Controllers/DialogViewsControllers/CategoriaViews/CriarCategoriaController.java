package app.pai.Controllers.DialogViewsControllers.CategoriaViews;

import app.pai.models.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CriarCategoriaController {

    @FXML
    private Button cancelarBtn;

    @FXML
    private TextField categoriaTextfield;

    @FXML
    private Button criarBtn;

    @FXML
    private Label labelMessage;


    ModelURL modelURL = new ModelURL();




    // estudar como funciona o choicebox e construir a função abaixo. Esse foi o ponto onde você parou.
    public void criarBtnOnClick() {
        String nomeCategoria = categoriaTextfield.getText();
        if (nomeCategoria != null) {
            ModelCategoria.createNewCategoriaInstance(new SimpleStringProperty(nomeCategoria));
        }
        cancelarBtnOnClick();
    }
    public void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) labelMessage.getScene().getWindow();
        stage.close();
    }


}
