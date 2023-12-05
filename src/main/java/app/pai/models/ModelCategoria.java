package app.pai.models;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;


public class ModelCategoria implements Serializable {
    private StringProperty nome;
    private StringProperty publicoAlvo;
    private StringProperty genero;
    static private ObservableList<ModelCategoria> listaCategoria = FXCollections.observableArrayList();


    //constructor



    public ModelCategoria(String nomeCategoria, String publicoAlvoCategoria, String genero) {
        this.nome = new SimpleStringProperty(nomeCategoria);
        this.publicoAlvo = new SimpleStringProperty(publicoAlvoCategoria);
        this.genero = new SimpleStringProperty(genero);
    }

    public ModelCategoria() {

    }


    //getters section
    public String getNome() {
        return nome.get();
    }
    public String getPublicoAlvo() {
        return publicoAlvo.get();
    }
    public String getGenero() {
        return genero.get();
    }
    public static ObservableList<ModelCategoria> getListaCategoria() { return listaCategoria;}



    //setters section
    public void setGenero(String genero) {
        this.genero.set(genero);
    }
    public void setNome(String nome){
        this.nome.set(nome);
    }
    public void setPublicoAlvo(String nome){
        this.publicoAlvo.set(nome);
    }

    public static void setListaCategoria(ArrayList<ModelCategoria> list) {
        for (ModelCategoria categoria: list) {
            listaCategoria.add(new ModelCategoria(categoria.getNome(), categoria.getPublicoAlvo(), categoria.getGenero()));
        }

    }


    //                                  OPERAÇÕES CRUD                                //


                                //Auxiliar operation variables
    
    public static void createCategoria(ModelCategoria newCategoria){
        listaCategoria.add(newCategoria);
    }
    

    
    @Override
    public String toString() {
        return "ModelCategoria{" +
                "nome=" + nome +
                ", publicoAlvo=" + publicoAlvo +
                '}';
    }
}

