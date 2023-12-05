package app.pai.Controllers;

import app.pai.models.ModelCategoria;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

// Classe utilizada para serializar e desserializar objetos. Aqui se implementa
// a lógica de persistencia dos dados manipulados pelo usuário.
public class PersistanceController implements Serializable {

    class Aux implements Serializable{
        String nome;
        String publicoAlvo;
        String genero;

        public Aux(String nome, String publicoAlvo, String genero){
            this.nome = nome;
            this.publicoAlvo = publicoAlvo;
            this.genero = genero;
        }

        public String getNome() {
            return nome;
        }
        public String getPublicoAlvo() {
            return publicoAlvo;
        }
        public String getGenero() {
            return genero;
        }

    }

    public void serializeCategoria(ObservableList<ModelCategoria> list) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Categoria.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);


        ArrayList<Aux> auxArrayList = new ArrayList<>();

        for (ModelCategoria categoria: list) {
            auxArrayList.add(new Aux(categoria.getNome(), categoria.getPublicoAlvo(), categoria.getGenero()));
        }

        out.writeObject(new ArrayList<>(auxArrayList));
        out.close();
        fileOut.close();
    }
    public void serializePublicoAlvo(ObservableList<StringProperty> observableList) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("PublicoAlvo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> stringList = new ArrayList<>();
        for (StringProperty stringProperty : observableList) {
            stringList.add(stringProperty.get());
        }

        out.writeObject(new ArrayList<>(stringList));
        out.close();
        fileOut.close();


    }
    public void serializeGenero(ObservableList<StringProperty> observableList) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Genero.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> stringList = new ArrayList<>();
        for (StringProperty stringProperty : observableList) {
            stringList.add(stringProperty.get());
        }

        out.writeObject(new ArrayList<>(stringList));
        out.close();
        fileOut.close();

    }

    public ArrayList<ModelCategoria> desserializeCategoria() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("Categoria.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Aux> arrayCarregado;
        ArrayList<ModelCategoria> arrayCategoria = new ArrayList<>();

        try {
            arrayCarregado = (ArrayList<Aux>) objectInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Aux array : arrayCarregado) {
            arrayCategoria.add(new ModelCategoria(array.getNome(), array.getPublicoAlvo(), array.getGenero()));
        }


        return arrayCategoria;

    }
    public ArrayList<String> desserializePublicoAlvo()  {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("PublicoAlvo.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            return (ArrayList<String>) objectInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<String> desserializeGenero()  {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("Genero.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            return (ArrayList<String>) objectInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
