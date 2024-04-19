/*
package MVC.Controller;
import metier.Pilote;
import MVC.Model.PiloteDAO;
import MVC.View.PiloteAbstractView;

import java.util.List;

public class PiloteController {
    private PiloteDAO model;
    private PiloteAbstractView view;

    public PiloteController(PiloteDAO model, PiloteAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Pilote> getAll(){
        return model.getPilotes();
    }

    public Pilote addPilote(Pilote pilote) {
        return model.addPilote(pilote);
    }

    public boolean removePilote(Pilote pilote) {
        return model.removePilote(pilote);
    }

    public Pilote updatePilote(Pilote pilote) {
        return model.updatePilote(pilote);
    }

    public Pilote search(int idPilote) {
        return model.readPilote(idPilote);
    }
}

 */