package DesginPatterns.builder;

import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe représente un pays participant au championnat automobile.
 */
public class Pays {
    /**
     * compteur d'incrementation pour l'identifiant idPays
     */
    protected static int id_act = 1;
    /**
     * Identifiant unique du pays.
     */
    protected int id_pays;

    /**
     * Sigle du pays.
     */
    protected String sigle;

    /**
     * Nom du pays.
     */
    protected String nom;

    /**
     * Langue principale du pays.
     */
    protected String langue;

    /**
     * Liste des pilotes originaires de ce pays.
     */
    protected Set<Pilote> list_pilote = new HashSet<>();

    /**
     * Constructeur par défaut.
     */
    public Pays() {
    }

    public Pays(PaysBuilder pb) {
        this.id_pays = pb.id_pays;
        this.sigle = pb.sigle;
        this.nom = pb.nom;
        this.langue = pb.langue;
    }

    /**
     * Retourne le sigle du pays.
     *
     * @return Le sigle du pays.
     */
    public String getSigle() {
        return sigle;
    }

    /**
     * Modifie le sigle du pays.
     *
     * @param sigle Le nouveau sigle du pays.
     */
    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    /**
     * Retourne le nom du pays.
     *
     * @return Le nom du pays.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du pays.
     *
     * @param nom Le nouveau nom du pays.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la langue principale du pays.
     *
     * @return La langue principale du pays.
     */
    public String getLangue() {
        return langue;
    }

    /**
     * Modifie la langue principale du pays.
     *
     * @param langue La nouvelle langue principale du pays.
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }

    /**
     * Retourne la liste des pilotes originaires de ce pays.
     *
     * @return La liste des pilotes originaires de ce pays.
     */
    public Set<Pilote> getList_pilote() {
        return list_pilote;
    }

    /**
     * Modifie la liste des pilotes originaires de ce pays.
     *
     * @param list_pilote La nouvelle liste des pilotes originaires de ce pays.
     */
    public void setList_pilote(Set<Pilote> list_pilote) {
        this.list_pilote = list_pilote;
    }

    /**
     * Retourne l'identifiant unique du pays.
     *
     * @return L'identifiant unique du pays.
     */
    public int getId_pays() {
        return id_pays;
    }

    /**
     * Modifie l'identifiant unique du pays.
     *
     * @param id_pays Le nouvel identifiant unique du pays.
     */
    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    /**
     * Méthode permettant de récupérer une représentation textuelle du pays.
     *
     * @return Une chaîne de caractères représentant le pays.
     */
    @Override
    public String toString() {
        return "Pays{" +
                "idPays=" + id_pays +
                ", sigle='" + sigle + '\'' +
                ", nom='" + nom + '\'' +
                ", langue='" + langue + '\'' +
                ", listPilote=" + list_pilote +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o==null) return false;
        if(getClass() != o.getClass()) return false;
        final Pays other = (Pays) o;
        if(this.id_pays!= other.id_pays){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id_pays;
        return hash;
    }

    public static class PaysBuilder{
        /**
         * identifiant unique d'un pays
         */
        protected int id_pays;
        /**
         * sigle d'un pays
         */
        protected String sigle;
        /**
         * nom d'un pays
         */
        protected String nom;
        /**
         * langue d'un pays
         */
        protected String langue;
        public PaysBuilder setIdPays(int id_pays){
            this.id_pays=id_act++;
            return this;
        }
        public PaysBuilder setSigle(String sigle){
            this.sigle=sigle;
            return this;
        }
        public PaysBuilder setNom(String nom){
            this.nom=nom;
            return this;
        }
        public PaysBuilder setLangue(String langue){
            this.langue=langue;
            return this;
        }
        public Pays build() throws Exception{
            if(id_pays<=0||sigle==null||nom==null) throw new Exception("informations de construction incomplètes");
            return new Pays(this);
        }
    }
}