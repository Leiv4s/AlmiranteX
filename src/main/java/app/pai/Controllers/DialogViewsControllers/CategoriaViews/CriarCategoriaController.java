package app.pai.Controllers.DialogViewsControllers.CategoriaViews;

import app.pai.models.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CriarCategoriaController implements Initializable {

    @FXML
    private Button cancelarBtn;

    @FXML
    private TextField categoriaTextfield;

    @FXML
    private Button criarBtn;

    @FXML
    private ChoiceBox<String> generoChoiceBox;

    @FXML
    private Label labelMessage;

    @FXML
    private ChoiceBox<String> publicoAlvoChoiceBox;

    ModelURL modelURL = new ModelURL();
    ModelGenero modelGenero = new ModelGenero();
    ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
     generoChoiceBox.getItems().addAll(modelGenero.getListaGeneroString());
     publicoAlvoChoiceBox.getItems().addAll(modelPublicoAlvo.getListaPublicoAlvoString());
    }



    // estudar como funciona o choicebox e construir a função abaixo. Esse foi o ponto onde você parou.
    public void criarBtnOnClick() {
        String genero = generoChoiceBox.getValue();
        String publicoAlvo = publicoAlvoChoiceBox.getValue();
        String nomeCategoria = categoriaTextfield.getText();
        if (nomeCategoria != null && publicoAlvo != null & genero != null) {
            ModelCategoria.createNewCategoriaInstance(new ModelCategoria(nomeCategoria, publicoAlvo, genero));
        }
        cancelarBtnOnClick();
    }
    public void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) labelMessage.getScene().getWindow();
        stage.close();
    }


}
