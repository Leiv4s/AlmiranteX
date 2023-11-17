package app.pai.views;

import app.pai.Controllers.UserController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewFactory  {


//this function creates and load the login screen.
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        createStage(loader);
    }

//this function creates and load the User initial screen.
    public void showUserWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/User.fxml"));
        UserController userController = new UserController();
        loader.setController(userController);

    }

//this function recives a FXMLLoader object and create a stage and scene with it
    public void createStage(FXMLLoader loader){
        Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
