package metier;

import java.math.BigDecimal;

public class Classement {
    /**
     * Identifiant du classement.
     */
    protected int id_classement; // Identifiant du classement

    /**
     * Place du pilote dans le classement.
     */
    protected int place; // Place du pilote dans le classement

    /**
     * Gain du pilote.
     */
    protected BigDecimal gain; // Gain du pilote

    /**
     * Pilote associé à ce classement.
     */
    protected Pilote Pilote; // Pilote associé à ce classement

    /**
     * Renvoie le pilote associé à ce classement.
     *
     * @return Le pilote associé.
     */
    public Pilote getPilote() {
        return Pilote;
    }

    /**
     * Modifie le pilote associé à ce classement.
     *
     * @param pilote Le nouveau pilote associé.
     */
    public void setPilote(Pilote pilote) {
        Pilote = pilote;
    }

    // Constructeurs

    /**
     * Constructeur vide.
     */
    public Classement() {
    }

    /**
     * Constructeur avec initialisation des attributs.
     *
     * @param id_classement L'identifiant du classement.
     * @param place         La place du pilote dans le classement.
     * @param gain          Le gain du pilote.
     */
    public Classement(int id_classement, int place, BigDecimal gain) {
        this.id_classement = id_classement;
        this.place = place;
        this.gain = gain;
    }
    public Classement( int place, BigDecimal gain, Pilote pilote) {
        this.place = place;
        this.gain = gain;
        this.Pilote = pilote;
    }


    // Getters et setters

    /**
     * Renvoie l'identifiant du classement.
     *
     * @return L'identifiant du classement.
     */
    public int getId_classement() {
        return id_classement;
    }

    /**
     * Modifie l'identifiant du classement.
     *
     * @param id_classement Le nouvel identifiant du classement.
     */
    public void setId_classement(int id_classement) {
        this.id_classement = id_classement;
    }

    /**
     * Renvoie la place du pilote dans le classement.
     *
     * @return La place du pilote dans le classement.
     */
    public int getPlace() {
        return place;
    }

    /**
     * Modifie la place du pilote dans le classement.
     *
     * @param place La nouvelle place du pilote dans le classement.
     */
    public void setPlace(int place) {
        this.place = place;
    }

    /**
     * Renvoie le gain du pilote.
     *
     * @return Le gain du pilote.
     */
    public BigDecimal getGain() {
        return gain;
    }

    /**
     * Modifie le gain du pilote.
     *
     * @param gain Le nouveau gain du pilote.
     */
    public void setGain(BigDecimal gain) {
        this.gain = gain;
    }

    // Méthode toString

    /**
     * Renvoie une représentation textuelle de l'objet Classement.
     *
     * @return Une chaîne de caractères représentant le classement.
     */
    @Override
    public String toString() {
        return "Classement{" +
                "id_classement=" + id_classement +
                ", place=" + place +
                ", gain=" + gain +
                ", Pilote=" + Pilote +
                '}';
    }
}
