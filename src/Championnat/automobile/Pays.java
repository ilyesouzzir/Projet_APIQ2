package Championnat.automobile;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un pays participant au championnat automobile.
 */
public class Pays {
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
    protected List<Pilote> list_pilote = new ArrayList<Pilote>();

    /**
     * Constructeur par défaut.
     */
    public Pays() {
    }

    /**
     * Constructeur avec paramètres pour initialiser le sigle, le nom et la langue du pays.
     *
     * @param sigle  Sigle du pays.
     * @param nom    Nom du pays.
     * @param langue Langue principale du pays.
     */
    public Pays(String sigle, String nom, String langue) {
        this.sigle = sigle;
        this.nom = nom;
        this.langue = langue;
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
    public List<Pilote> getList_pilote() {
        return list_pilote;
    }

    /**
     * Modifie la liste des pilotes originaires de ce pays.
     *
     * @param list_pilote La nouvelle liste des pilotes originaires de ce pays.
     */
    public void setList_pilote(List<Pilote> list_pilote) {
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
                "sigle='" + sigle + '\'' +
                ", nom='" + nom + '\'' +
                ", langue='" + langue + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pays pays = (Pays) o;

        return id_pays == pays.id_pays;
    }

    @Override
    public int hashCode() {
        return id_pays;
    }
}
