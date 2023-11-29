package app.pai.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class ModelPublicoAlvo {

    private StringProperty nomePublicoAlvo;

    static private ArrayList<StringProperty> listaModelPublicoAlvo = new ArrayList<>();

    public ModelPublicoAlvo(String nomePublicoAlvo) {
        this.nomePublicoAlvo = new SimpleStringProperty(nomePublicoAlvo);

    }

    // Constructor

    //getters


    public static ArrayList<StringProperty> getListaModelPublicoAlvo(){
        return listaModelPublicoAlvo;
    }

    //setters

    static public void createPublicoAlvo(StringProperty nomePublicoAlvo){
        listaModelPublicoAlvo.add(nomePublicoAlvo);
    }

    static public void deletePublicoAlvo(StringProperty publicoAlvo){

        listaModelPublicoAlvo.remove(publicoAlvo);
    }

}


