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

public class DetalheProdutoController implements Initializable {

    @FXML
    private Label categoria;
    @FXML
    private Label genero;
    @FXML
    private Label medidas;
    @FXML
    private Label nomeProduto;
    @FXML
    private Label precoCusto;
    @FXML
    private Label precoVenda;
    @FXML
    private Label publicoAlvo;
    @FXML
    private Label unidadesVendidas;
    @FXML
    private Button voltarBtn;

    static private ModelProdutoDefinicao receiver = new ModelProdutoDefinicao();
    public static void setReceiver(ModelProdutoDefinicao receiver) {
        DetalheProdutoController.receiver = receiver;
    }

    @FXML
    void voltarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) voltarBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
