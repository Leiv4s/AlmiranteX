package app.pai.models;


import app.pai.Controllers.PersistanceController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Objects;


public class Categoria implements Serializable {
    private String nomeCategoria;
    private String publicoAlvoCategoria;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nomeCategoria, categoria.nomeCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCategoria);
    }
}
