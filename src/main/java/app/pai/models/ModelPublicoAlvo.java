package app.pai.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ModelPublicoAlvo {

    private StringProperty nomePublicoAlvo;
    static private ObservableList<StringProperty> listaModelPublicoAlvo = FXCollections.observableArrayList();


    // Constructor

    public ModelPublicoAlvo(String nomePublicoAlvo) {
        this.nomePublicoAlvo = new SimpleStringProperty(nomePublicoAlvo);
    }
    public ModelPublicoAlvo(){}

    //getters
    public static ObservableList<StringProperty> getListaModelPublicoAlvo(){
        return listaModelPublicoAlvo;
    }



    //                                  OPERAÇÕES CRUD


                                //Auxiliar operation variables
                                    String parametroPassado;
                                    String queSeraRemovido;


    //CRUD - CREATE
    public void createPublicoAlvo(StringProperty nomePublicoAlvo){
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
                System.out.println("ocorreu");
                System.out.println(listaModelPublicoAlvo.get(i));
                listaModelPublicoAlvo.get(i).set(newData.getValue());
                System.out.println(listaModelPublicoAlvo.get(i));
                System.out.println(listaModelPublicoAlvo);
            }
        }
        listaModelPublicoAlvo.add(new SimpleStringProperty("adicionado pro Listener Ouvir"));
        listaModelPublicoAlvo.removeLast();
    }
}


