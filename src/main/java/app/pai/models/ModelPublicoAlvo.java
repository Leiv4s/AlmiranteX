package app.pai.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ModelPublicoAlvo {


    static private ObservableList<StringProperty> listaPublicoAlvo = FXCollections.observableArrayList();


    // Constructor
    public ModelPublicoAlvo(){}


    //getters
    public static ObservableList<StringProperty> getListaPublicoAlvo(){
        return listaPublicoAlvo;
    }

    public static ArrayList<String> getListaPublicoAlvoToString() {
        ArrayList<String> listaString = new ArrayList<>();
        for (StringProperty stringProperty : listaPublicoAlvo) {
            listaString.add(stringProperty.get());
        }
        return listaString;
    }

    public ArrayList<String> getListaPublicoAlvoString() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < listaPublicoAlvo.size(); i++) {
            list.add(listaPublicoAlvo.get(i).getValue());
        }
        return list;
    }



    public static void setListaPublicoAlvo(ArrayList<String> list){
        for (String string : list) {
            listaPublicoAlvo.add(new SimpleStringProperty(string));
        }
    }


    //                                  OPERAÇÕES CRUD                                //


                                //Auxiliar operation variables
                                    String parametroPassado;
                                    String queSeraRemovido;


    //CRUD - CREATE
    public void createNewPublicoAlvoInstance(StringProperty nomePublicoAlvo){
        listaPublicoAlvo.add(nomePublicoAlvo);
    }


    //CRUD - DELETE
    public void deletePublicoAlvo(StringProperty publicoAlvoRemovido){
        for(int i = 0; i< listaPublicoAlvo.size() ; i++){
            queSeraRemovido = publicoAlvoRemovido.getValue();
            parametroPassado = listaPublicoAlvo.get(i).getValue();
            if (queSeraRemovido == parametroPassado){
                listaPublicoAlvo.remove(i);
            }
        }
    }


    //CRUD - UPDATE
    public void updatePublicoAlvo (StringProperty oldData, StringProperty newData){
        for(int i = 0; i< listaPublicoAlvo.size() ; i++){
            String instanciasLista = listaPublicoAlvo.get(i).getValue();
            if (oldData.getValue() == instanciasLista){
                listaPublicoAlvo.get(i).set(newData.getValue());
            }
        }
        listaPublicoAlvo.add(new SimpleStringProperty("adicionado pro Listener Ouvir"));
        listaPublicoAlvo.removeLast();
    }
}


