package DesginPatterns.observer;

import java.util.Objects;

/**
 * Cette classe représente une ville dans le contexte du championnat automobile.
 */
public class Ville {
    /**
     * Identifiant unique de la ville.
     */
    protected int id_ville;

    /**
     * Nom de la ville.
     */
    protected String nom;

    /**
     * Latitude de la ville.
     */
    protected double latitude;

    /**
     * Longitude de la ville.
     */
    protected double longitude;

    /**
     * Pays auquel la ville est associée.
     */
    protected Pays pays;

    /**
     * Constructeur avec paramètres pour initialiser le nom et le pays de la ville.
     *
     * @param nom  Nom de la ville.
     * @param pays Pays auquel la ville appartient.
     */
    public Ville(String nom, Pays pays) {
        this.nom = nom;
        this.pays = pays;
    }

    /**
     * Constructeur avec paramètres pour initialiser le nom, la latitude et la longitude de la ville.
     *
     * @param nom       Nom de la ville.
     * @param latitude  Latitude de la ville.
     * @param longitude Longitude de la ville.
     */
    public Ville(String nom, double latitude, double longitude) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Retourne le nom de la ville.
     *
     * @return Le nom de la ville.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la ville.
     *
     * @param nom Le nouveau nom de la ville.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la latitude de la ville.
     *
     * @return La latitude de la ville.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Modifie la latitude de la ville.
     *
     * @param latitude La nouvelle latitude de la ville.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Retourne la longitude de la ville.
     *
     * @return La longitude de la ville.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Modifie la longitude de la ville.
     *
     * @param longitude La nouvelle longitude de la ville.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Retourne le pays associé à la ville.
     *
     * @return Le pays associé à la ville.
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * Modifie le pays associé à la ville.
     *
     * @param pays Le nouveau pays associé à la ville.
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    /**
     * Retourne l'identifiant unique de la ville.
     *
     * @return L'identifiant unique de la ville.
     */
    public int getId_ville() {
        return id_ville;
    }

    /**
     * Modifie l'identifiant unique de la ville.
     *
     * @param id_ville Le nouvel identifiant unique de la ville.
     */
    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    /**
     * Méthode permettant de récupérer une représentation textuelle de la ville.
     *
     * @return Une chaîne de caractères représentant la ville.
     */
    @Override
    public String toString() {
        return "Ville{" +
                "nom='" + nom + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return id_ville == ville.id_ville;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ville);
    }
}
