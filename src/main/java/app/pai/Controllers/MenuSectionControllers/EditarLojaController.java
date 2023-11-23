package app.pai.Controllers.MenuSectionControllers;

import app.pai.models.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditarLojaController implements Initializable, Serializable {

    @FXML
    private TableView<Categoria> tableView;
    @FXML
    private TableColumn<Categoria, String> categoriaColumn;

    @FXML
    private TableColumn<Categoria, String> publicoColumn;
    public TextField textFieldCategoria;

    public TextField textFieldPublicoAlvo;
    public Button cadastrarBtn;


    public void novaCategoria() throws IOException {
        String novaCategoria = textFieldCategoria.getText();
        String novoPublicoAlvo = textFieldPublicoAlvo.getText();
        observableList.add(new Categoria(novaCategoria,novoPublicoAlvo));
        try {
            saveData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ObservableList<Categoria> observableList = FXCollections.observableArrayList(
        new Categoria("calça jeans", "masculino"),
        new Categoria("vestido", "feminino"),
        new Categoria("camiseta", "todos")
    );


    private void saveData() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Data.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(observableList);
        out.close();
        fileOut.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<Categoria, String>("nomeCategoria"));
        publicoColumn.setCellValueFactory(new PropertyValueFactory<Categoria, String>("publicoAlvoCategoria"));
        tableView.setItems(observableList);
    }







}
