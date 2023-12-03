package app.pai.Controllers.MenuSectionControllers;

import app.pai.Controllers.PersistanceController;
import app.pai.models.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static app.pai.models.Model.getInstance;

public class EditarLojaController extends PersistanceController implements Initializable, Serializable {


    @FXML
    public TextField textFieldCategoria;
    @FXML
    public TextField textFieldPublicoAlvo;
    @FXML
    public Button cadastrarBtn;
    @FXML
    public Button cadastrarPublicoAlvoBtn;
    @FXML
    public VBox categoriaInstanceContainer = new VBox();
    @FXML
    public VBox publicoAlvoContainer;
    @FXML
    public VBox generosContainer;

    private ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
    private ModelGenero modelGenero = new ModelGenero();
    private ModelURL modelURL = new ModelURL();
    public static ObservableList<StringProperty> listaPublicoAlvoObservable;
    public static ObservableList<StringProperty> listaGeneroObservable;
    public static ObservableList<ModelCategoria> listaCategoriaObservable = FXCollections.observableArrayList(ModelCategoria.getListaModelCategorias());//carrega lista de categorias





    ListChangeListener<StringProperty> listenerPublicoAlvo = c -> {
        System.out.println("percebi");
        try {
            publicoAlvoContainer.getChildren().clear();
            getInstance().getViewFactory().publicoAlvoViewInitializer(modelURL.getPublicoAlvoÏnstanceFXML(),publicoAlvoContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    ListChangeListener<StringProperty> listenerGenero = c -> {
        try {
            generosContainer.getChildren().clear();
            getInstance().getViewFactory().generoViewInitializer(modelURL.getGeneroInstanceFXML(),generosContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializePublicoAlvoLoadedInstances(listaPublicoAlvoObservable, listenerPublicoAlvo);
        initializeGeneroAlvoLoadedInstances(listaGeneroObservable, listenerGenero);

        modelPublicoAlvo.createNewPublicoAlvoInstance(new SimpleStringProperty("alá"));
        modelPublicoAlvo.createNewPublicoAlvoInstance(new SimpleStringProperty("blé"));
        modelPublicoAlvo.createNewPublicoAlvoInstance(new SimpleStringProperty("dló"));
        modelGenero.createNewGeneroInstance("masculino");
        modelGenero.createNewGeneroInstance("feminino");
    }

    //carrega as instancias recuperadas da memória ao iniciar o programa
    private void initializePublicoAlvoLoadedInstances(ObservableList<StringProperty> ObservableList, ListChangeListener<StringProperty> listener) {
        ObservableList = null;
        ObservableList = ModelPublicoAlvo.getListaModelPublicoAlvo();
        ObservableList.addListener(listener);
    }

    private void initializeGeneroAlvoLoadedInstances(ObservableList<StringProperty> ObservableList, ListChangeListener<StringProperty> listener) {
        ObservableList = null;
        ObservableList = ModelGenero.getListaGenero();
        ObservableList.addListener(listener);
    }



    // Botões de criação de listas da pagina
    public void criarPublicoAlvoBtnOnClick() throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getCriarPublicoAlvoFXML());

    }
    public void criarGeneroBtnOnClick()throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getCriarGeneroFXML());
    }

    public void criarCategoriaBtnOnClick() {
    }
}


