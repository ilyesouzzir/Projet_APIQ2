package MVC.View;

import MVC.Controller.CourseController;
import MVC.Observer.Observer;
import metier.Course;

import java.util.List;

public abstract class CourseAbstractView implements Observer {

    protected CourseController courseController;
    protected List<Course> lc;
    protected PiloteAbstractView pv;

    public void setController(CourseController courseController){
        this.courseController = courseController;
    }

    public abstract void affMsg(String msg);

    public abstract Course selectionner();

    public abstract void menu();
    public void setPiloteView(PiloteAbstractView pv) {
        this.pv = pv;
    }

    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}