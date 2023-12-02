package app.pai.Controllers.ComponentsControllers;

import app.pai.models.Model;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PublicoAlvoInstanceController {

    @FXML
    private Button DeleteBtn;


    @FXML
    private Text targetPublicTextfield;

    private final URL updateWindowFXML = getClass().getResource("/Fxml/FXMLDialogViews/PublicoAlvoViews/UpdatePublicoAlvoView.fxml");
    private final URL removeWindowFXML = getClass().getResource("Fxml/FXMLDialogViews/PublicoAlvoViews/RemovePublicoAlvoView.fxml");

    public URL getUpdateWindowFXML() {
        return updateWindowFXML;
    }
    public URL getRemoveWindowFXML() {
        return removeWindowFXML;
    }

    public void setPublicoAlvoInfoIntoContainer(StringProperty publicoAlvo){
        targetPublicTextfield.setText(publicoAlvo.getValue());
    }

    public void deleteBtnOnClick(){
        StringProperty publicoAlvoRemovido = new SimpleStringProperty(targetPublicTextfield.getText());
        ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
        modelPublicoAlvo.deletePublicoAlvo(publicoAlvoRemovido);
    }

    public void editarBtnOnClick() throws IOException {

        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(getUpdateWindowFXML());
    }
}
