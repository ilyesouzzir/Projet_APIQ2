package MVC.Model;

import MVC.Observer.Subject;
import metier.Classement;
import metier.Course;
import metier.Pays;
import metier.Pilote;

import java.math.BigDecimal;
import java.util.List;

public abstract class DAOCourse extends Subject {
    public abstract Course addCourse(Course course);

    public abstract boolean removeCourse(Course course);

    public abstract Course updateCourse(Course course);

    public abstract Course readCourse(int idCourse);

    public abstract List<Course> getCourses();

    public abstract List<Classement> listePilotePlaceGain(Course course);

    public abstract BigDecimal gainTotal(Course course);

    public abstract List<Pays> listePaysPilotes(Course course);

    public abstract Pilote vainqueur(Course course);

    public abstract void addPilote(Pilote pilote);

    public abstract void supPilote(Pilote pilote, Course course);

    public abstract Classement resultat(Pilote pilote, int place, BigDecimal gain);

    public abstract void modif(Pilote pilote, int place, BigDecimal gain, Course course);

    public abstract List<Pilote> ListePiloteDuPays(Course course, Pays pays);

    public abstract boolean classementComplet(Course course);
}