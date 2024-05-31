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

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(courseController.getAll());
        do {
            int ch = choixListe(Arrays.asList("ajouter une course", "supprimer une course", "rechercher une course", "mettre à jour une course", "lister les courses", "retour au menu principal"));
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


    public void special(Course course) {
        do {
            int ch = choixListe(Arrays.asList("Liste Pilote Place Gain", "Gain Total", "Liste Pays Pilotes", "Vainqueur", "Add Pilote", "Sup Pilote", "Resultat", "Modif", "Liste Pilote Du Pays", "Classement Complet", "menu principal"));
            if(ch==11) return;
            List l = switch (ch) {
                case 1 -> List.of(courseController.gainTotal());
                // Add cases for other possible values here
                // case 2 -> ...
                // case 3 -> ...
                // ...
                // case 10 -> ...
                default -> {
                    affMsg("Invalid choice. Please try again.");
                    yield null;
                }
            };
            if(l==null || l.isEmpty()) affMsg("aucun élément trouvée");
            else affList(l);
        } while (true);
    }


    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void modifier() {
        System.out.println("Veuillez entrer l'ID du cours à modifier : ");
        int nl = choixElt(lc) - 1;
        Course course = lc.get(nl);
        String nom = modifyIfNotBlank("nom", course.getNom());
        int km = Integer.parseInt(modifyIfNotBlank("km", "" + course.getKm()));
        LocalDate dateCourse = LocalDate.parse(modifyIfNotBlank("dateCourse", course.getDateCourse().toString()));
        BigDecimal priceMoney = new BigDecimal(modifyIfNotBlank("priceMoney", course.getPriceMoney().toString()));
        Course c = courseController.updateCourse(new Course(course.getId_course(), nom, km, dateCourse, priceMoney));
        if (c == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : " + c);
    }

    private void rechercher() {
        System.out.println("Veuillez entrer l'ID du cours à rechercher : ");
        System.out.println("idcourse : ");
        int idCourse = sc.nextInt();
        Course course = courseController.search(idCourse);
        if (course == null) affMsg("recherche infructueuse");
        else affMsg(course.toString());
    }

    private void retirer() {
        System.out.println("Veuillez entrer l'ID du cours à supprimer : ");
        int nl = choixElt(lc) - 1;
        Course course = lc.get(nl);
        boolean ok = courseController.removeCourse(course);
        if (ok) affMsg("course effacée");
        else affMsg("course non effacée");
    }

    private void ajouter() {
        System.out.print("nom : ");
        String nom = sc.nextLine();
        System.out.print("km: ");
        int km = Integer.parseInt(sc.nextLine());
        System.out.print("dateCourse (format YYYY-MM-DD): ");
        LocalDate dateCourse = LocalDate.parse(sc.nextLine());
        System.out.print("priceMoney: ");
        BigDecimal priceMoney = new BigDecimal(sc.nextLine());
        Course c = courseController.addCourse(new Course(0, nom, km, dateCourse, priceMoney));
        if (c != null) affMsg("création de :" + c);
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