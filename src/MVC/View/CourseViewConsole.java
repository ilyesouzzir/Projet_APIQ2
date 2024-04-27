package MVC.View;

import MVC.Controller.CourseController;
import metier.Course;
import static utilitaires.Utilitaire.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseViewConsole extends CourseAbstractView {
    private Scanner sc = new Scanner(System.in);
    private CourseController courseController;

    public CourseViewConsole(CourseController courseController) {
        this.courseController = courseController;
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(courseController.getAll());
        do {
            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));
            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void modifier() {
        int nl = choixElt(lc) - 1;
        Course course = lc.get(nl);
        String nom = modifyIfNotBlank("nom", course.getNom());
        int km = Integer.parseInt(modifyIfNotBlank("km", "" + course.getKm()));
        LocalDate dateCourse = LocalDate.parse(modifyIfNotBlank("dateCourse", "" + course.getDateCourse()));
        BigDecimal priceMoney = new BigDecimal(modifyIfNotBlank("priceMoney", "" + course.getPriceMoney()));
        Course c = courseController.updateCourse(new Course(course.getId_course(), nom, km, dateCourse, priceMoney));
        if(c == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+c);
    }

    private void rechercher() {
        System.out.println("id_course : ");
        int idCourse = sc.nextInt();
        Course c = courseController.search(idCourse);
        if(c == null) affMsg("recherche infructueuse");
        else affMsg(c.toString());
    }

    private void retirer() {
        int nl = choixElt(lc) - 1;
        Course course = lc.get(nl);
        boolean ok = courseController.removeCourse(course);
        if(ok) affMsg("course effacée");
        else affMsg("course non effacée");
    }

    private void ajouter() {
        System.out.print("nom : ");
        String nom = sc.nextLine();
        System.out.print("km: ");
        int km = sc.nextInt();
        System.out.print("dateCourse (YYYY-MM-DD): ");
        LocalDate dateCourse = LocalDate.parse(sc.next());
        System.out.print("priceMoney: ");
        BigDecimal priceMoney = sc.nextBigDecimal();
        Course c = courseController.addCourse(new Course(0, nom, km, dateCourse, priceMoney));
        if(c != null) affMsg("création de :"+c);
        else affMsg("erreur de création");
    }

    @Override
    public Course selectionner() {
        update(courseController.getAll());
        int nl = choixListe(lc);
        Course course = lc.get(nl - 1);
        return course;
    }
}