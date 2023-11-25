package app.pai.Controllers.ComponentsControllers;

import app.pai.Controllers.MenuSectionControllers.EditarLojaController;
import app.pai.Controllers.PersistanceController;
import app.pai.models.Categoria;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ComponentCategoryContainerController extends PersistanceController {

    @FXML
    private Text nameCategory;

    @FXML
    private Text targetPublicCategory;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button editarBtn;


    //atribui os valores de categoria aos FXMLComponents que serão exibidos
    public void setCategoryInfoIntoContainer(Categoria categoria) throws IOException, ClassNotFoundException {

        nameCategory.setText(categoria.getNomeCategoria());
        targetPublicCategory.setText(categoria.getPublicoAlvoCategoria());
    }

    //delete categoria
    public void deleteCategoria() {

    }

}
