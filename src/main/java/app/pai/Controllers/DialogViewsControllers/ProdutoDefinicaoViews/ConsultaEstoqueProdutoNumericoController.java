package app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews;

import app.pai.models.Model;
import app.pai.models.ModelEstoque;
import app.pai.models.ModelProduto;
import app.pai.models.ModelProdutoDefinicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ConsultaEstoqueProdutoNumericoController implements Initializable {

    @FXML
    private Label nomeProduto;
    @FXML
    private Label t34;
    @FXML
    private Label t36;
    @FXML
    private Label t38;
    @FXML
    private Label t40;
    @FXML
    private Label t42;
    @FXML
    private Label t44;
    @FXML
    private Label t46;
    @FXML
    private Label t48;
    @FXML
    private Label t50;
    @FXML
    private Label t52;
    @FXML
    private Label totalUnidades;
    @FXML
    private Button voltarBtn;


    static private ModelProdutoDefinicao receiver = new ModelProdutoDefinicao();


    public static void setReceiver(ModelProdutoDefinicao produtoData) {
        ConsultaEstoqueProdutoNumericoController.receiver = produtoData;
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

    private void produtoDataInitializer(ModelProdutoDefinicao produto) {
        nomeProduto.setText(produto.getNomeProduto());
        ObservableList<ModelProduto> listaAuxiliar = getAllUnidadesProdutoSolicitado(receiver);
        int t34Count = 0;
        int t36Count = 0;
        int t38Count = 0;
        int t40Count = 0;
        int t42Count = 0;
        int t44Count = 0;
        int t46Count = 0;
        int t48Count = 0;
        int t50Count = 0;
        int t52Count = 0;

        for (int i = 0; i < listaAuxiliar.size(); i++) {
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "34")) {
                t34Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "36")) {
                t36Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "38")) {
                t38Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "40")) {
                t40Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "42")) {
                t42Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "44")) {
                t44Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "46")) {
                t46Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "48")) {
                t48Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "50")) {
                t50Count++;
            }
            if (Objects.equals(listaAuxiliar.get(i).getTamanho(), "52")) {
                t52Count++;
            }
        }
        t34.setText(String.valueOf(t34Count));
        t36.setText(String.valueOf(t36Count));
        t38.setText(String.valueOf(t38Count));
        t40.setText(String.valueOf(t40Count));
        t42.setText(String.valueOf(t42Count));
        t44.setText(String.valueOf(t44Count));
        t46.setText(String.valueOf(t46Count));
        t48.setText(String.valueOf(t48Count));
        t50.setText(String.valueOf(t50Count));
        t52.setText(String.valueOf(t52Count));
        totalUnidades.setText(String.valueOf(listaAuxiliar.size()));
    }


    public ObservableList<ModelProduto> getAllUnidadesProdutoSolicitado (ModelProdutoDefinicao produto){
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