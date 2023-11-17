package app.pai.models;

import app.pai.views.ViewFactory;

public class Model {
/*
This class has an important function that is make sure that only one instance of the viewfactory
object is operating the screens of the project, protecting the system of having more than one
instances building and operating screens without need.
 */
    private static Model model;
    private final ViewFactory viewFactory;


    private Model(){
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}
