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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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


    // quando eu voltar da janta, criar essa parte do código:
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


    @FXML
    void adicionarBtnOnClick() {
        if (Objects.equals(produtoDefinicaoReceiver.getTipoTamanho(), "P-M-G")) {
            getInfoFromPMGWindow();
            adicionarProdutoPMG();
        } else {
            getInfoFromNumericoWindow();
            adicionarProdutoNumerico();
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
    }

    private void adicionarProdutoPMG() {

        for (int i = 0; i < pp; i++) {
            StringProperty stringProperty = new SimpleStringProperty();
            System.out.println("pp =" + pp);
            stringProperty.set("PP");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
            System.out.println(ModelEstoque.getListaEstoqueProdutos().size());

        }
        for (int i = 0; i < p; i++) {
            StringProperty stringProperty = new SimpleStringProperty();
            System.out.println("p =" + p);
            stringProperty.set("P");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
            System.out.println(ModelEstoque.getListaEstoqueProdutos().size());
        }
        for (int i = 0; i < m; i++) {
            StringProperty stringProperty = new SimpleStringProperty();
            System.out.println("m =" + m);
            stringProperty.set("M");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
            System.out.println(ModelEstoque.getListaEstoqueProdutos().size());
        }
        for (int i = 0; i < g; i++) {
            StringProperty stringProperty = new SimpleStringProperty();
            System.out.println("g =" + g);
            stringProperty.set("G");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
            System.out.println(ModelEstoque.getListaEstoqueProdutos().size());
        }
        for (int i = 0; i < gg; i++) {
            StringProperty stringProperty = new SimpleStringProperty();
            System.out.println("gg =" + gg);
            stringProperty.set("GG");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
            System.out.println(ModelEstoque.getListaEstoqueProdutos().size());
        }

        for (int i = 0; i<ModelEstoque.getListaEstoqueProdutos().size();i++){
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

    private void adicionarProdutoNumerico() {
        StringProperty stringProperty = new SimpleStringProperty();
        for (int i = 0; i < t34; i++) {
            stringProperty.set("34");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t36; i++) {
            stringProperty.set("36");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t38; i++) {
            stringProperty.set("38");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t40; i++) {
            stringProperty.set("40");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t42; i++) {
            stringProperty.set("42");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t44; i++) {
            stringProperty.set("44");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t46; i++) {
            stringProperty.set("46");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t48; i++) {
            stringProperty.set("48");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t50; i++) {
            stringProperty.set("50");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
        for (int i = 0; i < t52; i++) {
            stringProperty.set("52");
            ModelProduto produto = new ModelProduto(produtoDefinicaoReceiver, stringProperty);
            ModelEstoque.adicionarProduto(produto);
        }
    }
}
