package MVC.Model;
import MVC.Observer.Subject;
import metier.Pays;
import metier.Pilote;

import java.util.List;

public abstract class DAOPays extends Subject {
    public abstract Pays addPays(Pays pays);

    public abstract boolean removePays(Pays pays);

    public abstract Pays updatePays(Pays pays);

    public abstract Pays readPays(int idPays);

    public abstract List<Pays> getPays();
    public abstract List<Pilote> listePilotes(Pays pays);
}