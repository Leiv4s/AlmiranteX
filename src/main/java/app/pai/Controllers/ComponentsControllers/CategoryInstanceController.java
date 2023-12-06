package app.pai.Controllers.ComponentsControllers;


import app.pai.Controllers.DialogViewsControllers.CategoriaViews.EditarCategoriaController;
import app.pai.Controllers.DialogViewsControllers.CategoriaViews.ExcluirCategoriaController;
import app.pai.models.Model;
import app.pai.models.ModelCategoria;
import app.pai.models.ModelURL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.io.IOException;


public class CategoryInstanceController {


    @FXML
    private Button deleteBtn;

    @FXML
    private Button editarBtn;
    @FXML
    private Text nameCategory;
    @FXML
    private Text targetPublicCategory;
    @FXML
    private Text generoCategory;

    private ModelURL modelURL = new ModelURL();


    //atribui os valores de modelCategoria aos FXMLComponents que serão exibidos
    public void setCategoryInfoIntoContainer(ModelCategoria modelCategoria){
        nameCategory.setText(modelCategoria.getNome());
        targetPublicCategory.setText(modelCategoria.getPublicoAlvo());
        generoCategory.setText(modelCategoria.getGenero());
    }



    public void editarBtnOnClick() throws IOException {
        ModelCategoria categoria = new ModelCategoria(nameCategory.getText(),targetPublicCategory.getText(),generoCategory.getText());
        FXMLLoader loader = Model.getInstance().getViewFactory().loadDialogView(modelURL.getEditarCategoriaFXML());
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        EditarCategoriaController editarCategoriaController = new EditarCategoriaController();
        editarCategoriaController.setCategoriaReceiver(categoria);
    }
    public void excluirBtnOnClick() throws IOException {
        ModelCategoria auxiliar = new ModelCategoria(nameCategory.getText(), targetPublicCategory.getText(), generoCategory.getText());
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        FXMLLoader loader = Model.getInstance().getViewFactory().loadDialogView(modelURL.getExcluirCategoriaFXML());
        ExcluirCategoriaController excluirCategoriaController = loader.getController();
        System.out.println(auxiliar);
        excluirCategoriaController.setCategoriaReceiver(auxiliar);
    }
}
