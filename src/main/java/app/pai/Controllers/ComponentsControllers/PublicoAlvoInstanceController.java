package app.pai.Controllers.ComponentsControllers;

import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class PublicoAlvoInstanceController {

    @FXML
    private Button publicDeleteBtn;

    @FXML
    private Button publicEditarBtn;

    @FXML
    private Text targetPublicTextfield;


    public void setPublicoAlvoInfoIntoContainer(StringProperty publicoAlvo){
        targetPublicTextfield.setText(publicoAlvo.getValue());
    }

    public void deleteBtnOnClick(){
        StringProperty publicoAlvoRemovido = new SimpleStringProperty(targetPublicTextfield.getText());
        ModelPublicoAlvo.deletePublicoAlvo(publicoAlvoRemovido);
        
    }
}
