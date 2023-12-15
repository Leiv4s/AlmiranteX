package app.pai.Controllers.MenuSectionControllers;


import app.pai.Controllers.PersistanceController;
import app.pai.models.*;
import app.pai.models.Utils.ModelURL;
import javafx.beans.property.StringProperty;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static app.pai.models.Model.getInstance;


public class EstoqueController implements Initializable {


    @FXML
    private TextField pesquisarTextfield;
    @FXML
    private Button limparFiltrosBtn;
    @FXML
    private ChoiceBox<String> categoriaChoiceBox;
    @FXML
    private ChoiceBox<String> generoChoiceBox;
    @FXML
    private ChoiceBox<String> produtoChoiceBox;
    @FXML
    private ChoiceBox<String> publicoAlvoChoiceBox;
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
    private ModelEstoque modelEstoque = new ModelEstoque();
    private ModelURL modelURL = new ModelURL();

    private static ObservableList<ModelProduto> listaProdutoEstoqueObservable = ModelEstoque.getListaEstoqueProdutos();
    private ListChangeListener<ModelProduto> listenerProdutoEstoque = c -> {
        // serialização abaixo:
        PersistanceController persistanceController = new PersistanceController();
        if (listaProdutoEstoqueObservable != null) {
            try {
                persistanceController.serializeProdutoEstoque(listaProdutoEstoqueObservable);
                System.out.println("serializei estoque");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };
    private static ObservableList<ModelProdutoDefinicao> listaProdutoDefinicaoObservable = ModelProdutoDefinicao.getListaProdutoDefinicao();
    private ListChangeListener<ModelProdutoDefinicao> listenerProdutoDefinicao = c -> {
        System.out.println("percebi publico");
        try {
            produtoDefinicaoContainer.getChildren().clear();
            getInstance().getViewFactory().produtoDefinicaoViewInitializer(modelURL.getProdutoInstanceFXML(), produtoDefinicaoContainer);
        } catch (Exception e) {
        }

        // serialização abaixo:
        PersistanceController persistanceController = new PersistanceController();
        if (listaProdutoDefinicaoObservable != null) {
            try {
                persistanceController.serializeProdutoDefinicao(listaProdutoDefinicaoObservable);
                System.out.println("serializei listaProdutoDefinicao");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeProdutoDefinicaoLoadedInstances(listaProdutoDefinicaoObservable, listenerProdutoDefinicao);
        initializeEstoque(listaProdutoEstoqueObservable, listenerProdutoEstoque);
        categoriaChoiceBox.getItems().setAll(ModelCategoria.getlistaCategoriaToString());
        categoriaChoiceBox.setOnAction(this::localizarCategorias);
        generoChoiceBox.getItems().setAll(ModelGenero.getListaGeneroToString());
        generoChoiceBox.setOnAction(this::localizarGenero);
        publicoAlvoChoiceBox.getItems().setAll(ModelPublicoAlvo.getListaPublicoAlvoToString());
        publicoAlvoChoiceBox.setOnAction(this::localizarPublicoAlvo);
        produtoChoiceBox.getItems().setAll(ModelProdutoDefinicao.getListaProdutoDefinicaoToString());
        produtoChoiceBox.setOnAction(this::localizarProdutos);
    }

    private void localizarProdutos(ActionEvent event) {
    }

    private void localizarCategorias(ActionEvent event) {
    }
    private void localizarPublicoAlvo(ActionEvent event) {
    }
    private void localizarGenero(ActionEvent event) {
    }


    private void initializeProdutoDefinicaoLoadedInstances(ObservableList<ModelProdutoDefinicao> ObservableList, ListChangeListener<ModelProdutoDefinicao> listener) {
        PersistanceController persistanceController = new PersistanceController();
        ObservableList.addListener(listener);
        try {
            ModelProdutoDefinicao.setListaProdutoDefinicao(persistanceController.desserializeProdutoDefinicao());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initializeEstoque(ObservableList<ModelProduto> ObservableList, ListChangeListener<ModelProduto> listener) {
        PersistanceController persistanceController = new PersistanceController();
        ObservableList.addListener(listener);
        try {
            ModelEstoque.setListaEstoqueProdutos(persistanceController.desserializeProdutoEstoque());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void criarProdutoBtnOnClick() throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getCriarProdutoFXML());
    }
    public void adicionarProdutoBtnOnClick() throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getAdicionarNoEstoqueFXML());
    }
    public void removerProdutoBtnOnClick() throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getRemoverDoEstoqueFXML());
    }
    public void limparFiltrosBtnOnClick(ActionEvent event) {
        produtoDefinicaoContainer.getChildren().clear();
    }




}


