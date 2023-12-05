package app.pai.Controllers.MenuSectionControllers;

import app.pai.Controllers.PersistanceController;
import app.pai.models.*;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
    public VBox categoriaContainer;
    @FXML
    public VBox publicoAlvoContainer;
    @FXML
    public VBox generoContainer;

    private ModelPublicoAlvo modelPublicoAlvo = new ModelPublicoAlvo();
    private ModelGenero modelGenero = new ModelGenero();
    private ModelCategoria modelCategoria = new ModelCategoria();
    private ModelURL modelURL = new ModelURL();
    public static ObservableList<StringProperty> listaPublicoAlvoObservable = ModelPublicoAlvo.getListaPublicoAlvo();
    public static ObservableList<StringProperty> listaGeneroObservable = ModelGenero.getListaGenero();
    public static ObservableList<ModelCategoria> listaCategoriaObservable = ModelCategoria.getListaCategoria();//carrega lista de categorias


    ListChangeListener<ModelCategoria> listenerCategoria = c -> {
        try {
            categoriaContainer.getChildren().clear();
            getInstance().getViewFactory().categoriaViewInitializer(modelURL.getCategoriaInstanceFXML(), categoriaContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // serialização abaixo:
        PersistanceController persistanceController = new PersistanceController();
        try {
            persistanceController.serializeCategoria(listaCategoriaObservable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    };
    ListChangeListener<StringProperty> listenerPublicoAlvo = c -> {
        System.out.println("percebi");
        try {
            publicoAlvoContainer.getChildren().clear();
            getInstance().getViewFactory().publicoAlvoViewInitializer(modelURL.getPublicoAlvoInstanceFXML(),publicoAlvoContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // serialização abaixo:
        PersistanceController persistanceController = new PersistanceController();
        try {
            persistanceController.serializePublicoAlvo(listaPublicoAlvoObservable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    };
    ListChangeListener<StringProperty> listenerGenero = c -> {
        try {
            generoContainer.getChildren().clear();
            getInstance().getViewFactory().generoViewInitializer(modelURL.getGeneroInstanceFXML(), generoContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // serialização abaixo:
        PersistanceController persistanceController = new PersistanceController();
        try {
            persistanceController.serializeGenero(listaGeneroObservable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    };


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCategoriaLoadedInstances(listaCategoriaObservable, listenerCategoria);
        initializePublicoAlvoLoadedInstances(listaPublicoAlvoObservable, listenerPublicoAlvo);
        initializeGeneroAlvoLoadedInstances(listaGeneroObservable, listenerGenero);

    }





    //carrega as instancias recuperadas da memória ao iniciar o programa
    private void initializePublicoAlvoLoadedInstances(ObservableList<StringProperty> ObservableList, ListChangeListener<StringProperty> listener)  {
        PersistanceController persistanceController = new PersistanceController();
        ObservableList.addListener(listener);
        try {
            ModelPublicoAlvo.setListaPublicoAlvo(persistanceController.desserializePublicoAlvo());
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void initializeGeneroAlvoLoadedInstances(ObservableList<StringProperty> ObservableList, ListChangeListener<StringProperty> listener) {
        PersistanceController persistanceController = new PersistanceController();
        ObservableList.addListener(listener);
        try {
           ModelGenero.setListaGenero(persistanceController.desserializeGenero());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initializeCategoriaLoadedInstances(ObservableList<ModelCategoria> ObservableList, ListChangeListener<ModelCategoria> listener) {
        PersistanceController persistanceController = new PersistanceController();
        ObservableList.addListener(listener);
        try {
           ModelCategoria.setListaCategoria (persistanceController.desserializeCategoria());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
    public void criarCategoriaBtnOnClick() throws IOException {
        getInstance().getViewFactory().getFogPaneController().ableFogPane();
        Model.getInstance().getViewFactory().loadDialogView(modelURL.getCriarCategoriaFXML());
    }
}


