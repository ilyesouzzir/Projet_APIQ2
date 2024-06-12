package DesginPatterns.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    protected List<DesginPatterns.builder.Pilote> listePilotes = new ArrayList<DesginPatterns.builder.Pilote>();
    protected String langue;

    public Pilote(int id_pilote, String matricule, String nom, String prenom, LocalDate datenaiss, String langue) {
        this.id_pilote = id_pilote;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.langue = langue;
    }

    public Pilote(int id_pilote, String matricule, String nom, String prenom, LocalDate datenaiss) {
        this.id_pilote = id_pilote;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;

    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
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
    public List<DesginPatterns.builder.Pilote> getListePilotes() {
        return listePilotes;
    }

    /**
     * Méthode setter pour définir la liste des pilotes.
     *
     * @param listePilotes La nouvelle liste des pilotes.
     */
    public void setListePilotes(List<DesginPatterns.builder.Pilote> listePilotes) {
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesginPatterns.builder.Pilote pilote = (DesginPatterns.builder.Pilote) o;
        return id_pilote == pilote.id_pilote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pilote);
    }

    public static class PiloteBuilder {
        private int id_pilote;
        private String matricule;
        private String nom;
        private String prenom;
        private LocalDate datenaiss;
        private Pays pays;
        private String langue;

        public PiloteBuilder setId_pilote(int id_pilote) {
            this.id_pilote = id_pilote;
            return this;
        }

        public PiloteBuilder setMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public PiloteBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public PiloteBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public PiloteBuilder setDateNaiss(LocalDate datenaiss) {
            this.datenaiss = datenaiss;
            return this;
        }

        public PiloteBuilder setPays(Pays pays) {
            this.pays = pays;
            return this;
        }

        public PiloteBuilder setLangue(String langue) {
            this.langue = langue;
            return this;
        }

        public Pilote build() throws Exception {
            if (pays == null) {
                throw new Exception("Le pays ne peut pas être nul");
            }
            if (!langue.equals(pays.getLangue())) {
                throw new Exception("La langue du pilote doit être celle de son pays");
            }
            Pilote pilote = new Pilote(id_pilote, matricule, nom, prenom, datenaiss, langue);
            pilote.setPays(pays);
            return pilote;
        }
    }


}
