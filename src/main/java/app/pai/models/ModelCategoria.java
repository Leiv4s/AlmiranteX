package app.pai.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class ModelCategoria implements Serializable {
    private StringProperty nome;
    static private ObservableList<StringProperty> listaCategoria = FXCollections.observableArrayList();


    //constructor

    public ModelCategoria() {

    }


    //getters section
    public String getNome() {
        return this.nome.get();
    }

    public static ObservableList<StringProperty> getListaCategoria() {
        return listaCategoria;
    }

    public static ArrayList<String> getlistaCategoriaToString() {
        ArrayList<String> listaString = new ArrayList<>();
        for (StringProperty stringProperty : listaCategoria) {
            listaString.add(stringProperty.get());
        }
        return listaString;
    }


    //setters section
    public void setNome(String nome) {
        this.nome.set(nome);
    }


    public static void setListaCategoria(ArrayList<StringProperty> list) {
        for (StringProperty categoria : list) {
            listaCategoria.add(new SimpleStringProperty(categoria.getValue()));
        }

    }


    //                                  OPERAÇÕES CRUD                                //


    //Auxiliar operation variables

    public static void createNewCategoriaInstance(StringProperty newCategoria) {
        listaCategoria.add(newCategoria);
    }

    public static void updateCategoriaInstance(StringProperty oldCategoria, StringProperty newCategoria) {
        for (int i = 0; i < listaCategoria.size(); i++) {
            if (Objects.equals(oldCategoria.toString(), listaCategoria.get(i).toString())) {
                listaCategoria.set(i, newCategoria);
                listaCategoria.addLast(new SimpleStringProperty());
                listaCategoria.removeLast();
            }
        }
    }

    public static void removeCategoriaInstance(String newCategoria) {

        System.out.println(newCategoria);

        for (int i = 0; i < listaCategoria.size(); i++) {
            System.out.println("começo do for");
            System.out.println(newCategoria);
            System.out.println(listaCategoria.get(i).toString());
            if (Objects.equals(newCategoria, listaCategoria.get(i).toString())) {
                System.out.println("entrei");
                listaCategoria.remove(i);
            }
        }
        listaCategoria.addLast(new SimpleStringProperty());
        listaCategoria.removeLast();
    }


    @Override
    public String toString() {
        return "ModelCategoria{" + "nome=" + nome + '}';
    }
}

