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
        return this.nome.get();
    }
    public String getPublicoAlvo() {
        return this.publicoAlvo.get();
    }
    public String getGenero() {
        return this.genero.get();
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
    
    public static void createNewCategoriaInstance(ModelCategoria newCategoria){
        listaCategoria.add(newCategoria);
    }

    public static void updateCategoriaInstance(ModelCategoria oldCategoria,ModelCategoria newCategoria) {
        for(int i = 0; i<listaCategoria.size();i++){
            if (Objects.equals(oldCategoria.toString(), listaCategoria.get(i).toString())){
                listaCategoria.set(i, newCategoria);
                listaCategoria.addLast(new ModelCategoria());
                listaCategoria.removeLast();
            }
        }
    }

    public static void removeCategoriaInstance(String newCategoria) {

        System.out.println(newCategoria);

        for (int i = 0; i <listaCategoria.size();i++){
            System.out.println("começo do for");
            System.out.println(newCategoria);
            System.out.println(listaCategoria.get(i).toString());
            if (Objects.equals(newCategoria, listaCategoria.get(i).toString())){
                System.out.println("entrei");
                listaCategoria.remove(i);
            }
        }
        listaCategoria.addLast(new ModelCategoria());
        listaCategoria.removeLast();
    }




    
    @Override
    public String toString() {
        return "ModelCategoria{" +
                "nome=" + nome +
                ", publicoAlvo=" + publicoAlvo + "genero=" + genero +
                '}';
    }
}

