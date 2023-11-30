package app.pai.views;

import app.pai.Controllers.ComponentsControllers.CategoryInstanceController;
import app.pai.Controllers.ComponentsControllers.PublicoAlvoInstanceController;
import app.pai.Controllers.UserController;
import app.pai.models.Model;
import app.pai.models.ModelCategoria;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewFactory  {

    /*Essa StringProperty funciona como uma bandeira na construção do Menu:
        Ela é uma constante, então seu conteudo não pode ser modificado. A mesma
        inicia com o valor de String: "".
        Para funcionar, o Controller do Menu altera a propriedade através do método set.
        O valor de menuSelected é lido pelo UserController, que aplica um switch para
        alterar a scene exibida;

     */
    private AnchorPane inicioView;
    private AnchorPane estoqueView;
    private AnchorPane vendasView;
    private AnchorPane relatoriosView;
    private AnchorPane editarLojaView;
    private final StringProperty menuSelected;
    public ViewFactory(){
        this.menuSelected = new SimpleStringProperty("");
    }


    //Função que informa qual botão do menu está sendo acionado;
    public StringProperty menuSelectedProperty() {
        return menuSelected;
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



    // SESSÃO DE FUNÇÕES QUE CARREGAM AS VIEWS DAS PAGINAS A SEREM CARREGADAS PELO USERCONTROLLER.
    public AnchorPane getInicioView(){
            if (inicioView == null) {
                try {
                    inicioView = new FXMLLoader(getClass().getResource("/Fxml/FXMLSections/Inicio.fxml")).load();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return inicioView;
        }
    public AnchorPane getVendasView() {
            if (vendasView == null) {
                try {
                    vendasView = new FXMLLoader(getClass().getResource("/Fxml/FXMLSections/Vendas.fxml")).load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return vendasView;
        }
    public AnchorPane getEstoqueView(){
            if (estoqueView == null) {
                try {
                    estoqueView = new FXMLLoader(getClass().getResource("/Fxml/FXMLSections/Estoque.fxml")).load();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return estoqueView;
        }
    public AnchorPane getRelatoriosView() {
            if (relatoriosView == null){
                try {
                    relatoriosView = new FXMLLoader(getClass().getResource("/Fxml/FXMLSections/Relatorios.fxml")).load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return relatoriosView;
        }
    public AnchorPane getEditarLojaView() {
            if (editarLojaView == null) {
                try {
                    editarLojaView = new FXMLLoader(getClass().getResource("/Fxml/FXMLSections/EditarLoja.fxml")).load();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return editarLojaView;
        }




        //                      FUNÇÕES DA PAGINA EDITARLOJA
        /*
        Adiciona a tela o FXMLLoader de uma instancia da classe ModelCategoria.
        Deve receber como parametro o arquivo fxml que será utilizado e um objeto modelCategoria a ser adicionado;
        */

    public void addCategoriaView(URL resource, ModelCategoria modelCategoria, VBox categoriasContainer) throws IOException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(resource);
        AnchorPane anchorPane = loader.load();
        CategoryInstanceController categoryInstanceController = loader.getController();
        categoryInstanceController.setCategoryInfoIntoContainer(modelCategoria);
        categoriasContainer.getChildren().add(anchorPane);
    }
    public void categorysViewInitializer(URL resource, VBox categoriaContainer) {

        try {
            for (ModelCategoria modelCategoria : ModelCategoria.getListaModelCategorias()) {
                Model.getInstance().getViewFactory().addCategoriaView(resource, modelCategoria, categoriaContainer);

            }
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void addPublicoAlvoView(URL resource, StringProperty modelPublicoAlvo, VBox publicoAlvoContainer) throws IOException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(resource);
        AnchorPane anchorPane = loader.load();
        PublicoAlvoInstanceController publicoAlvoInstanceController = loader.getController();
        publicoAlvoInstanceController.setPublicoAlvoInfoIntoContainer(modelPublicoAlvo);
        publicoAlvoContainer.getChildren().add(anchorPane);
    }
    public void publicoAlvoViewInitializer(URL resource, VBox publicoAlvoContainer) {

        try {
            for (StringProperty nomePublicoAlvo : ModelPublicoAlvo.getListaModelPublicoAlvo()) {
                Model.getInstance().getViewFactory().addPublicoAlvoView(resource, nomePublicoAlvo, publicoAlvoContainer);
            }
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}



