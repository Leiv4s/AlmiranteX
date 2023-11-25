package app.pai.Controllers.MenuSectionControllers;

import app.pai.Controllers.ComponentsControllers.ComponentCategoryContainerController;
import app.pai.Controllers.PersistanceController;
import app.pai.models.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarLojaController extends PersistanceController implements Initializable, Serializable {


    @FXML
    public TextField textFieldCategoria;
    @FXML
    public TextField textFieldPublicoAlvo;
    @FXML
    public Button cadastrarBtn;
    @FXML
    public VBox categoriasContainer;

    private int quantidadeCategorias;
    ObservableList<Categoria> categoriaObservable = FXCollections.observableArrayList();//carrega lista de categorias

    Categoria categoriaAdicionada; //recebe o objeto categoria criado, para ser passado como parametro pro listener
    ListChangeListener<Categoria> listener = new ListChangeListener<Categoria>() {
        @Override
        public void onChanged(Change<? extends Categoria> c) {

            try {
                addCategoriaGraphicInstance(getClass().getResource("/FXML/ComponentCategoryContainer.fxml"), categoriaAdicionada);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }; //Listener do container Categorias

    public ObservableList<Categoria> getCategoriaObservable() {
        return categoriaObservable;
    }

    public int getQuantidadeCategorias() {
        return quantidadeCategorias;
    }

    //adiciona nova categoria
    public void createCategoria() throws IOException, ClassNotFoundException {
        String novaCategoria = textFieldCategoria.getText();
        String novoPublicoAlvo = textFieldPublicoAlvo.getText();

        if (categoriaObservable==null){
            quantidadeCategorias = 0;}
        else {
            quantidadeCategorias = categoriaObservable.size();
        }

        Categoria objetoNovaCategoria = new Categoria(novaCategoria,novoPublicoAlvo);
        categoriaAdicionada = objetoNovaCategoria;
        categoriaObservable.add(objetoNovaCategoria);
        try {
            saveData(categoriaObservable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCategoria(){
        for (Categoria categoria:categoriaObservable) {
            if (categoria.equals(categoriaAdicionada)){

            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try { //carrega o ObservableArrayList<categoria> com as instancias salvas pela serialização;
            categoriaObservable = FXCollections.observableArrayList(loadData());
        } catch (IOException | ClassNotFoundException e) {
            //
            //
            //  ----- perguntar ao prof pq isso funciona
            //
            //
        }

        //carrega as categorias salvas
        initializeCategory(getClass().getResource("/FXML/ComponentCategoryContainer.fxml"));

        //adiciona o Listener a ObservableArrayList instanciado com as informações das categorias
        categoriaObservable.addListener(listener);
    }

    /*
    Povoa o container com as Classes recuperadas usando os métodos do PersistanceController;
    deve receber como parametro a URL do arquivo FXML utilizado -> getClass().getResource("path do fxml");
     */
    private void initializeCategory(URL resource) {
        try {
            for (Categoria categoria : categoriaObservable) {
                addCategoriaGraphicInstance(resource, categoria);
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    Adiciona a tela o FXMLLoader de uma instancia da classe Categoria.
    Deve receber como parametro o arquivo fxml que será utilizado e um objeto categoria a ser adicionado;
     */
    private void addCategoriaGraphicInstance(URL resource, Categoria categoria) throws IOException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(resource);
        AnchorPane anchorPane = loader.load();
        ComponentCategoryContainerController categoryContainerController = loader.getController();
        categoryContainerController.setCategoryInfoIntoContainer(categoria);
        categoriasContainer.getChildren().add(anchorPane);
    }


}



