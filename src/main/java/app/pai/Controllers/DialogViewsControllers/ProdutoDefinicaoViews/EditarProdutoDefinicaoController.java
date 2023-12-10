package app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews;

import app.pai.models.*;
import app.pai.models.Utils.ModelTamanhoProdutos;
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

public class EditarProdutoDefinicaoController implements Initializable {

    @FXML
    private Button cancelarBtn;
    @FXML
    private ChoiceBox<String> categoriaChoiceBox;
    @FXML
    private Button criarBtn;
    @FXML
    private ChoiceBox<String> generoChoiceBox;
    @FXML
    private TextField nomeProduto;
    @FXML
    private TextField precoCusto;
    @FXML
    private TextField precoVenda;
    @FXML
    private ChoiceBox<String> publicoAlvoChoiceBox;
    @FXML
    private ChoiceBox<String> tamanhosChoiceBox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InstanceViewInitializer();
    }


    static private ModelProdutoDefinicao receiver = new ModelProdutoDefinicao();

    public static void setReceiver(ModelProdutoDefinicao receiver) {
        EditarProdutoDefinicaoController.receiver = receiver;
    }


    @FXML
    void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage)criarBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void editarBtnOnClick() {
        ModelProdutoDefinicao updatedProduto = new ModelProdutoDefinicao(
               nomeProduto.getText(),
                categoriaChoiceBox.getValue(),
                generoChoiceBox.getValue(),
                publicoAlvoChoiceBox.getValue(),
                tamanhosChoiceBox.getValue(),
                Float.parseFloat(precoCusto.getText()),
                Float.parseFloat(precoVenda.getText()));

        ModelProdutoDefinicao.updateDefinicaoProdutoInstance(receiver,updatedProduto);
        cancelarBtnOnClick();
    }

    private void InstanceViewInitializer() {
        ModelTamanhoProdutos modelTamanhoProdutos = new ModelTamanhoProdutos();
        nomeProduto.setText(receiver.getNomeProduto());
        precoCusto.setText(String.valueOf(receiver.getPrecoCusto()));
        precoVenda.setText(String.valueOf(receiver.getPrecoVenda()));
        choiceBoxLoaders(modelTamanhoProdutos);
    }

    private void choiceBoxLoaders(ModelTamanhoProdutos modelTamanhoProdutos) {
        for (StringProperty string : ModelCategoria.getListaCategoria()) {
            categoriaChoiceBox.getItems().add(string.get());
        }
        categoriaChoiceBox.setValue(receiver.getCategoria());

        for (StringProperty string : ModelGenero.getListaGenero()) {
            generoChoiceBox.getItems().add(string.get());
        }
        generoChoiceBox.setValue(receiver.getGenero());
        for (StringProperty string : ModelPublicoAlvo.getListaPublicoAlvo()) {
            publicoAlvoChoiceBox.getItems().add(string.get());
        }
        publicoAlvoChoiceBox.setValue(receiver.getPublicoAlvo());
        for (StringProperty string : modelTamanhoProdutos.getListaTamanhos()) {
            tamanhosChoiceBox.getItems().add(string.get());
        }
        tamanhosChoiceBox.setValue(receiver.getTipoTamanho());
    }

}
