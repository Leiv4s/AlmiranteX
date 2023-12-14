package app.pai.Controllers.DialogViewsControllers.ProdutoEstoqueViews;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Objects;

public class PmgWindowController {

    @FXML
    private TextField g;
    @FXML
    private TextField gg;
    @FXML
    private TextField m;
    @FXML
    private TextField p;
    @FXML
    private TextField pp;

    public int getG() {
        if (!Objects.equals(g.getText(), "")) {
        return Integer.parseInt(g.getText());
    }return 0;}

    public int getGg() {
        if (!Objects.equals(gg.getText(), "")) {
        return Integer.parseInt(gg.getText());
    }
    return 0;
    }

    public int getM() {
        if (!Objects.equals(m.getText(), "")) {
            return Integer.parseInt(m.getText());
        }
        return 0;
    }

    public int getP() {

        if (!Objects.equals(p.getText(), "")) {
            return Integer.parseInt(p.getText());
        }
        return 0;
    }

    public int getPp() {
        if (!Objects.equals(pp.getText(), "")) {
            return Integer.parseInt(pp.getText());
        }
        return 0;
    }
}



