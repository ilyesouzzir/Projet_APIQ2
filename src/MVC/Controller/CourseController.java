package  MVC.Controller;

import MVC.Model.DAOCourse;
import MVC.View.CourseAbstractView;
import metier.Course;

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

    public List<Course> getAll(){
        return model.getCourses();
    }

    public Course addCourse(Course course) {
        return  model.addCourse(course);
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

}