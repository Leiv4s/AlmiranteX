package app.pai.models;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;
import java.util.ArrayList;


public class ModelCategoria implements Serializable {
    private StringProperty nome;
    private StringProperty publicoAlvo;
    static private  ArrayList<ModelCategoria> listaModelCategorias = new ArrayList<>();


    //constructor
    public ModelCategoria(String nomeCategoria, String publicoAlvoCategoria) {
        this.nome = new SimpleStringProperty(nomeCategoria);
        this.publicoAlvo = new SimpleStringProperty(publicoAlvoCategoria);

    }



    //getters section
    public String getNome() {
        return nome.get();
    }

    public String getPublicoAlvo() {
        return publicoAlvo.get();
    }

    public static ArrayList<ModelCategoria> getListaModelCategorias() { return listaModelCategorias;}


    
    //setters section
    public void setNome(String nome){
        this.nome.set(nome);
    }
    public void setPublicoAlvo(String nome){
        this.publicoAlvo.set(nome);
    }


    //                      CRUD                        //
    
    public static void createCategoria(ModelCategoria newCategoria){
        listaModelCategorias.add(newCategoria);
    }
    

    
    @Override
    public String toString() {
        return "ModelCategoria{" +
                "nome=" + nome +
                ", publicoAlvo=" + publicoAlvo +
                '}';
    }
}

