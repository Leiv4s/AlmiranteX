package app.pai.Controllers;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

// Classe utilizada para serializar e desserializar objetos. Aqui se implementa
// a lógica de persistencia dos dados manipulados pelo usuário.
public class PersistanceController implements Serializable {



    //cria um binário de um objeto, salvando seu atual estado;
    public void serialize(ObservableList<StringProperty> observableList) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("PublicoAlvo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> stringList = new ArrayList<>();
        for (StringProperty stringProperty : observableList) {
            stringList.add(stringProperty.get());
        }
        System.out.println(stringList);
        out.writeObject(new ArrayList<>(stringList));
        out.close();
        fileOut.close();


    }
//    //recupera um objeto com base em um binary code criado na function saveData()
    public ArrayList<String> desserialize()  {
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

}
