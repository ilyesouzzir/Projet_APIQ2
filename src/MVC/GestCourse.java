package MVC;
import MVC.Controller.CourseController;
import MVC.Model.CourseModelDB;
import MVC.Model.DAOCourse;
import MVC.View.CourseAbstractView;
import MVC.View.CourseViewConsole;
import utilitaires.Utilitaire;
import java.util.Arrays;
import java.util.List;

public class GestCourse {
    private DAOCourse cm;
    private CourseController cc;
    private CourseAbstractView cv;

    public void gestion() {
        cm = new CourseModelDB();
        cc = new CourseController(cm, null);
        cv = new CourseViewConsole(cc);
        cc.setView(cv);
        cm.addObserver(cv);
        List<String> loptions = Arrays.asList("courses", "fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch) {
                case 1:
                    cv.menu();
                    break;
                case 2:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args) {
        GestCourse gc = new GestCourse();
        gc.gestion();
    }
}