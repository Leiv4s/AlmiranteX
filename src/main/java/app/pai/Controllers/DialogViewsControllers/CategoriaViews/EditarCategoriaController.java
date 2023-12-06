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

public class EditarCategoriaController implements Initializable {


    @FXML
    private Button cancelarBtn;
    @FXML
    private Button editarBtn;
    @FXML
    private Label labelMessage;
    @FXML
    private TextField categoriaTextfield = new TextField();
    @FXML
    private ChoiceBox<String> generoComboBox;
    @FXML
    private ChoiceBox<String> publicoAlvoComboBox;

    private ModelURL modelUrl = new ModelURL();
    private ModelGenero modelGenero = new ModelGenero();
    private ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generoComboBox.getItems().addAll(modelGenero.getListaGeneroString());
        publicoAlvoComboBox.getItems().addAll(modelPublicoAlvo.getListaPublicoAlvoString());

    }


    static ModelCategoria categoriaReceiver;

    public void setCategoriaReceiver(ModelCategoria categoria) {
        categoriaReceiver = categoria;
        categoriaTextfield.setText(categoriaReceiver.getNome());
    }

    public void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage)generoComboBox.getScene().getWindow();
        stage.close();
    }

    public void editarBtnOnClick() {
        ModelCategoria updatedCategoria = new ModelCategoria(categoriaTextfield.getText(),generoComboBox.getValue(),publicoAlvoComboBox.getValue());
        if (updatedCategoria.getNome() != null && updatedCategoria.getPublicoAlvo() != null & updatedCategoria.getGenero() != null) {
            ModelCategoria.updateCategoriaInstance(categoriaReceiver, updatedCategoria);
        }
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        cancelarBtnOnClick();
    }


}
