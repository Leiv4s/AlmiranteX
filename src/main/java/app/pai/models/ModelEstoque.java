package app.pai.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ModelEstoque {

    private static ObservableList<ModelProduto> listaEstoqueProdutos = FXCollections.observableArrayList();

    public static ObservableList<ModelProduto> getListaEstoqueProdutos() {
        return listaEstoqueProdutos;
    }

    public static void setListaEstoqueProdutos(ArrayList<ModelProduto> list) {
        listaEstoqueProdutos.addAll(list);
    }

    // CRUD OPERATIONS


    public static void adicionarProduto(ModelProduto novoProduto) {
        listaEstoqueProdutos.add(novoProduto);
    }

    public static void removerProduto(ModelProduto produto) {

        for (int i = 0; i < listaEstoqueProdutos.size(); i++) {
            if (Objects.equals(listaEstoqueProdutos.get(i).getTamanho(), produto.getTamanho())
                    &&
                    Objects.equals(listaEstoqueProdutos.get(i).getProdutoDefinicao().toStringCompleto(), produto.getProdutoDefinicao().toStringCompleto())
            ) {
                listaEstoqueProdutos.remove(i);
            }
        }
    }

    public static void buscarProduto(ModelProduto produto) {

    }



}
