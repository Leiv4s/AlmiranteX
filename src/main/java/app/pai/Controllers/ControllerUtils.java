package app.pai.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class ControllerUtils {

    public static <T> T getControllerFromStage(Stage stage, Class<T> controllerClass) {
        Parent root = stage.getScene().getRoot();

        if (root != null) {
            Object controller = root.getProperties().get("fx:controller");

            if (controllerClass.isInstance(controller)) {
                return controllerClass.cast(controller);
            }
        }

        return null;
    }
}
