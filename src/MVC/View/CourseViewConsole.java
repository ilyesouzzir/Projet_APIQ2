/*
package MVC.View;

import metier.Course;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;


public class CourseViewConsole extends CourseAbstractView {
    private Connection dbConnect;

    private Scanner sc = new Scanner(System.in);

    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }
    public void affList(List infos) {
        affListe(infos);
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




    private void modifier() {
        int nl = choixElt(lc);

        Course course = lc.get(nl-1);
        String nom = modifyIfNotBlank("nom de la course", course.getNom());
        int km = Integer.parseInt(modifyIfNotBlank("km", ""+course.getKm()));
        LocalDate dateCourse = LocalDate.parse(modifyIfNotBlank("date de la course", course.getDateCourse().toString()));
        BigDecimal priceMoney = new BigDecimal(modifyIfNotBlank("priceMoney", ""+course.getPriceMoney()));

        Course courseMaj = courseController.updateCourse(new Course(course.getId_course(), nom, km, dateCourse, priceMoney));
        if(courseMaj == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+courseMaj);
    }

    private void rechercher() {
        System.out.println("idCourse : ");
        int idCourse = sc.nextInt();
        courseController.search(idCourse);
    }


    private void retirer() {
        int nl = choixElt(lc);
        Course course = lc.get(nl-1);
        boolean ok = courseController.removeCourse(course);
        if(ok) affMsg("course effacée");
        else affMsg("course non effacée");
    }

    private void ajouter() {
        System.out.print("nom de la course : ");
        String nom = sc.nextLine();
        System.out.print("km : ");
        int km = Integer.parseInt(sc.nextLine());
        System.out.print("date de la course (format: yyyy-mm-dd) : ");
        LocalDate dateCourse = LocalDate.parse(sc.nextLine());
        System.out.print("priceMoney : ");
        BigDecimal priceMoney = new BigDecimal(sc.nextLine());

        Course course = courseController.addCourse(new Course(0, nom, km, dateCourse, priceMoney));
        if(course != null) affMsg("création de :"+course);
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

 */
