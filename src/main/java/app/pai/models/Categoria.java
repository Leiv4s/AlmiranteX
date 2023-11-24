package app.pai.models;


import app.pai.Controllers.PersistanceController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;


public class Categoria implements Serializable {

    private static ObservableList<String> hallCategorias = FXCollections.observableArrayList();
    private String nomeCategoria;
    private String publicoAlvoCategoria;
    ObservableList<Categoria> observableList;

    //constructor
    public Categoria(String nomeCategoria, String publicoAlvoCategoria) {
        this.nomeCategoria = nomeCategoria;
        this.publicoAlvoCategoria = publicoAlvoCategoria;

    }


    //getters section

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public String getPublicoAlvoCategoria() {
        return publicoAlvoCategoria;
    }

    PersistanceController persistanceController = new PersistanceController();




}
