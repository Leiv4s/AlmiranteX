package app.pai.models.Utils;

import java.net.URL;

public class ModelURL {

    private final URL criarCategoriaFXML = getClass().getResource("/FXML/FXMLDialogViews/CategoryViews/CriarCategoriaView.fxml");
    private final URL editarCategoriaFXML = getClass().getResource("/FXML/FXMLDialogViews/CategoryViews/EditarCategoriaView.fxml");
    private final URL removeCategoriaFXML = getClass().getResource("/FXML/FXMLDialogViews/CategoryViews/RemoveCategoriaView.fxml");
    private final URL categoriaInstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentCategoryInstance.fxml");


    private final URL publicoAlvoÏnstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentPublicoAlvoInstance.fxml");
    private final URL criarPublicoAlvoFXML = getClass().getResource("/FXML/FXMLDialogViews/PublicoAlvoViews/CriarPublicoAlvoView.fxml");
    private final URL editarPublicoAlvoFXML = getClass().getResource("/Fxml/FXMLDialogViews/PublicoAlvoViews/UpdatePublicoAlvoView.fxml");
    private final URL excluirPublicoAlvoFXML = getClass().getResource("/Fxml/FXMLDialogViews/PublicoAlvoViews/RemovePublicoAlvoView.fxml");


    private final URL generoInstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentGeneroInstance.fxml");
    private final URL criarGeneroFXML = getClass().getResource("/FXML/FXMLDialogViews/GeneroViews/CriarGeneroView.fxml");
    private final URL editarGeneroFXML = getClass().getResource("/FXML/FXMLDialogViews/GeneroViews/UpdateGeneroView.fxml");
    private final URL excluirGeneroFXML = getClass().getResource("/FXML/FXMLDialogViews/GeneroViews/RemoveGeneroView.fxml");


    private final URL produtoInstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentProdutoInstance.fxml");
    private final URL criarProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoViews/CriarProdutoView.fxml");
    private final URL editarProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoViews/EditarProdutoView.fxml");
    private final URL excluirProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoViews/ExcluirProdutoView.fxml");

    private final URL EstoqueProdutoInstanceFXML = getClass().getResource("/FXML/FXMLComponents/ComponentEstoqueProdutoInstance.fxml");



    public ModelURL() {
    }


    public URL getProdutoInstanceFXML() {
        return produtoInstanceFXML;
    }
    public URL getCategoriaInstanceFXML() {
        return categoriaInstanceFXML;
    }
    public URL getPublicoAlvoInstanceFXML() {
        return publicoAlvoÏnstanceFXML;
    }
    public URL getGeneroInstanceFXML() {
        return generoInstanceFXML;
    }


    public URL getCriarProdutoFXML() {
        return criarProdutoFXML;
    }
    public URL getCriarCategoriaFXML() {
        return criarCategoriaFXML;
    }
    public URL getCriarPublicoAlvoFXML() {
        return criarPublicoAlvoFXML;
    }
    public URL getCriarGeneroFXML() {
        return criarGeneroFXML;
    }


    public URL getEditarProdutoFXML() {
        return editarProdutoFXML;
    }
    public URL getEditarCategoriaFXML() { return editarCategoriaFXML;}
    public URL getEditarPublicoAlvoFXML() {
        return editarPublicoAlvoFXML;
    }
    public URL getEditarGeneroFXML() {
        return editarGeneroFXML;
    }

    public URL getExcluirGeneroFXML() {
        return excluirGeneroFXML;
    }
    public URL getExcluirCategoriaFXML() { return removeCategoriaFXML;}
    public URL getExcluirPublicoAlvoFXML() {
        return excluirPublicoAlvoFXML;
    }
    public URL getExcluirProdutoFXML() {
        return excluirProdutoFXML;
    }
}
