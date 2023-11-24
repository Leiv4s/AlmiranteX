package app.pai.Controllers.MenuSectionControllers;

import app.pai.Controllers.ComponentsControllers.ComponentCategoryContainerController;
import app.pai.Controllers.PersistanceController;
import app.pai.models.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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





    //Lista com listener >> aqui contém a lista de categorias;
    ObservableList<Categoria> categoriaObservable = FXCollections.observableArrayList();

    //adiciona nova categoria
    public void novaCategoria() throws IOException {
        String novaCategoria = textFieldCategoria.getText();
        String novoPublicoAlvo = textFieldPublicoAlvo.getText();

        Categoria objetoNovaCategoria = new Categoria(novaCategoria,novoPublicoAlvo);
        categoriaObservable.add(objetoNovaCategoria);
        try {
            saveData(categoriaObservable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            categoriaObservable = loadData();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            for (Categoria categoria : categoriaObservable) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/FXML/ComponentCategoryContainer.fxml"));

                AnchorPane anchorPane = loader.load();
                ComponentCategoryContainerController categoryContainerController = loader.getController();
                categoryContainerController.setData(categoria);
                categoriasContainer.getChildren().add(anchorPane);

                try {
                    categoriaObservable = loadData();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}



     /*
        //conteudo do initialize;
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<Categoria, String>("nomeCategoria"));
        publicoColumn.setCellValueFactory(new PropertyValueFactory<Categoria, String>("publicoAlvoCategoria"));
        try {
           categoriaObservable = loadData();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tableView.setItems(categoriaObservable);


*/