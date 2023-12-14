package app.pai.Controllers.DialogViewsControllers.ProdutoEstoqueViews;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Objects;

public class NumeracaoController {

    @FXML
    private TextField t34;
    @FXML
    private TextField t36;
    @FXML
    private TextField t38;
    @FXML
    private TextField t40;
    @FXML
    private TextField t42;
    @FXML
    private TextField t44;
    @FXML
    private TextField t46;
    @FXML
    private TextField t48;
    @FXML
    private TextField t50;
    @FXML
    private TextField t52;


    public int getT34() {
        if (!Objects.equals(t34.getText(), "")) {
            return Integer.parseInt(t34.getText());
        }
        return 0;
    }

    public int getT36() {
        if (!Objects.equals(t36.getText(), "")) {
            return Integer.parseInt(t36.getText());
        }
        return 0;
    }

    public int getT38() {
        if (!Objects.equals(t38.getText(), "")) {
            return Integer.parseInt(t38.getText());
        }
        return 0;
    }

    public int getT40() {
        if (!Objects.equals(t40.getText(), "")) {
            return Integer.parseInt(t40.getText());
        }
        return 0;
    }

    public int getT42() {
        if (!Objects.equals(t42.getText(), "")) {
            return Integer.parseInt(t42.getText());
        }
        return 0;
    }

    public int getT44() {
        if (!Objects.equals(t44.getText(), "")) {
            return Integer.parseInt(t44.getText());
        }
        return 0;
    }

    public int getT46() {
        if (!Objects.equals(t46.getText(), "")) {
            return Integer.parseInt(t46.getText());
        }
        return 0;
    }

    public int getT48() {
        if (!Objects.equals(t48.getText(), "")) {
            return Integer.parseInt(t48.getText());
        }
        return 0;
    }

    public int getT50() {
        if (!Objects.equals(t50.getText(), "")) {
            return Integer.parseInt(t50.getText());
        }
        return 0;
    }

    public int getT52() {
        if (!Objects.equals(t52.getText(), "")) {
            return Integer.parseInt(t52.getText());
        }
        return 0;
    }
}

