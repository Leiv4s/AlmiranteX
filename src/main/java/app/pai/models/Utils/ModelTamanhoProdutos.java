package app.pai.models.Utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ModelTamanhoProdutos {

    private final ArrayList<StringProperty> listaTamanhos = new ArrayList<>();
    private final ArrayList<StringProperty> numerosTamanho = new ArrayList<>();
    private final ArrayList<StringProperty> letrasTamanho = new ArrayList<>();

    public ModelTamanhoProdutos() {
    }


    public ArrayList<StringProperty> getNumerosTamanho() {
        for (int i = 36; i < 52; i = i + 2) {
            numerosTamanho.add(new SimpleStringProperty(String.valueOf(i)));

        }
            return numerosTamanho;
    }

    public ArrayList<StringProperty> getLetrasTamanho() {
        numerosTamanho.add(new SimpleStringProperty("PP"));
        numerosTamanho.add(new SimpleStringProperty("P"));
        numerosTamanho.add(new SimpleStringProperty("M"));
        numerosTamanho.add(new SimpleStringProperty("G"));
        numerosTamanho.add(new SimpleStringProperty("GG"));
        numerosTamanho.add(new SimpleStringProperty("XGG"));
        return letrasTamanho;
    }


    public ArrayList<StringProperty> getListaTamanhos() {
        listaTamanhos.clear();
        listaTamanhos.add(new SimpleStringProperty("P-M-G"));
        listaTamanhos.add(new SimpleStringProperty("Numérico"));
        return listaTamanhos;
    }

    @Override
    public String toString() {
        return "ModelTamanhoProdutos{" +
                "listaTamanhos=" + listaTamanhos +
                '}';
    }


}
