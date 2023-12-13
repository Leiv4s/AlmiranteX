package app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews;

import app.pai.models.Model;
import app.pai.models.ModelProdutoDefinicao;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
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

    public void produtoDataInitializer(ModelProdutoDefinicao produto){
           nomeProduto.setText(produto.getNomeProduto());
//         gg.setText(produto.getTamanho());
//         g.setText();
//         m.setText();
//         p.setText();
//         pp.setText();
//         totalUnidades.setText();
    }
}
