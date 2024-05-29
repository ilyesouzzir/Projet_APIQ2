package MVC.Model;

import MVC.Observer.Subject;
import metier.Course;

import java.util.List;

public abstract class DAOCourse extends Subject {
    public abstract Course addCourse(Course course);

    public abstract boolean removeCourse(Course course);

    public abstract Course updateCourse(Course course);

    public abstract Course readCourse(int idCourse);

    public abstract List<Course> getCourses();

    // Add the new methods here
    public abstract List listePaysPilotes();

    public abstract Object gainTotal();

    public abstract List listePilotePlaceGain();

    public abstract Object vainqueur();

    public abstract Object resultat();

    public abstract boolean addPilote(Course c);

    public abstract boolean supPilote();

    public abstract boolean modif();

    public abstract Object classementComplet();

    public abstract List ListePiloteDuPays();
}