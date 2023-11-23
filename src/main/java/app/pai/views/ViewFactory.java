package app.pai.views;

import app.pai.Controllers.UserController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory  {

    /*Essa StringProperty funciona como uma bandeira na construção do Menu:
        Ela é uma constante, então seu conteudo não pode ser modificado. A mesma
        inicia com o valor de String: "".
        Para funcionar, o Controller do Menu altera a propriedade através do método set.
        O valor de menuSelected é lido pelo UserController, que aplica um switch para
        alterar a scene exibida;

     */
    private final StringProperty menuSelected;
    private AnchorPane inicioView;
    private AnchorPane estoqueView;
    private AnchorPane vendasView;
    private AnchorPane relatoriosView;
    private AnchorPane editarLojaView;
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



    // SESSÃO DE FUNÇÕES QUE CARREGAM AS VIEWS DAS PAGINAS A SEREM CARREGADAS PELO USERCONTROLLER.
        public AnchorPane getInicioView(){
            if (inicioView == null) {
                try {
                    inicioView = new FXMLLoader(getClass().getResource("/FXML/Inicio.fxml")).load();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return inicioView;
        }

        public AnchorPane getVendasView() {
            if (vendasView == null) {
                try {
                    vendasView = new FXMLLoader(getClass().getResource("/FXML/Vendas.fxml")).load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return vendasView;
        }


        public AnchorPane getEstoqueView(){
            if (estoqueView == null) {
                try {
                    estoqueView = new FXMLLoader(getClass().getResource("/FXML/Estoque.fxml")).load();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return estoqueView;
        }

        public AnchorPane getRelatoriosView() {
            if (relatoriosView == null){
                try {
                    relatoriosView = new FXMLLoader(getClass().getResource("/FXML/Relatorios.fxml")).load();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return relatoriosView;
        }

        public AnchorPane getEditarLojaView() {
            if (editarLojaView == null) {
                try {
                    editarLojaView = new FXMLLoader(getClass().getResource("/FXML/EditarLoja.fxml")).load();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return editarLojaView;
        }

}
