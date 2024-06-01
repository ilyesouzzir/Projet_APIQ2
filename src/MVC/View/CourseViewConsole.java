package MVC.View;


import metier.Classement;
import metier.Course;
import metier.Pays;
import metier.Pilote;


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


    private void special(Course c, Pilote pilote, Pays pays) {
        do {
            int choix = choixListe(Arrays.asList("Liste des pilotes avec place et gain", "Gain total de la course",
                    "Liste des pays des pilotes", "Vainqueur de la course", "Ajout d'un pilote à la course", "Retrait d'un pilote à la course",
                    "Enregistrement d'un résultat", "Modification d'un pilote", "Liste des coureurs du pays de la course", "Classement complet",
                    "Menu principal de course")
            );
            switch (choix) {
              //ok  case 1 -> listePilotePlaceGain2(c);
              //ok  case 2 -> gainTotal2(c);
             //ok   case 3 -> ListePaysPilotes2(c);
                // case 4 -> vainqueur2(c);
               case 5 -> addPilote2(pilote);
                case 6 -> supPilote2(pilote, c);
                case 7 -> resultat2(pilote, 0, null, c);
                case 8 -> modif2(pilote, 0, null, c);
                case 9 -> ListePiloteDuPays2(c, pays);
          //ok      case 10 -> Classementcomplet2(c);
            }
        } while (true);
    }


    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void listePilotePlaceGain2(Course c) {
        List<Classement> lp = courseController.listePilotePlaceGain(c);
        if (lp.isEmpty()) {
            affMsg("aucun pilote");
        } else {
            affMsg("Liste des pilotes avec place et gain");
            affList(lp);
        }
    }

    private void gainTotal2(Course c) {
        BigDecimal gainTotal = courseController.gainTotal(c);
        if (gainTotal == null || gainTotal.compareTo(BigDecimal.ZERO) == 0) {
            affMsg("aucun gain");
        } else {
            affMsg("Gain total de la course : " + gainTotal);
        }
    }

    private void ListePaysPilotes2(Course c) {
        List<Pays> lp = courseController.listePaysPilotes(c);
        if (lp.isEmpty()) {
            affMsg("aucun pays");
        } else {
            affMsg("Liste des pays des pilotes");
            affList(lp);
        }
    }

    private void vainqueur2(Course c) {
        Pilote pilote = courseController.vainqueur(c);
        if (pilote == null) {
            affMsg("aucun vainqueur");
        } else {
            affMsg("Vainqueur de la course : " + pilote);
        }
    }

    private void addPilote2(Pilote pilote) {
        courseController.addPilote(pilote);
        try {
            affMsg("Pilote ajouté");
        } catch (Exception e) {
            affMsg("Erreur d'ajout de pilote");
        }
    }

    private void supPilote2(Pilote pilote, Course course) {
        courseController.supPilote(pilote, course);
        try {
            courseController.supPilote(pilote, course);
            affMsg("Pilote supprimé");
        } catch (Exception e) {
            affMsg("Erreur de suppression de pilote");
        }
    }

    private void ListePiloteDuPays2(Course c, Pays pays) {
        List<Pilote> lp = courseController.ListePiloteDuPays(c, pays);
        if (lp.isEmpty()) {
            affMsg("aucun pilote");
        } else {
            affMsg("Liste des coureurs du pays de la course");
            affList(lp);
        }
    }
  private void modif2(Pilote pilote, int place, BigDecimal gain, Course course) {
        courseController.modif(pilote, place, gain, course);

    }
    private void resultat2(Pilote pilote, int place, BigDecimal gain, Course course) {
        Classement cl = courseController.resultat(pilote, place, gain, course);
        if (cl != null) {
            System.out.println("Ajout du résultat du pilote avec succès\n");
        } else {
            System.out.println("Problème lors de l'enregistrement du résultat\n");
        }
    }
    private boolean Classementcomplet2(Course c) {
        List<Classement> lp = courseController.listePilotePlaceGain(c);
        if (lp.isEmpty()) {
            affMsg("aucun pilote");
        } else {
            affMsg("Liste des pilotes avec place et gain");
            affList(lp);
        }
        return true;
    }

    private void modifier() {
        System.out.println("Veuillez entrer l'ID de la course à modifier : ");
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
        System.out.println("Veuillez entrer l'ID de la course à rechercher : ");
        System.out.println("idcourse : ");
        int idCourse = sc.nextInt();
        Course course = courseController.search(idCourse);
        if (course == null) affMsg("recherche infructueuse");
        else {
            affMsg(course.toString());
            special(course, null, null);
        }
    }

    private void retirer() {
        System.out.println("Veuillez entrer l'ID de la course à supprimer : ");
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