package app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews;

import app.pai.models.*;
import app.pai.models.Utils.ModelTamanhoProdutos;
import app.pai.models.Utils.ModelURL;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CriarProdutoDefinicaoController implements Initializable {

    @FXML
    private TextField nomeProduto;
    @FXML
    private TextField precoCusto;
    @FXML
    private TextField precoVenda;
    @FXML
    private ChoiceBox<StringProperty> categoriaChoiceBox;
    @FXML
    private ChoiceBox<StringProperty> generoChoiceBox;
    @FXML
    private ChoiceBox<StringProperty> publicoAlvoChoiceBox;
    @FXML
    private ChoiceBox<StringProperty> tamanhosChoiceBox;
    @FXML
    private Button cancelarBtn;
    @FXML
    private Button criarBtn;


    ModelURL modelURL = new ModelURL();
    ModelTamanhoProdutos modelTamanhoProdutos = new ModelTamanhoProdutos();
    ModelCategoria modelCategoria = new ModelCategoria();
    ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
    ModelGenero modelGenero = new ModelGenero();


    @FXML
    void criarBtnOnClick() {
        ModelProdutoDefinicao novoProdutoDefinicao = new ModelProdutoDefinicao(nomeProduto.getText(), categoriaChoiceBox.getValue().getValue(), generoChoiceBox.getValue().getValue(), publicoAlvoChoiceBox.getValue().getValue(), tamanhosChoiceBox.getValue().getValue(), Float.parseFloat(precoCusto.getText()), Float.parseFloat(precoVenda.getText()));
        ModelProdutoDefinicao.createNewDefinicaoProdutoInstance(novoProdutoDefinicao);
        System.out.println(ModelProdutoDefinicao.getListaProdutoDefinicao());
    }


    @FXML
    void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) cancelarBtn.getScene().getWindow();
        stage.close();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("olá");
        tamanhosChoiceBox.getItems().addAll(modelTamanhoProdutos.getListaTamanhos());
        categoriaChoiceBox.getItems().addAll(ModelCategoria.getListaCategoria());
        System.out.println(ModelCategoria.getListaCategoria());
        publicoAlvoChoiceBox.getItems().addAll(ModelPublicoAlvo.getListaPublicoAlvo());
        generoChoiceBox.getItems().addAll(ModelGenero.getListaGenero());
        System.out.println("olá fim");
    }
}
