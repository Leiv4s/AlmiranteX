package app.pai.Controllers.DialogViewsControllers.ProdutoEstoqueViews;

import app.pai.models.Model;
import app.pai.models.ModelProdutoDefinicao;
import app.pai.models.Utils.ModelURL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdicionarProdutoController implements Initializable {

    @FXML
    private Button adicionarBtn;
    @FXML
    private Button cancelarBtn;
    @FXML
    private HBox definirTamanhoContainer;
    @FXML
    private ChoiceBox<ModelProdutoDefinicao> produtoDefinicaoChoiceBox;
    private ModelURL modelURL = new ModelURL();

    private ModelProdutoDefinicao produtoDefinicaoReceiver = new ModelProdutoDefinicao();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        produtoDefinicaoChoiceBox.getItems().setAll(ModelProdutoDefinicao.getListaProdutoDefinicao());
        produtoDefinicaoChoiceBox.setOnAction(this::showType);
        try {
            loadTamanhoWindow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private void showType(ActionEvent event) {
        System.out.println(produtoDefinicaoChoiceBox.getValue());
        System.out.println(produtoDefinicaoReceiver);
    }

    @FXML
    void adicionarBtnOnClick() {

    }

    @FXML
    void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) cancelarBtn.getScene().getWindow();
        stage.close();
    }

    public void loadTamanhoWindow() throws IOException {
        produtoDefinicaoReceiver = produtoDefinicaoChoiceBox.getValue();
        Model.getInstance().getViewFactory().loadTamanhosTextfieldView(modelURL.getCampoNumeracaoTamanhoFXML(), definirTamanhoContainer);
    }

}
