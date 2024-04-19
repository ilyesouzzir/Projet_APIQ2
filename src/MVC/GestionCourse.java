/*
package MVC;

import MVC.Controller.CourseController;
import MVC.Model.CourseDAO;
import MVC.Model.*;
import MVC.View.CourseAbstractView;
import MVC.View.CourseViewConsole;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestionCourse {
    private CourseDAO cm;
    private CourseController cc;
    private CourseAbstractView cv;

    public void gestion(){
        cm = new CourseModelDB();
        cv = new CourseViewConsole();
        cc = new CourseController(cm, cv);
        cm.addObserver(cv);
        List<String> loptions = Arrays.asList("courses", "fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: cv.menu();
                    break;
                case 2: System.exit(0);
            }
        }while(true);
    }
    public static void main(String[] args) {
        GestionCourse gc = new GestionCourse();
        gc.gestion();
    }
}

 */