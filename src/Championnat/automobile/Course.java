package Championnat.automobile;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Course {
    protected int id_course;
    protected String nom;
    protected int km;
    protected LocalDate dateCourse;
    protected BigDecimal priceMoney;
    private Ville ville;
    private List<Classement> list_classement = new ArrayList<Classement>();
    private List<Course> listeCourses = new ArrayList<Course>();
    protected List<Pilote> listePilotes = new ArrayList<Pilote>();

    public Course() {
    }

    public Course(int id_course, String nom, int km, LocalDate dateCourse, BigDecimal priceMoney) {
        this.id_course = id_course;
        this.nom = nom;
        this.km = km;
        this.dateCourse = dateCourse;
        this.priceMoney = priceMoney;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public LocalDate getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(LocalDate dateCourse) {
        this.dateCourse = dateCourse;
    }

    public BigDecimal getPriceMoney() {
        return priceMoney;
    }

    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    public List<Classement> getList_classement() {
        return list_classement;
    }

    public void setList_classement(List<Classement> list_classement) {
        this.list_classement = list_classement;
    }

    // METHODE
    public void addCoureur(Pilote coureur) {
        listePilotes.add(coureur);
    }

    public void supCoureur(Pilote coureur) {
        listePilotes.remove(coureur);
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

}
