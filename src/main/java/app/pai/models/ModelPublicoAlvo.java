package app.pai.models;

import app.pai.Controllers.PersistanceController;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ModelPublicoAlvo {


    static private ObservableList<StringProperty> listaModelPublicoAlvo = FXCollections.observableArrayList();


    // Constructor
    public ModelPublicoAlvo(){}


    //getters
    public static ObservableList<StringProperty> getListaModelPublicoAlvo(){
        return listaModelPublicoAlvo;
    }

    public static void setListaModelPublicoAlvo(ArrayList<String> list){
        for (String string : list) {

            listaModelPublicoAlvo.add(new SimpleStringProperty(string));
        }
    }


    //                                  OPERAÇÕES CRUD


                                //Auxiliar operation variables
                                    String parametroPassado;
                                    String queSeraRemovido;


    //CRUD - CREATE
    public void createNewPublicoAlvoInstance(StringProperty nomePublicoAlvo){
        listaModelPublicoAlvo.add(nomePublicoAlvo);
    }


    //CRUD - DELETE
    public void deletePublicoAlvo(StringProperty publicoAlvoRemovido){
        for(int i = 0 ; i<listaModelPublicoAlvo.size() ; i++){
            queSeraRemovido = publicoAlvoRemovido.getValue();
            parametroPassado = listaModelPublicoAlvo.get(i).getValue();
            if (queSeraRemovido == parametroPassado){
                listaModelPublicoAlvo.remove(i);
            }
        }
    }


    //CRUD - UPDATE
    public void updatePublicoAlvo (StringProperty oldData, StringProperty newData){
        for(int i = 0 ; i<listaModelPublicoAlvo.size() ; i++){
            String instanciasLista = listaModelPublicoAlvo.get(i).getValue();
            if (oldData.getValue() == instanciasLista){
                listaModelPublicoAlvo.get(i).set(newData.getValue());
            }
        }
        listaModelPublicoAlvo.add(new SimpleStringProperty("adicionado pro Listener Ouvir"));
        listaModelPublicoAlvo.removeLast();
    }
}


