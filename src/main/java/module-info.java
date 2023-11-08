module app.pai.paiquemmanda {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.pai.Controllers to javafx.fxml;
    opens app.pai.models to javafx.fxml;
    exports app.pai.models;
    exports app.pai.Controllers;
    exports app.pai.Controllers.Admin;
    exports app.pai.views;
    exports app.pai;

}