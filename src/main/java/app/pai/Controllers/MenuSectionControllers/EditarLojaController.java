package app.pai.Controllers.MenuSectionControllers;

import app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews.CriarPublicoAlvoController;
import app.pai.Controllers.PersistanceController;
import app.pai.models.Model;
import app.pai.models.ModelCategoria;
import app.pai.models.ModelPublicoAlvo;
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


    public static ObservableList<StringProperty> listaPublicoAlvoObservable;

    public static ObservableList<ModelCategoria> listaCategoriaObservable = FXCollections.observableArrayList(ModelCategoria.getListaModelCategorias());//carrega lista de categorias




    URL categoriaFXML = getClass().getResource("/FXML/FXMLComponents/ComponentCategoryInstance.fxml");
    URL publicoAlvoÏnstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentPublicoAlvoInstance.fxml");
    URL criarPublicoAlvoFXML = getClass().getResource("/FXML/FXMLDialogViews/PublicoAlvoViews/CriarPublicoAlvoView.fxml");
    ListChangeListener<StringProperty> listenerPublicoAlvo = c -> {
        try {
            publicoAlvoContainer.getChildren().clear();
            getInstance().getViewFactory().publicoAlvoViewInitializer(publicoAlvoÏnstanceFXML,publicoAlvoContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

    public URL getCriarPublicoAlvoFXML() {
        return this.criarPublicoAlvoFXML;
    };


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InitializeLoadedInstances(listaPublicoAlvoObservable, listenerPublicoAlvo);

        ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
        modelPublicoAlvo.createPublicoAlvo(new SimpleStringProperty("alá"));
        modelPublicoAlvo.createPublicoAlvo(new SimpleStringProperty("blé"));
        modelPublicoAlvo.createPublicoAlvo(new SimpleStringProperty("dló"));
        modelPublicoAlvo.createPublicoAlvo(new SimpleStringProperty("dló"));
        System.out.println(getCriarPublicoAlvoFXML());
    }

    //carrega as instancias recuperadas da memória ao iniciar o programa
    private void InitializeLoadedInstances(ObservableList<StringProperty> ObservableList, ListChangeListener<StringProperty> listener) {
        ObservableList = null;
        ObservableList = ModelPublicoAlvo.getListaModelPublicoAlvo();
        ObservableList.addListener(listener);
    }


    public void criarPublicoAlvoBtnOnClick() throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(getCriarPublicoAlvoFXML());

    }

}



