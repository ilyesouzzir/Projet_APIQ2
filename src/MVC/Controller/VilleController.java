package  MVC.Controller;


import MVC.Model.DAOVille;

import MVC.View.CourseAbstractView;
import MVC.View.VilleAbstractView;
import metier.Ville;


import java.util.List;

public class VilleController {
    private DAOVille model;
    private VilleAbstractView view;

    public VilleController(DAOVille model, VilleAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Ville> getAll(){
        return model.getVilles();
    }

    public Ville addVille(Ville ville) {
        return  model.addVille(ville);
    }

    public boolean removeVille(Ville ville) {
        return model.removeVille(ville);
    }

    public Ville updateVille(Ville ville) {
        return model.updateVille(ville);
    }

    public Ville search(int idVille) {
        return model.readVille(idVille);
    }
    public void setView(VilleAbstractView view) {
        this.view = view;
        if (this.view != null) {
            this.view.setController(this);
        }
    }
}