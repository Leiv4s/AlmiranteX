package app.pai;

import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {


    private Pane view;


    public Pane getPage(String fileName) {

        try {
            URL fileUrl = App.class.getResource("/Fxml/" + fileName + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("arquivo FXML não pode ser localizado");
            }
            view = new javafx.fxml.FXMLLoader().load(fileUrl);

        } catch (Exception e) {
            System.out.println(" A pagina "+ fileName+" não existe, cheque os arquivos fxml");
        }
        return view;
    }
}