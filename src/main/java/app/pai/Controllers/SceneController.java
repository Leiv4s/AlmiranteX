package app.pai.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;
@FXML
    public void switchToScene02(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/Fxml/Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
