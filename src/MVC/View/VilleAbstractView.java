package MVC.View;


import MVC.Controller.VilleController;
import MVC.Observer.Observer;
import metier.Ville;

import java.util.List;

public abstract class VilleAbstractView implements Observer {

    protected VilleController villeController;
    protected List<Ville> lv;

    public void setController(MVC.Controller.VilleController villeController){
        this.villeController = villeController;
    }

    public abstract void affMsg(String msg);

    public abstract Ville selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lv) {
        this.lv = lv;
        affList(lv);
    }
}