package app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews;

import app.pai.models.Model;
import app.pai.models.ModelProdutoDefinicao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ExcluirProdutoDefinicaoController implements Initializable {

    @FXML
    private Label nomeProduto;
    @FXML
    private Label categoria;
    @FXML
    private Label genero;
    @FXML
    private Label publicoAlvo;
    @FXML
    private Label precoCusto;
    @FXML
    private Label precoVenda;
    @FXML
    private Label labelMessage;
    @FXML
    private Button excluirBtn;
    @FXML
    private Button cancelarBtn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InstanceViewInitializer();
    }



    static private ModelProdutoDefinicao receiver = new ModelProdutoDefinicao();

    public static void setReceiver(ModelProdutoDefinicao receiver) {
        ExcluirProdutoDefinicaoController.receiver = receiver;
    }


    @FXML
    void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) cancelarBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void excluirBtnOnClick() {
        ModelProdutoDefinicao.removeDefinicaoProdutoInstance(receiver);
        cancelarBtnOnClick();
    }


    private void InstanceViewInitializer() {
        nomeProduto.setText(receiver.getNomeProduto());
        categoria.setText(receiver.getCategoria());
        genero.setText(receiver.getGenero());
        publicoAlvo.setText(receiver.getPublicoAlvo());
        precoCusto.setText(String.valueOf(receiver.getPrecoCusto()));
        precoVenda.setText(String.valueOf(receiver.getPrecoVenda()));
    }

}
