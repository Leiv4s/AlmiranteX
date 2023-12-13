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
    private final URL criarProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoDefinicaoViews/CriarProdutoView.fxml");
    private final URL editarProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoDefinicaoViews/EditarProdutoView.fxml");
    private final URL excluirProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoDefinicaoViews/RemoveProdutoView.fxml");
    private final URL consultaEstoqueProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoDefinicaoViews/ConsultaEstoqueProdutoPMGView.fxml");
    private final URL detalheProdutoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoDefinicaoViews/DetalheProdutoView.fxml");


    private final URL adicionarNoEstoqueFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoEstoqueViews/AdicionarProdutoView.fxml");
    private final URL removerDoEstoqueFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoEstoqueViews/RemoverProdutoView.fxml");
    private final URL campoPmgTamanhoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoEstoqueViews/PmgWindow.fxml");
    private final URL campoNumeracaoTamanhoFXML = getClass().getResource("/FXML/FXMLDialogViews/ProdutoEstoqueViews/NumeracaoWindow.fxml");

    public ModelURL() {
    }


    public URL getConsultaEstoqueProdutoFXML() {
        return consultaEstoqueProdutoFXML;
    }

    public URL getDetalheProdutoFXML() {
        return detalheProdutoFXML;
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


    public URL getAdicionarNoEstoqueFXML() {
        return adicionarNoEstoqueFXML;
    }
    public URL getRemoverDoEstoqueFXML() {
        return removerDoEstoqueFXML;
    }
    public URL getCampoPmgTamanhoFXML() {
        return campoPmgTamanhoFXML;
    }
    public URL getCampoNumeracaoTamanhoFXML() {
        return campoNumeracaoTamanhoFXML;
    }


}



