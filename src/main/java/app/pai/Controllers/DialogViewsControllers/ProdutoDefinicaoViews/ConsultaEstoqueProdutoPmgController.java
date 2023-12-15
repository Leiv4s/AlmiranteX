package app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews;

import app.pai.models.Model;
import app.pai.models.ModelEstoque;
import app.pai.models.ModelProduto;
import app.pai.models.ModelProdutoDefinicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ConsultaEstoqueProdutoPmgController implements Initializable {

    @FXML
    private Label nomeProduto;
    @FXML
    private Label gg;
    @FXML
    private Label g;
    @FXML
    private Label m;
    @FXML
    private Label p;
    @FXML
    private Label pp;
    @FXML
    private Label totalUnidades;
    @FXML
    private Button voltarBtn;

    static private ModelProdutoDefinicao receiver = new ModelProdutoDefinicao();

    public static void setReceiver(ModelProdutoDefinicao receiver) {
        ConsultaEstoqueProdutoPmgController.receiver = receiver;
    }

    @FXML
    void voltarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) voltarBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        produtoDataInitializer(receiver);
    }

    public void produtoDataInitializer(ModelProdutoDefinicao produto) {
        nomeProduto.setText(produto.getNomeProduto());
        ObservableList<ModelProduto> listaAuxiliar = getAllUnidadesProdutoSolicitado(receiver);
        int ppCount = 0;
        int pCount = 0;
        int mCount = 0;
        int gCount = 0;
        int ggCount = 0;
        for (int i = 0; i < listaAuxiliar.size(); i++) {
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "PP")) {
                ppCount++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "P")) {
                pCount++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "M")) {
                mCount++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "G")) {
                gCount++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "GG")) {
                ggCount++;
            }
        }
        pp.setText(String.valueOf(pCount));
        p.setText(String.valueOf(ppCount));
        m.setText(String.valueOf(mCount));
        g.setText(String.valueOf(gCount));
        gg.setText(String.valueOf(ggCount));
        totalUnidades.setText(String.valueOf(listaAuxiliar.size()));
    }

    public ObservableList<ModelProduto> getAllUnidadesProdutoSolicitado(ModelProdutoDefinicao produto) {
        ObservableList<ModelProduto> listaEstoque = ModelEstoque.getListaEstoqueProdutos();
        ObservableList<ModelProduto> listaAuxiliar = FXCollections.observableArrayList();
        for (ModelProduto modelProduto : listaEstoque) {
            if (Objects.equals(modelProduto.getProdutoDefinicao().getNomeProduto(), produto.getNomeProduto())) {
                listaAuxiliar.addAll(modelProduto);
            }
        }
        return listaAuxiliar;
    }
}
