package app.pai.Controllers;

import app.pai.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable {

    @FXML
    Label label;

    @FXML
     BorderPane MainPane;


    private void inicio(ActionEvent event){
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Inicio");
        MainPane.setLeft(view);
    }


                        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
