/*
package MVC.Controller;

import metier.Pays;
import MVC.Model.PaysDAO;
import MVC.View.PaysAbstractView;

import java.util.List;

public class PaysController {
    private PaysDAO model;
    private PaysAbstractView view;

    public PaysController(PaysDAO model, PaysAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Pays> getAll(){
        return model.getPays();
    }

    public Pays addPays(Pays pays) {
        return model.addPays(pays);
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
}

 */