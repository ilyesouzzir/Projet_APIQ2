package Championnat.automobile;
import java.util.ArrayList;
import java.util.List;
public class Pays {
    protected int id_pays;
    protected String sigle;
    protected String nom;
    protected String langue;
    protected List <Pilote> list_pilote=new ArrayList<Pilote>();
    public Pays() {
    }

    public Pays(String sigle, String nom, String langue) {
        this.sigle = sigle;
        this.nom = nom;
        this.langue = langue;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public List<Pilote> getList_pilote() {
        return list_pilote;
    }

    public void setList_pilote(List<Pilote> list_pilote) {
        this.list_pilote = list_pilote;
    }

    @Override
    public String toString() {
        return "Pays{" +
                "sigle='" + sigle + '\'' +
                ", nom='" + nom + '\'' +
                ", langue='" + langue + '\'' +
                '}';
    }

}
