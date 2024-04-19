/*
package MVC.View;

import MVC.Controller.CourseController;
import metier.Course;
import MVC.Observer.Observer;

import java.util.List;

public abstract class CourseAbstractView implements Observer {

    protected CourseController courseController;
    protected List<Course> lc;

    public void setController(CourseController courseController){
        this.courseController = courseController;
    }

    public abstract void affMsg(String msg);

    public abstract Course selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}
/
 */