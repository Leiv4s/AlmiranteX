package app.pai.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelGenero {

    private StringProperty nomeGenero;
    private static ObservableList<StringProperty> listaGenero = FXCollections.observableArrayList();

    //constructor
    public ModelGenero() {
    }

    //getter & setters
    public static ObservableList<StringProperty> getListaGenero() {
        return listaGenero;
    }
    public static void setListaGenero(ArrayList<String> list) {
        for (String strings : list) {
            listaGenero.add(new SimpleStringProperty(strings));
        }
    }




    //                                  OPERAÇÕES CRUD

    // CRUD - CREATE
    public void createNewGeneroInstance(String nomeGenero){
        listaGenero.add(new SimpleStringProperty(nomeGenero));
    }


    // CRUD - UPDATE
    public void updateGeneroInstance(String nomeAntigo, String novoNome){
            System.out.println(nomeAntigo);
            System.out.println(novoNome);
        for (int i = 0; i<listaGenero.size();i++){
            System.out.println("to rodando");
            if (nomeAntigo == listaGenero.get(i).getValue()) {
                System.out.println("achei");
                listaGenero.get(i).set(novoNome);
                listaGenero.add(new SimpleStringProperty());
                listaGenero.removeLast();
          }
        }
    }


    // CRUD - REMOVE
    public void RemoveGeneroInstance(String generoParaRemocao){
        for (int i = 0; i<listaGenero.size();i++){
            if (listaGenero.get(i).getValue() == generoParaRemocao){
                listaGenero.remove(i);
            }
        }
    }




}
