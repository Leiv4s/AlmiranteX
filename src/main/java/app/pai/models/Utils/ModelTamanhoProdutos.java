package app.pai.models.Utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;


public class ModelTamanhoProdutos {

    private final ArrayList<StringProperty> listaTamanhos = new ArrayList<>();

    public ModelTamanhoProdutos() {
    }

    public ArrayList<StringProperty> getListaTamanhos() {
        listaTamanhos.add(new SimpleStringProperty("Pequeno-Médio-Grande"));
        listaTamanhos.add(new SimpleStringProperty("Sistema Numérico"));
        return listaTamanhos;
    }


    @Override
    public String toString() {
        return "ModelTamanhoProdutos{" +
                "listaTamanhos=" + listaTamanhos +
                '}';
    }
}
