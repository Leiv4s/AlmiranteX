package app.pai.Controllers.ComponentsControllers;

import app.pai.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    Button inicioBtn;
    @FXML
    Button vendasBtn;
    @FXML
    Button estoqueBtn;
    @FXML
    Button relatoriosBtn;
    @FXML
    Button editarLojaBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }


    /* função responsável por gerar a iteratividade dos botões do menu,
    chamando as funções que irão alterar a flag "menuSelected", criada no viewFactory,
    para sinalizar para o UserController, através da instancia do ViewFactory,
    qual botão do menu está sendo ativado.*/
    public void addListeners(){
        inicioBtn.setOnAction(event -> onInicio());
        vendasBtn.setOnAction(event -> onVendas());
        estoqueBtn.setOnAction(event -> onEstoque());
        relatoriosBtn.setOnAction(event -> onRelatorios());
        editarLojaBtn.setOnAction(event -> onEditarLoja());
    }


// SESSÃO DO CÓDIGO QUE ALTERA A FLAG "menuSelected", na instancia da classe ViewFactory
    public void onInicio(){
        Model.getInstance().getViewFactory().menuSelectedProperty().set("Inicio");
    }

    public void onVendas(){
        Model.getInstance().getViewFactory().menuSelectedProperty().set("Vendas");
    }
    public void onEstoque(){
        Model.getInstance().getViewFactory().menuSelectedProperty().set("Estoque");
    }

    public void onRelatorios(){
        Model.getInstance().getViewFactory().menuSelectedProperty().set("Relatorios");

    }

    public void onEditarLoja(){
        Model.getInstance().getViewFactory().menuSelectedProperty().set("EditarLoja");
    }
}
