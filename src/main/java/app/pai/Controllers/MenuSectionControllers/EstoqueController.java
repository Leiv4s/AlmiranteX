package app.pai.Controllers.MenuSectionControllers;


import app.pai.Controllers.PersistanceController;
import app.pai.models.*;
import app.pai.models.Utils.ModelURL;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static app.pai.models.Model.getInstance;


public class EstoqueController implements Initializable {


    @FXML
    private TextField pesquisarTextfield;
    @FXML
    private Button limparFiltrosBtn;
    @FXML
    private ChoiceBox<?> categoriaChoiceBox;
    @FXML
    private ChoiceBox<?> generoChoiceBox;
    @FXML
    private ChoiceBox<?> produtoChoiceBox;
    @FXML
    private ChoiceBox<?> publicoAlvoChoiceBox;
    @FXML
    private VBox produtoDefinicaoContainer;
    @FXML
    private Button adicionarProdutoBtn;
    @FXML
    private Button removerProdutoBtn;
    @FXML
    private Button criarProdutoBtn;


    //controllers declarations

    private ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
    private ModelGenero modelGenero = new ModelGenero();
    private ModelCategoria modelCategoria = new ModelCategoria();
    private ModelProdutoDefinicao modelProdutoDefinicao = new ModelProdutoDefinicao();
    private ModelURL modelURL = new ModelURL();

    private static ObservableList<ModelProdutoDefinicao> listaProdutoObservable = ModelProdutoDefinicao.getListaProdutoDefinicao();
    private ListChangeListener<ModelProdutoDefinicao> listenerProdutoDefinicao = c -> {
        System.out.println("percebi publico");
        try {
            produtoDefinicaoContainer.getChildren().clear();
            getInstance().getViewFactory().produtoDefinicaoViewInitializer(modelURL.getProdutoInstanceFXML(), produtoDefinicaoContainer);
        } catch (Exception e) {
        }

        // serialização abaixo:
        PersistanceController persistanceController = new PersistanceController();
        if (listaProdutoObservable != null){
            try {
                persistanceController.serializeProdutoDefinicao(listaProdutoObservable);
                System.out.println("serializei");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };

    private void initializeProdutoDefinicaoLoadedInstances(ObservableList<ModelProdutoDefinicao> ObservableList, ListChangeListener<ModelProdutoDefinicao> listener) {
        PersistanceController persistanceController = new PersistanceController();
        ObservableList.addListener(listener);
        try {
            ModelProdutoDefinicao.setListaProdutoDefinicao (persistanceController.desserializeProdutoDefinicao());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeProdutoDefinicaoLoadedInstances(listaProdutoObservable,listenerProdutoDefinicao);
    }




    public void criarProdutoBtnOnClick() throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getCriarProdutoFXML());
    }


    public void adicionarProdutoBtnOnClick() {
    }


    public void removerProdutoBtnOnClick(ActionEvent event) {
    }

    public void limparFiltrosBtnOnClick(ActionEvent event) {
    }
}
