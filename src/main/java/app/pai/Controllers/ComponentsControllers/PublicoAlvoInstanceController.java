package app.pai.Controllers.ComponentsControllers;


import app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews.EditarPublicoAlvoController;
import app.pai.models.Model;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
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
    private Button DeleteBtn;
    @FXML
    private Text targetPublicTextfield;


    private final URL updateWindowFXML = getClass().getResource("/Fxml/FXMLDialogViews/PublicoAlvoViews/UpdatePublicoAlvoView.fxml");
    private final URL removeWindowFXML = getClass().getResource("Fxml/FXMLDialogViews/PublicoAlvoViews/RemovePublicoAlvoView.fxml");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public URL getUpdateWindowFXML() {
        return updateWindowFXML;
    }
    public URL getRemoveWindowFXML() {
        return removeWindowFXML;
    }

    public void setPublicoAlvoInfoIntoContainer(StringProperty publicoAlvo){
        targetPublicTextfield.setText(publicoAlvo.getValue());
    }


    // O problema que estou tentando resolver é a passagem do valor antigo para ser atualizado,
    // o resto do codigo esta funcionando


    public void deleteBtnOnClick(){
        StringProperty publicoAlvoRemovido = new SimpleStringProperty(targetPublicTextfield.getText());
        ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
        modelPublicoAlvo.deletePublicoAlvo(publicoAlvoRemovido);
    }

    public void editarBtnOnClick() throws IOException {
        String oldPublicoAlvo = targetPublicTextfield.getText();
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        FXMLLoader loader = Model.getInstance().getViewFactory().loadDialogView(getUpdateWindowFXML());
        EditarPublicoAlvoController editarPublicoAlvoController =  loader.getController();
        editarPublicoAlvoController.setOldPublicoAlvo(oldPublicoAlvo);
    }




}
