package app.pai.models;

import app.pai.views.ViewFactory;

/*
This class has an important function that is make sure that only one instance of the viewfactory
object is operating the screens of the project, protecting the system of having more than one
instances building and operating screens without need.
 */
public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

/*constructor that create the only one ViewFactory instance, that will
 be used to control all the views */
    private Model(){
        this.viewFactory = new ViewFactory();
    }

/* this function checks if already has one instance of ModelClass and captures that.
* it's the only public function, and returns the path to the Model instance*/
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
