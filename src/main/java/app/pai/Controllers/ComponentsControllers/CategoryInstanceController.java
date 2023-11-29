package app.pai.Controllers.ComponentsControllers;

import app.pai.models.ModelCategoria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class CategoryInstanceController {

    @FXML
    private Text nameCategory;

    @FXML
    private Text targetPublicCategory;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button editarBtn;






    //atribui os valores de modelCategoria aos FXMLComponents que serão exibidos
    public void setCategoryInfoIntoContainer(ModelCategoria modelCategoria){
        nameCategory.setText(modelCategoria.getNome());
        targetPublicCategory.setText(modelCategoria.getPublicoAlvo());
    }

    //delete modelCategoria
    public void deleteCategoria() {

    }

}
