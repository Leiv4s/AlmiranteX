module app.pai.paiquemmanda {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires de.jensd.fx.glyphs.commons;
    requires annotations;


    opens app.pai.Controllers to javafx.fxml;
    opens app.pai.models to javafx.fxml;
    exports app.pai.models;
    exports app.pai.Controllers;
    exports app.pai.views;
    exports app.pai;
    exports app.pai.Controllers.ComponentsControllers;
    opens app.pai.Controllers.ComponentsControllers to javafx.fxml;
    exports app.pai.Controllers.MenuSectionControllers;
    opens app.pai.Controllers.MenuSectionControllers to javafx.fxml;
    exports app.pai.Controllers.DialogViewsControllers.CategoriaViews;
    opens app.pai.Controllers.DialogViewsControllers.CategoriaViews to javafx.fxml;
    exports app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews;
    opens app.pai.Controllers.DialogViewsControllers.PublicoAlvoViews to javafx.fxml;
    exports app.pai.Controllers.DialogViewsControllers.GeneroView;
    opens app.pai.Controllers.DialogViewsControllers.GeneroView to javafx.fxml;
    exports app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews;
    opens app.pai.Controllers.DialogViewsControllers.ProdutoDefinicaoViews to javafx.fxml;
    exports app.pai.Controllers.DialogViewsControllers.ProdutoEstoqueViews;
    opens app.pai.Controllers.DialogViewsControllers.ProdutoEstoqueViews to javafx.fxml;
    exports app.pai.models.Utils;
    opens app.pai.models.Utils to javafx.fxml;

}