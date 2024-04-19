
/*
package MVC.Controller;
import metier.Ville;
import MVC.Model.VilleDAO;
import MVC.View.VilleAbstractView;

import java.util.List;

public class VilleController {
    private VilleDAO model;
    private VilleAbstractView view;

    public VilleController(VilleDAO model, VilleAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Ville> getAll(){
        return model.getVilles();
    }

    public Ville addVille(Ville ville) {
        return model.addVille(ville);
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
}

 */