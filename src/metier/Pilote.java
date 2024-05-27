package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pilote {

    /**
     * Identifiant unique du pilote.
     */
    protected int id_pilote;

    /**
     * Matricule du pilote, utilisé pour l'identifier.
     */
    protected String matricule;

    /**
     * Nom du pilote.
     */
    protected String nom;

    /**
     * Prénom du pilote.
     */
    protected String prenom;

    /**
     * Date de naissance du pilote.
     */
    protected LocalDate datenaiss;

    /**
     * Pays d'origine du pilote.
     */
    protected Pays pays;

    /**
     * Liste des pilotes associés à ce pilote.
     */
    protected List<Pilote> listePilotes = new ArrayList<Pilote>();

    public Pilote() {
    }

    public Pilote(int id_pilote, String matricule, String nom, String prenom, LocalDate datenaiss) {
        this.id_pilote = id_pilote;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;

    }

    public Pilote(String matricule, String nom, String prenom, LocalDate datenaiss) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
    }

    /**
     * Méthode getter pour récupérer l'identifiant du pilote.
     */
    public int getId_pilote() {
        return id_pilote;
    }

    /**
     * Méthode setter pour définir l'identifiant du pilote.
     *
     * @param id_pilote Le nouvel identifiant du pilote.
     */
    public void setId_pilote(int id_pilote) {
        this.id_pilote = id_pilote;
    }

    /**
     * Méthode getter pour récupérer le matricule du pilote.
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Méthode setter pour définir le matricule du pilote.
     *
     * @param matricule Le nouveau matricule du pilote.
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * Méthode getter pour récupérer le nom du pilote.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode setter pour définir le nom du pilote.
     *
     * @param nom Le nouveau nom du pilote.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode getter pour récupérer le prénom du pilote.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Méthode setter pour définir le prénom du pilote.
     *
     * @param prenom Le nouveau prénom du pilote.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode getter pour récupérer la date de naissance du pilote.
     */
    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    /**
     * Méthode setter pour définir la date de naissance du pilote.
     *
     * @param datenaiss La nouvelle date de naissance du pilote.
     */
    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    /**
     * Méthode getter pour récupérer le pays du pilote.
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * Méthode setter pour définir le pays du pilote.
     *
     * @param pays Le nouveau pays du pilote.
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /**
     * Méthode getter pour récupérer la liste des pilotes.
     */
    public List<Pilote> getListePilotes() {
        return listePilotes;
    }

    /**
     * Méthode setter pour définir la liste des pilotes.
     *
     * @param listePilotes La nouvelle liste des pilotes.
     */
    public void setListePilotes(List<Pilote> listePilotes) {
        this.listePilotes = listePilotes;
    }

    /**
     * Méthode pour obtenir une représentation textuelle de l'objet Pilote.
     *
     * @return Une chaîne de caractères représentant l'objet Pilote.
     */
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
