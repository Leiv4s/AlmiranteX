package app.pai.views;

import app.pai.Controllers.EditarLojaController;
import app.pai.Controllers.EstoqueController;
import app.pai.Controllers.InicioController;
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

// FUNCTION FOR BUILDING SCENES, STAGES AND CLOSE WINDOWS;

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

    //This function takes the Stage that you wanna close as a parameter
    public void closeStage(Stage stage){
        stage.close();
    }


//this function creates and load the login screen.
    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        createStage(loader);
    }

//this function loads the User initial screen.
    public void showUserWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/User.fxml"));
        UserController userController = new UserController();
        loader.setController(userController);
        createStage(loader);
    }

//this function loads the Estoque section screen
    public void showEstoqueWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Estoque.fxml"));
        EstoqueController estoqueController = new EstoqueController();
        loader.setController(estoqueController);
        createStage(loader);
    }

//this function loads the EditarLoja section screen
    public void showEditarLojaWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/EditarLoja.fxml"));
        EditarLojaController editarLojaController = new EditarLojaController();
        loader.setController(editarLojaController);
        createStage(loader);
    }

//this function loads the Inicio section screen
    public void showInicioWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/inicio.fxml"));
        InicioController inicioController = new InicioController();
        loader.setController(inicioController);
        createStage(loader);
    }



}
