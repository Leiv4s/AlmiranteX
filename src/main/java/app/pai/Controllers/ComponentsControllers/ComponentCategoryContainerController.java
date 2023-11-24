package app.pai.Controllers.ComponentsControllers;

import app.pai.models.Categoria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class ComponentCategoryContainerController {

    @FXML
    private Text idCategory;

    @FXML
    private Text nameCategory;

    @FXML
    private Text targetPublicCategory;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button editarBtn;



    public void setData(Categoria categoria) {
        idCategory.setText("0");
        nameCategory.setText(categoria.getNomeCategoria());
        targetPublicCategory.setText(categoria.getPublicoAlvoCategoria());

    }
}
