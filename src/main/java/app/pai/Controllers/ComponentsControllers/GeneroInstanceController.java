package app.pai.Controllers.ComponentsControllers;


import app.pai.Controllers.DialogViewsControllers.GeneroView.EditarGeneroController;
import app.pai.Controllers.DialogViewsControllers.GeneroView.ExcluirGeneroController;
import app.pai.models.Model;
import app.pai.models.ModelURL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Text;
import java.io.IOException;

public class GeneroInstanceController {


    @FXML public Text generoTextfield;
    ModelURL modelURL = new ModelURL();


    public void setGeneroInfoIntoContainer(StringProperty modelGenero) {
        generoTextfield.setText(modelGenero.getValue());
    }


    public void editarBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getEditarGeneroFXML());
        EditarGeneroController editarGeneroController = new EditarGeneroController();
        editarGeneroController.setReceiver(generoTextfield.getText());
    }

    public void excluirBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        FXMLLoader loader =  Model.getInstance().getViewFactory().loadDialogView(modelURL.getExcluirGeneroFXML());
        ExcluirGeneroController excluirGeneroController = loader.getController();
        excluirGeneroController.setGeneroInformer(generoTextfield.getText());
        excluirGeneroController.setGeneroTextfield(generoTextfield.getText());
    }

}
