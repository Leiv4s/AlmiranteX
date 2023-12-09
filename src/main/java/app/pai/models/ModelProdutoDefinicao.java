package app.pai.models;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelProdutoDefinicao implements Serializable {
    //atributes

    private StringProperty nomeProduto;
    private StringProperty tipoTamanho;
    private StringProperty categoria;
    private StringProperty publicoAlvo;
    private StringProperty genero;
    private FloatProperty precoCusto;
    private FloatProperty precoVenda;

    private static ObservableList<ModelProdutoDefinicao> listaProdutoDefinicao = FXCollections.observableArrayList();


    //CONSTRUCTORS
    public ModelProdutoDefinicao() {
    }

    public ModelProdutoDefinicao(String nomeProduto, String categoria, String genero, String publicoAlvo, String tipoTamanho, float precoCusto, float precoVenda) {
        this.nomeProduto = new SimpleStringProperty (nomeProduto);
        this.categoria = new SimpleStringProperty(categoria);
        this.genero = new SimpleStringProperty(genero);
        this.publicoAlvo = new SimpleStringProperty(publicoAlvo);
        this.tipoTamanho = new SimpleStringProperty(tipoTamanho);
        this.precoCusto = new SimpleFloatProperty(precoCusto);
        this.precoVenda = new SimpleFloatProperty(precoVenda);
    }


    //GETTERS AND SETTERS

    public String getNomeProduto() {
        return nomeProduto.get();
    }

    public StringProperty nomeProdutoProperty() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto.set(nomeProduto);
    }


    public String getCategoria() {
        return categoria.get();
    }

    public StringProperty categoriaProperty() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }


    public String getGenero() {
        return genero.get();
    }

    public StringProperty generoProperty() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero.set(genero);
    }


    public String getPublicoAlvo() {
        return publicoAlvo.get();
    }

    public StringProperty publicoAlvoProperty() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo.set(publicoAlvo);
    }


    public String getTipoTamanho() {
        return tipoTamanho.get();
    }

    public StringProperty tipoTamanhoProperty() {
        return tipoTamanho;
    }

    public void setTipoTamanho(String tipoTamanho) {
        this.tipoTamanho.set(tipoTamanho);
    }


    public float getPrecoCusto() {
        return precoCusto.get();
    }

    public FloatProperty precoCustoProperty() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto.set(precoCusto);
    }


    public float getPrecoVenda() {
        return precoVenda.get();
    }

    public FloatProperty precoVendaProperty() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda.set(precoVenda);
    }

    public static ObservableList<ModelProdutoDefinicao> getListaProdutoDefinicao() {
        return listaProdutoDefinicao;
    }

    public static void setListaProdutoDefinicao(ArrayList<ModelProdutoDefinicao> list) {
        listaProdutoDefinicao.addAll(list);
    }



    //                              CRUD OPERATIONS



    public static void createNewDefinicaoProdutoInstance(ModelProdutoDefinicao newProduto) {
        listaProdutoDefinicao.add(newProduto);
    }

    public static void updateDefinicaoProdutoInstance(ModelProdutoDefinicao oldProduto, ModelProdutoDefinicao newProduto) {

    }

    public static void removeDefinicaoProdutoInstance(ModelProdutoDefinicao produtoRemovido) {

    }


    @Override
    public String toString() {
        return "ModelProdutoDefinicao{" +
                "nomeProduto=" + nomeProduto +
                ", categoria=" + categoria +
                ", genero=" + genero +
                ", publicoAlvo=" + publicoAlvo +
                ", tipoTamanho=" + tipoTamanho +
                ", precoCusto=" + precoCusto +
                ", precoVenda=" + precoVenda +
                '}';
    }
}
