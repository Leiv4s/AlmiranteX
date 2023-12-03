package app.pai.models;

import java.net.URL;

public class ModelURL {

    private final URL criarCategoriaFXML = getClass().getResource("/FXML/FXMLDialogViews/CategoryViews/DialogNewCategory.fxml");
    private final URL categoriaInstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentCategoryInstance.fxml");

    private final URL publicoAlvoÏnstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentPublicoAlvoInstance.fxml");
    private final URL criarPublicoAlvoFXML = getClass().getResource("/FXML/FXMLDialogViews/PublicoAlvoViews/CriarPublicoAlvoView.fxml");
    private final URL editarPublicoAlvoFXML = getClass().getResource("/Fxml/FXMLDialogViews/PublicoAlvoViews/UpdatePublicoAlvoView.fxml");
    private final URL excluirPublicoAlvoFXML = getClass().getResource("/Fxml/FXMLDialogViews/PublicoAlvoViews/RemovePublicoAlvoView.fxml");

    private final URL generoInstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentGeneroInstance.fxml");
    private final URL criarGeneroFXML = getClass().getResource("/FXML/FXMLDialogViews/GeneroViews/CriarGeneroView.fxml");
    private final URL editarGeneroFXML = getClass().getResource("/FXML/FXMLDialogViews/GeneroViews/UpdateGeneroView.fxml");
    private final URL excluirGeneroFXML = getClass().getResource("/FXML/FXMLDialogViews/GeneroViews/RemoveGeneroView.fxml");

    public ModelURL() {
    }

    public URL getCriarCategoriaFXML() {
        return criarCategoriaFXML;
    }

    public URL getCategoriaInstanceFXML() {
        return categoriaInstanceFXML;
    }

    public URL getPublicoAlvoÏnstanceFXML() {
        return publicoAlvoÏnstanceFXML;
    }

    public URL getCriarPublicoAlvoFXML() {
        return criarPublicoAlvoFXML;
    }

    public URL getEditarPublicoAlvoFXML() {
        return editarPublicoAlvoFXML;
    }

    public URL getExcluirPublicoAlvoFXML() {
        return excluirPublicoAlvoFXML;
    }

    public URL getGeneroInstanceFXML() {
        return generoInstanceFXML;
    }

    public URL getCriarGeneroFXML() {
        return criarGeneroFXML;
    }

    public URL getEditarGeneroFXML() {
        return editarGeneroFXML;
    }

    public URL getExcluirGeneroFXML() {
        return excluirGeneroFXML;
    }
}
