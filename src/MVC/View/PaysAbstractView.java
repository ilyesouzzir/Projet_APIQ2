/*
package MVC.View;

import MVC.Controller.PaysController;
import metier.Pays;
import MVC.Observer.Observer;

import java.util.List;

public abstract class PaysAbstractView implements Observer {

    protected PaysController paysController;
    protected List<Pays> lp;

    public void setController(PaysController paysController){
        this.paysController = paysController;
    }

    public abstract void affMsg(String msg);

    public abstract Pays selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lp) {
        this.lp = lp;
        affList(lp);
    }
}

 */