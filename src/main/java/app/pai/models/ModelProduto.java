package app.pai.models;

import javafx.beans.property.StringProperty;

public class ModelProduto {

    ModelProdutoDefinicao produtoDefinicao = new ModelProdutoDefinicao();
    StringProperty tamanho;

    public ModelProduto() {
    }

    public ModelProduto(ModelProdutoDefinicao produtoDefinicao, StringProperty tamanho) {
        this.produtoDefinicao = produtoDefinicao;
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return tamanho.get();
    }

    public StringProperty tamanhoProperty() {
        return tamanho;
    }

    public ModelProdutoDefinicao getProdutoDefinicao() {
        return produtoDefinicao;
    }
}
