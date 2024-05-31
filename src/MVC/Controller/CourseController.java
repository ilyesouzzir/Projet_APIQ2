package MVC.Controller;

import MVC.Model.DAOCourse;
import MVC.View.CourseAbstractView;
import metier.Classement;
import metier.Course;
import metier.Pays;
import metier.Pilote;

import java.math.BigDecimal;
import java.util.List;

public class CourseController {
    private DAOCourse model;
    private CourseAbstractView view;

    public CourseController(DAOCourse model, CourseAbstractView view) {
        this.model = model;
        this.view = view;
        if (this.view != null) {
            this.view.setController(this);
        }
    }

    public List<Course> getAll() {
        return model.getCourses();
    }

    public Course addCourse(Course course) {
        return model.addCourse(course);
    }

    public boolean removeCourse(Course course) {
        return model.removeCourse(course);
    }

    public Course updateCourse(Course course) {
        return model.updateCourse(course);
    }

    public Course search(int idCourse) {
        return model.readCourse(idCourse);
    }

    public void setView(CourseAbstractView view) {
        this.view = view;
        if (this.view != null) {
            this.view.setController(this);
        }
    }

    public List<Classement> ListePilotePlacecGain(Classement cl) {
        return model.listePilotePlaceGain(cl);
    }


    public BigDecimal gainTotal() {
        return model.gainTotal();
    }

    public List<Pays> listePaysPilotes() {
        return model.listePaysPilotes();
    }

    public Pilote vainqueur() {
        return model.vainqueur();
    }

    public void addPilote(Pilote pilote) {
        model.addPilote(pilote);
    }


    public void supPilote(Pilote pilote) {
        model.supPilote(pilote);
    }

    public Classement resultat(Pilote pilote, int place, BigDecimal gain) {
        return model.resultat(pilote, place, gain);
    }

    public void modif(Pilote pilote, int place, BigDecimal gain) {
        model.modif(pilote, place, gain);
    }

    public List<Pilote> ListePiloteDuPays() {
        return model.ListePiloteDuPays();
    }


    public boolean classementComplet() {
        return model.classementComplet();
    }
}