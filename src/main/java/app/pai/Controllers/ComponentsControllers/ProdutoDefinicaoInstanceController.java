package app.pai.Controllers.ComponentsControllers;

import app.pai.models.ModelProdutoDefinicao;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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



    public void setProdutoDefinicaoInfoIntoContainer(ModelProdutoDefinicao produtoDefinicao) {
        produtoTextfield.setText(produtoDefinicao.getNomeProduto());
        tipoTamanho.setText(produtoDefinicao.getTipoTamanho());
        categoria.setText(produtoDefinicao.getCategoria());
        publicoAlvo.setText(produtoDefinicao.getPublicoAlvo());
        genero.setText(produtoDefinicao.getGenero());
        precoCusto.setText(String.valueOf(produtoDefinicao.getPrecoCusto()));
        precoVenda.setText(String.valueOf(produtoDefinicao.getPrecoVenda()));
    }


    @FXML
    void deleteBtnOnClick() {

    }

    @FXML
    void editarBtnOnClick() {

    }


}
