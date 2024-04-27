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
}