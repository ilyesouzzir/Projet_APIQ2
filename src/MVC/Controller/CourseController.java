/*
package MVC.Controller;

import metier.Course;
import MVC.Model.CourseDAO;
import MVC.View.CourseAbstractView;

import java.util.List;

public class CourseController {
    private CourseDAO model;
    private CourseAbstractView view;

    public CourseController(CourseDAO model, CourseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Course> getAll(){
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
}

 */