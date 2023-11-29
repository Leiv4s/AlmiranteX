package app.pai.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelPublicoAlvo {

    private StringProperty nomePublicoAlvo;
    static private ObservableList<StringProperty> listaModelPublicoAlvo = FXCollections.observableArrayList();


    // Constructor
    public ModelPublicoAlvo(String nomePublicoAlvo) {
        this.nomePublicoAlvo = new SimpleStringProperty(nomePublicoAlvo);

    }




    //getters
    public static ObservableList<StringProperty> getListaModelPublicoAlvo(){
        return listaModelPublicoAlvo;
    }


    //CRUD - CREATE
    static public void createPublicoAlvo(StringProperty nomePublicoAlvo){
        listaModelPublicoAlvo.add(nomePublicoAlvo);
    }


    //CRUD - DELETE
    static public void deletePublicoAlvo(StringProperty publicoAlvoRemovido){

        for(int i = 0 ; i<listaModelPublicoAlvo.size() ; i++){
            queSeraRemovida = publicoAlvoRemovido.getValue();
            contemNaLista = listaModelPublicoAlvo.get(i).getValue();

            if (queSeraRemovida == contemNaLista){
                listaModelPublicoAlvo.remove(i);
            }
        }
        System.out.println(listaModelPublicoAlvo);
    }


        //delete function variables
        static String contemNaLista;
        static String queSeraRemovida;
        static int count;

}


