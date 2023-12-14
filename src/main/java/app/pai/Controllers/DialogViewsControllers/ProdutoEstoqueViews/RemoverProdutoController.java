package app.pai.Controllers.DialogViewsControllers.ProdutoEstoqueViews;

import app.pai.models.Model;
import app.pai.models.ModelEstoque;
import app.pai.models.ModelProduto;
import app.pai.models.ModelProdutoDefinicao;
import app.pai.models.Utils.ModelURL;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RemoverProdutoController implements Initializable {

    @FXML
    private Button cancelarBtn;
    @FXML
    private HBox definirTamanhoContainer;
    @FXML
    private ChoiceBox<ModelProdutoDefinicao> produtoDefinicaoChoiceBox;
    @FXML
    private Button removerBtn;

    private ModelProdutoDefinicao produtoDefinicaoReceiver = new ModelProdutoDefinicao();
    private ModelURL modelURL = new ModelURL();
    private ModelEstoque modelEstoque = new ModelEstoque();
    private FXMLLoader loaderTamanho = null;

    // receivers de tamanhoNumeracao
    int t34 = 0;
    int t36 = 0;
    int t38 = 0;
    int t40 = 0;
    int t42 = 0;
    int t44 = 0;
    int t46 = 0;
    int t48 = 0;
    int t50 = 0;
    int t52 = 0;
    // receivers de tamanhoPMG
    int pp = 0;
    int p = 0;
    int m = 0;
    int g = 0;
    int gg = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        produtoDefinicaoChoiceBox.getItems().setAll(ModelProdutoDefinicao.getListaProdutoDefinicao());
        produtoDefinicaoChoiceBox.setOnAction(this::showTamanhosWindow);
    }


    @FXML
    void removerBtnOnClick() {
        if (Objects.equals(produtoDefinicaoReceiver.getTipoTamanho(), "P-M-G")) {
            System.out.println("é pmg\n");
            getInfoFromPMGWindow();
            removeProdutoPMG(pp, p, m, g, gg);
        } else {
            getInfoFromNumericoWindow();
            System.out.println("é numerico");
            removerUnidadesNumeracao(t34, t36, t38, t40, t42, t44, t46, t48, t50, t52);
        }
    }

    @FXML
    void cancelarBtnOnClick() {
        Model.getInstance().getViewFactory().getFogPaneController().disableFogPane();
        Stage stage = (Stage) cancelarBtn.getScene().getWindow();
        stage.close();
    }

    public void getInfoFromPMGWindow() {
        PmgWindowController controller = loaderTamanho.getController();
        pp = controller.getPp();
        p = controller.getP();
        m = controller.getM();
        g = controller.getG();
        gg = controller.getGg();
        System.out.println(ModelEstoque.getListaEstoqueProdutos().toString()+"\n");
    }

    private void   removeProdutoPMG(int pp, int p, int m, int g, int gg) {
        StringProperty stringProperty = new SimpleStringProperty();

            for (int i = 0; i < pp; i++) {
            stringProperty.set("PP");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < p; i++) {
            stringProperty.set("P");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < m; i++) {
            stringProperty.set("M");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < g; i++) {
            stringProperty.set("G");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < gg; i++) {
            stringProperty.set("GG");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < ModelEstoque.getListaEstoqueProdutos().size(); i++) {
            System.out.println(ModelEstoque.getListaEstoqueProdutos().get(i).getTamanho());
        }
    }

    public void getInfoFromNumericoWindow() {
        NumeracaoController controller = loaderTamanho.getController();
        t34 = controller.getT34();
        t36 = controller.getT36();
        t38 = controller.getT38();
        t40 = controller.getT40();
        t42 = controller.getT42();
        t44 = controller.getT44();
        t46 = controller.getT46();
        t48 = controller.getT48();
        t50 = controller.getT50();
        t52 = controller.getT52();
        System.out.println(ModelEstoque.getListaEstoqueProdutos().toString());
    }

    private void removerUnidadesNumeracao(int t34, int t36, int t38, int t40, int t42, int t44, int t46, int t48, int t50, int t52) {
        StringProperty stringProperty = new SimpleStringProperty();
        for (int i = 0; i < t34; i++) {
            stringProperty.set("34");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t36; i++) {
            stringProperty.set("36");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t38; i++) {
            stringProperty.set("38");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t40; i++) {
            stringProperty.set("40");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t42; i++) {
            stringProperty.set("42");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t44; i++) {
            stringProperty.set("44");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t46; i++) {
            stringProperty.set("46");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t48; i++) {
            stringProperty.set("48");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t50; i++) {
            stringProperty.set("50");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
        for (int i = 0; i < t52; i++) {
            stringProperty.set("52");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.removerProduto(produto);
        }
    }


    private void showTamanhosWindow(ActionEvent event) {
        definirTamanhoContainer.getChildren().clear();
        produtoDefinicaoReceiver = produtoDefinicaoChoiceBox.getValue();
        if (Objects.equals(produtoDefinicaoReceiver.getTipoTamanho(), "P-M-G")) {
            loadTamanhoWindow(modelURL.getCampoPmgTamanhoFXML());
        } else {
            loadTamanhoWindow(modelURL.getCampoNumeracaoTamanhoFXML());
        }
        System.out.println(definirTamanhoContainer.getChildren().get(0));
    }

    public void loadTamanhoWindow(URL source) {
        try {
            loaderTamanho = Model.getInstance().getViewFactory().loadTamanhosTextfieldView(source, definirTamanhoContainer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
