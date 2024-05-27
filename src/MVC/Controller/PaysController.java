package MVC.Controller;

import MVC.Model.DAOPays;
import MVC.View.PaysAbstractView;
import MVC.View.VilleAbstractView;
import metier.Pays;

import java.util.List;

public class PaysController {
    private DAOPays model;
    private PaysAbstractView view;

    public PaysController(DAOPays model, PaysAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Pays> getAll(){
        return model.getPays();
    }

    public Pays addPays(Pays pays) {
        return  model.addPays(pays);
    }

    public boolean removePays(Pays pays) {
        return model.removePays(pays);
    }

    public Pays updatePays(Pays pays) {
        return model.updatePays(pays);
    }

    public Pays search(int idPays) {
        return model.readPays(idPays);
    }
    public void setView(PaysAbstractView view) {
        this.view = view;
        if (this.view != null) {
            this.view.setController(this);
        }
    }
}