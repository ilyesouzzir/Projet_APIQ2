package  MVC.Controller;

import MVC.Model.DAOPilote;
import MVC.View.PiloteAbstractView;
import MVC.View.VilleAbstractView;
import metier.Pilote;

import java.util.List;

public class PiloteController {
    private DAOPilote model;
    private PiloteAbstractView view;

    public PiloteController(DAOPilote model, PiloteAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Pilote> getAll(){
        return model.getPilotes();
    }

    public Pilote addPilote(Pilote pilote) {
        return  model.addPilote(pilote);
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
    public void setView(PiloteAbstractView view) {
        this.view = view;
        if (this.view != null) {
            this.view.setController(this);
        }
    }

    public int getTotalGains(int idPilote) {
        return model.getTotalGains(idPilote);
    }
}