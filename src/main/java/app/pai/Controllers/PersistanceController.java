package app.pai.Controllers;

import app.pai.models.ModelCategoria;
import javafx.beans.property.SimpleStringProperty;
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

    public void serializeCategoria(ObservableList<StringProperty> list) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Categoria.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> auxArrayList = new ArrayList<>();

        try {
            for (StringProperty categoria: list) {
            auxArrayList.add(new String(categoria.getValue()));
            }
        } catch (Exception e) {
            System.out.println("buguei, mas foda-se tbm essa merda, to funcionando");
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

    public ArrayList<StringProperty> desserializeCategoria() {
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

        ArrayList<String> arrayCarregado;
        ArrayList<StringProperty> arrayCategoria = new ArrayList<>();

        try {
            arrayCarregado = (ArrayList<String>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (String array : arrayCarregado) {
            arrayCategoria.add(new SimpleStringProperty(array));
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
