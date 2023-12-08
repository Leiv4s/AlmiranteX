package app.pai.Controllers.DialogViewsControllers.CategoriaViews;


import app.pai.models.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditarCategoriaController  {


    @FXML
    private Button cancelarBtn;
    @FXML
    private Button editarBtn;
    @FXML
    private Label labelMessage;
    @FXML
    private TextField categoriaTextfield = new TextField();

    private ModelURL modelUrl = new ModelURL();





    static StringProperty categoriaReceiver;

    public void setCategoriaReceiver(StringProperty categoria) {
        categoriaReceiver = categoria;
        categoriaTextfield.setText(categoriaReceiver.getValue());
    }

    public void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage)categoriaTextfield.getScene().getWindow();
        stage.close();
    }

    public void editarBtnOnClick() {
        SimpleStringProperty updatedCategoria = new SimpleStringProperty(categoriaTextfield.getText());
        if (updatedCategoria.getValue() != null) {
            ModelCategoria.updateCategoriaInstance(categoriaReceiver, updatedCategoria);
        }
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        cancelarBtnOnClick();
    }


}
