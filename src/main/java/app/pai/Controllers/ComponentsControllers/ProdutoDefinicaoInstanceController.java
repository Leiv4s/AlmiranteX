package app.pai.Controllers.ComponentsControllers;

import app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews.EditarProdutoDefinicaoController;
import app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews.ExcluirProdutoDefinicaoController;
import app.pai.models.Model;
import app.pai.models.ModelProdutoDefinicao;
import app.pai.models.Utils.ModelURL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;


public class ProdutoDefinicaoInstanceController {

    @FXML
    private Label produtoTextfield;
    @FXML
    private Label tipoTamanho;
    @FXML
    private Label categoria;
    @FXML
    private Label publicoAlvo;
    @FXML
    private Label genero;
    @FXML
    private Label precoCusto;
    @FXML
    private Label precoVenda;
    @FXML
    private Button publicDeleteBtn;
    @FXML
    private Button publicEditarBtn;

    ModelURL modelURL = new ModelURL();


    public void setProdutoDefinicaoInfoIntoContainer(ModelProdutoDefinicao produtoDefinicao) {
        produtoTextfield.setText(produtoDefinicao.getNomeProduto());
        tipoTamanho.setText(produtoDefinicao.getTipoTamanho());
        categoria.setText(produtoDefinicao.getCategoria());
        publicoAlvo.setText(produtoDefinicao.getPublicoAlvo());
        genero.setText(produtoDefinicao.getGenero());
        precoCusto.setText(String.valueOf(produtoDefinicao.getPrecoCusto()));
        precoVenda.setText(String.valueOf(produtoDefinicao.getPrecoVenda()));
    }

    //parei criando esse receiver de sono, só criar uma instancia de produto definição, preencher e passar setar ela no receiver de ExcluirProdutoDefinicao
    public void setReceiver() {



    }


    @FXML
    void deleteBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();

        ExcluirProdutoDefinicaoController.setReceiver(
                new ModelProdutoDefinicao(
                        produtoTextfield.getText(),
                        categoria.getText(),
                        genero.getText(),
                        publicoAlvo.getText(),
                        tipoTamanho.getText(),
                        Float.parseFloat(precoCusto.getText()),
                        Float.parseFloat(precoVenda.getText())
                )
        );
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getExcluirProdutoFXML());


    }

    @FXML
    void editarBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        EditarProdutoDefinicaoController.setReceiver(
                new ModelProdutoDefinicao(
                        produtoTextfield.getText(),
                        categoria.getText(),
                        genero.getText(),
                        publicoAlvo.getText(),
                        tipoTamanho.getText(),
                        Float.parseFloat(precoCusto.getText()),
                        Float.parseFloat(precoVenda.getText())
                )
        );
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getEditarProdutoFXML());
    }


}
