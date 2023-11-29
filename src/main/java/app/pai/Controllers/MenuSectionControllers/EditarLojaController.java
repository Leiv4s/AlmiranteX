package app.pai.Controllers.MenuSectionControllers;

import app.pai.Controllers.PersistanceController;
import app.pai.models.Model;
import app.pai.models.ModelCategoria;
import app.pai.models.ModelPublicoAlvo;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EditarLojaController extends PersistanceController implements Initializable, Serializable {


    @FXML
    public TextField textFieldCategoria;
    @FXML
    public TextField textFieldPublicoAlvo;
    @FXML
    public Button cadastrarBtn;
    @FXML
    public VBox categoriaInstanceContainer = new VBox();
    @FXML
    public VBox publicoAlvoContainer = new VBox();


    public static ObservableList<StringProperty> listaPublicoAlvoObservable = FXCollections.observableArrayList(ModelPublicoAlvo.getListaModelPublicoAlvo());

    public static ObservableList<ModelCategoria> listaCategoriaObservable = FXCollections.observableArrayList(ModelCategoria.getListaModelCategorias());//carrega lista de categorias







    URL categoriaFXML = getClass().getResource("/FXML/ComponentCategoryInstance.fxml");
    URL publicoAlvoFXML = getClass().getResource("/FXML/ComponentPublicoAlvoInstance.fxml");

    ModelCategoria modelCategoriaAdicionada; //recebe o objeto categoria criado, para ser passado como parametro pro listener

    ListChangeListener<ModelCategoria> listenerCategoria = new ListChangeListener<>() {
        @Override
        public void onChanged(Change<? extends ModelCategoria> c) {

            try {
                Model.getInstance().getViewFactory().addCategoriaView(publicoAlvoFXML, modelCategoriaAdicionada, categoriaInstanceContainer);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    };

    ListChangeListener<ModelPublicoAlvo> listenerPublicoAlvo = new ListChangeListener<>() {
        @Override
        public void onChanged(Change<? extends ModelPublicoAlvo> c) {

            try {
                Model.getInstance().getViewFactory().publicoAlvoViewInitializer(publicoAlvoFXML,publicoAlvoContainer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    };




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ModelCategoria.createCategoria(new ModelCategoria("asdasd", "alá"));
        ModelPublicoAlvo.createPublicoAlvo(new SimpleStringProperty("alá"));
        //carrega as categorias salvas
        Model.getInstance().getViewFactory().categorysViewInitializer(categoriaFXML, categoriaInstanceContainer);
        Model.getInstance().getViewFactory().publicoAlvoViewInitializer(publicoAlvoFXML, publicoAlvoContainer);
        //adiciona o Listener a ObservableArrayList instanciado com as informações das categorias
        listaPublicoAlvoObservable.addListener ((InvalidationListener) listenerPublicoAlvo);
    }




    //adiciona nova categoria
    public void createCategoria() throws IOException, ClassNotFoundException {
        String novaCategoria = textFieldCategoria.getText();
        String novoPublicoAlvo = textFieldPublicoAlvo.getText();
        modelCategoriaAdicionada = new ModelCategoria(novaCategoria,novoPublicoAlvo);
        Model.getInstance().getViewFactory().addCategoriaView(getClass().getResource("/FXML/ComponentCategoryInstance.fxml"), modelCategoriaAdicionada, categoriaInstanceContainer);


    }


}



