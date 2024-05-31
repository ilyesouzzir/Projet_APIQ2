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

    public abstract List<Classement> listePilotePlaceGain(Classement cl);

    public abstract BigDecimal gainTotal();

    public abstract List<Pays> listePaysPilotes();

    public abstract Pilote vainqueur();

    public abstract void addPilote(Pilote pilote);

    public abstract void supPilote(Pilote pilote);

    public abstract Classement resultat(Pilote pilote, int place, BigDecimal gain);

    public abstract void modif(Pilote pilote, int place, BigDecimal gain);

    public abstract List<Pilote> ListePiloteDuPays();

    public abstract boolean classementComplet();
}