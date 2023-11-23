package app.pai.Controllers.MenuSectionControllers;

import app.pai.Controllers.PersistanceController;
import app.pai.models.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditarLojaController extends PersistanceController implements Initializable, Serializable {

    @FXML
    private TableView<Categoria> tableView;
    @FXML
    private TableColumn<Categoria, String> categoriaColumn;

    @FXML
    private TableColumn<Categoria, String> publicoColumn;
    public TextField textFieldCategoria;

    public TextField textFieldPublicoAlvo;
    public Button cadastrarBtn;

    //Lista com listener >> aqui contém a lista de categorias;
    ObservableList<Categoria> categoriaObservable = FXCollections.observableArrayList();


    //adiciona nova categoria
    public void novaCategoria() throws IOException {
        String novaCategoria = textFieldCategoria.getText();
        String novoPublicoAlvo = textFieldPublicoAlvo.getText();
        categoriaObservable.add(new Categoria(novaCategoria,novoPublicoAlvo));
        try {
            saveData(categoriaObservable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<Categoria, String>("nomeCategoria"));
        publicoColumn.setCellValueFactory(new PropertyValueFactory<Categoria, String>("publicoAlvoCategoria"));
        try {
           categoriaObservable = loadData();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        tableView.setItems(categoriaObservable);
    }







}
