package app.pai.Controllers;

import app.pai.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML BorderPane userPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*Este bloco de código adiciona um Ouvidor para o atributo "menuSelected",
        da classe ViewFactory, alterando, de acordo com o valor da supracitada
        propriedade, a Screen que será lançada ao centro do userPane.
         */
        Model.getInstance().getViewFactory().menuSelectedProperty().addListener((observableValue, oldValue, newValue) -> {
            switch (newValue) {
                case "Estoque" -> userPane.setCenter(Model.getInstance().getViewFactory().getEstoqueView());
                case "Vendas" -> userPane.setCenter(Model.getInstance().getViewFactory().getVendasView());
                case "Relatorios" -> userPane.setCenter(Model.getInstance().getViewFactory().getRelatoriosView());
                case "EditarLoja" -> userPane.setCenter(Model.getInstance().getViewFactory().getEditarLojaView());
                default -> userPane.setCenter(Model.getInstance().getViewFactory().getInicioView());
            }
        } );
    }
}
