package app.pai.Controllers.ComponentsControllers;

import app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews.ConsultaEstoqueProdutoController;
import app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews.DetalheProdutoController;
import app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews.EditarProdutoDefinicaoController;
import app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews.ExcluirProdutoDefinicaoController;
import app.pai.models.Model;
import app.pai.models.ModelProdutoDefinicao;
import app.pai.models.Utils.ModelURL;
import javafx.fxml.FXML;
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
    ModelProdutoDefinicao produtoData = new ModelProdutoDefinicao();

    public void setProdutoDefinicaoInfoIntoContainer(ModelProdutoDefinicao produtoDefinicao) {
        System.out.println("cheguei no setProduto Definicao");
        produtoData = produtoDefinicao;
        produtoTextfield.setText(produtoDefinicao.getNomeProduto());
        precoCusto.setText(String.valueOf(produtoDefinicao.getPrecoCusto()));
        precoVenda.setText(String.valueOf(produtoDefinicao.getPrecoVenda()));
    }

    //parei criando esse receiver de sono, só criar uma instancia de produto definição, preencher e passar setar ela no receiver de ExcluirProdutoDefinicao



    @FXML
    void deleteBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        ExcluirProdutoDefinicaoController.setReceiver(produtoData);
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getExcluirProdutoFXML());
    }

    @FXML
    void editarBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        EditarProdutoDefinicaoController.setReceiver(produtoData);
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getEditarProdutoFXML());
    }


    public void consultarEstoqueBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        ConsultaEstoqueProdutoController.setReceiver(produtoData);
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getConsultaEstoqueProdutoFXML());
    }

    public void detalheProdutoBtnOnClick() throws IOException {
        Model.getInstance().getViewFactory().getFogPaneController().ableFogPane();
        DetalheProdutoController.setReceiver(produtoData);
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getDetalheProdutoFXML());
    }
}
