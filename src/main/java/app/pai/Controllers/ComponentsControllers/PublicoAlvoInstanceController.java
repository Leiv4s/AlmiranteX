package app.pai.Controllers.ComponentsControllers;


import app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews.EditarPublicoAlvoController;
import app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews.ExcluirPublicoAlvoController;
import app.pai.models.Model;
import app.pai.models.Utils.ModelURL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PublicoAlvoInstanceController implements Initializable {

    @FXML
    public Button publicDeleteBtn;
    @FXML
    private Text targetPublicTextfield;
    private ModelURL modelURL = new ModelURL();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setPublicoAlvoInfoIntoContainer(StringProperty publicoAlvo){
        targetPublicTextfield.setText(publicoAlvo.getValue());
    }


    // O problema que estou tentando resolver é a passagem do valor antigo para ser atualizado,
    // o resto do codigo esta funcionando


    public void deleteBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        FXMLLoader loader = Model.getInstance().getViewFactory().loadDialogView(modelURL.getExcluirPublicoAlvoFXML());
        ExcluirPublicoAlvoController excluirPublicoAlvoController = loader.getController();
        excluirPublicoAlvoController.setPublicoAlvoParaRemocao(targetPublicTextfield.getText());
        excluirPublicoAlvoController.setPublicoAlvoTextfield(targetPublicTextfield.getText());
    }



    public void editarBtnOnClick() throws IOException {
        String oldPublicoAlvo = targetPublicTextfield.getText();
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        FXMLLoader loader = Model.getInstance().getViewFactory().loadDialogView(modelURL.getEditarPublicoAlvoFXML());
        EditarPublicoAlvoController editarPublicoAlvoController =  loader.getController();
        editarPublicoAlvoController.setOldPublicoAlvo(oldPublicoAlvo);
    }




}
