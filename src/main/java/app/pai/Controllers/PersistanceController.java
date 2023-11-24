package app.pai.Controllers;

import app.pai.models.Categoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Classe utilizada para serializar e desserializar objetos. Aqui se implementa
// a lógica de persistencia dos dados manipulados pelo usuário.
public class PersistanceController implements Serializable {

    //cria um binário de um objeto, salvando seu atual estado;
    public void saveData(ObservableList<Categoria> observableList) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Data.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(new ArrayList<Categoria>(observableList));
        out.close();
        fileOut.close();
    }

    //recupera um objeto com base em um binary code criado na function saveData()
    public ObservableList<Categoria> loadData() throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream("Data.ser");

        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        List<Categoria> list = (List<Categoria>) objectInput.readObject();
        ObservableList<Categoria> categoriaObservable;
        return  categoriaObservable = FXCollections.observableArrayList(list);
        
    }
}
