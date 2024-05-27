package MVC;

import MVC.Controller.CourseController;
import MVC.Controller.PaysController;
import MVC.Controller.PiloteController;
import MVC.Controller.VilleController;
import MVC.Model.*;
import MVC.View.*;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;

public class GestCourseDemo {
    private DAOCourse cm;
    private DAOPilote pm;
    private DAOVille vm;
    private DAOPays pym;
    private CourseController cc;
    private PiloteController pc;
    private VilleController vc;
    private PaysController pyc;
    private CourseAbstractView cv;
    private PiloteAbstractView pv;
    private VilleAbstractView vv;
    private PaysAbstractView pyv;

    public void gestion(){
        cm = new CourseModelDB();
        pm = new PiloteModelDB();
        vm = new VilleModelDB();
        pym = new PaysModelDB();
        cv = new CourseViewConsole();
        pv = new PiloteViewConsole();
        vv = new VilleViewConsole();
        pyv = new PaysViewConsole();

        cc = new CourseController(cm,cv);
        pc = new PiloteController(pm,pv);
        vc = new VilleController(vm,vv);
        pyc = new PaysController(pym,pyv);

        cm.addObserver(cv);
        pm.addObserver(pv);
        vm.addObserver(vv);
        pym.addObserver(pyv);

        List<String> loptions = Arrays.asList("courses","pilotes","ville","pays","fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch){
                case 1: cv.specialCourse();
                    break;
                case 2: pv.specialPilote();
                    break;
                case 3: vv.specialVille();
                    break;
                case 4: pyv.specialPays();
                    break;
                case 5: System.exit(0);
            }
        }while(true);
    }
    public static void main(String[] args) {
        GestCourseDemo gcd = new GestCourseDemo();
        gcd.gestion();
    }
}