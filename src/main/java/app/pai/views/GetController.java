package app.pai.views;

public class GetController<Controller> {

    Controller controller;

    public GetController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
}
