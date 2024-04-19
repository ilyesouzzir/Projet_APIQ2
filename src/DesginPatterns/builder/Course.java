package DesginPatterns.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    /**
     * compteur d'incrementation pour l'identifiant idClassement
     */
    protected static int id_act = 1;
    /**
     * Identifiant unique de la course.
     */
    protected int id_course;

    /**
     * Nom de la course.
     */
    protected String nom;

    /**
     * Distance de la course en kilomètres.
     */
    protected int km;

    /**
     * Date de la course.
     */
    protected LocalDate dateCourse;

    /**
     * Montant de la prime de la course.
     */
    protected BigDecimal priceMoney;

    /**
     * Ville où se déroule la course.
     */
    private Ville ville;

    /**
     * Liste des classements de la course.
     */
    private List<Classement> list_classement = new ArrayList<Classement>();


    // Constructeurs

    /**
     * Constructeur par défaut de la classe Course.
     */
    public Course() {
    }

    /**
     * Constructeur avec paramètres de la classe Course.
     *
     * @param id_course  L'identifiant de la course.
     * @param nom        Le nom de la course.
     * @param km         La distance de la course en kilomètres.
     * @param dateCourse La date de la course.
     * @param priceMoney Le montant de la prime de la course.
     */
    public Course(int id_course, String nom, int km, LocalDate dateCourse, BigDecimal priceMoney) {
        this.id_course = id_course;
        this.nom = nom;
        this.km = km;
        this.dateCourse = dateCourse;
        this.priceMoney = priceMoney;
    }
    

    /**
     * Récupère l'identifiant de la course.
     *
     * @return L'identifiant de la course.
     */
    public int getId_course() {
        return id_course;
    }

    /**
     * Définit l'identifiant de la course.
     *
     * @param id_course L'identifiant de la course.
     */
    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    /**
     * Récupère le nom de la course.
     *
     * @return Le nom de la course.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la course.
     *
     * @param nom Le nom de la course.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère la distance de la course en kilomètres.
     *
     * @return La distance de la course en kilomètres.
     */
    public int getKm() {
        return km;
    }

    /**
     * Définit la distance de la course en kilomètres.
     *
     * @param km La distance de la course en kilomètres.
     */
    public void setKm(int km) {
        this.km = km;
    }

    /**
     * Récupère la date de la course.
     *
     * @return La date de la course.
     */
    public LocalDate getDateCourse() {
        return dateCourse;
    }

    /**
     * Définit la date de la course.
     *
     * @param dateCourse La date de la course.
     */
    public void setDateCourse(LocalDate dateCourse) {
        this.dateCourse = dateCourse;
    }

    /**
     * Récupère le montant de la prime de la course.
     *
     * @return Le montant de la prime de la course.
     */
    public BigDecimal getPriceMoney() {
        return priceMoney;
    }

    /**
     * Définit le montant de la prime de la course.
     *
     * @param priceMoney Le montant de la prime de la course.
     */
    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    /**
     * Récupère la liste des classements de la course.
     *
     * @return La liste des classements de la course.
     */
    public List<Classement> getList_classement() {
        return list_classement;
    }

    /**
     * Définit la liste des classements de la course.
     *
     * @param list_classement La liste des classements de la course.
     */
    public void setList_classement(List<Classement> list_classement) {
        this.list_classement = list_classement;
    }

    /**
     * Récupère la ville où se déroule la course.
     *
     * @return La ville où se déroule la course.
     */
    public Ville getVille() {
        return ville;
    }

    /**
     * Définit la ville où se déroule la course.
     *
     * @param ville La ville où se déroule la course.
     */
    public void setVille(Ville ville) {
        this.ville = ville;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id_course=" + id_course +
                ", nom='" + nom + '\'' +
                ", km=" + km +
                ", dateCourse=" + dateCourse +
                ", priceMoney=" + priceMoney +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id_course == course.id_course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_course);
    }
}
