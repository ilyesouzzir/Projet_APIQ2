package Championnat.automobile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pilote {
    protected int id_pilote;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected LocalDate datenaiss;
    protected Pays pays;

    public Pilote() {
    }

    public Pilote(int id_pilote, String matricule, String nom, String prenom, LocalDate datenaiss) {
        this.id_pilote = id_pilote;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;

    }

    public int getId_pilote() {
        return id_pilote;
    }

    public void setId_pilote(int id_pilote) {
        this.id_pilote = id_pilote;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Pilote{" +
                "id_pilote=" + id_pilote +
                ", matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", datenaiss=" + datenaiss +
                '}';
    }
}
