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


    private void special(Course c, Pays p) {

        do {
            int choix = choixListe(Arrays.asList("Liste des pilotes avec place et gain", "Gain total de la course",
                    "Liste des pays des pilotes", "Vainqueur de la course", "Ajout d'un pilote à la course", "Retrait d'un pilote à la course",
                    "Enregistrement d'un résultat", "Modification d'un pilote", "Liste des coureurs du pays de la course", "Classement complet",
                    "Menu principal de course")
            );
            switch (choix) {
                //case 1 -> listePilotePlaceGain2(c);
                //case 2 -> gainTotal2(c);
                //case 3 -> ListePaysPilotes2(c);
                 //case 4 -> vainqueur2(c);
               case 5 -> addPilote2(c);
                case 6 -> supPilote2( c);
                case 7 -> resultat2(c);
                //case 8 -> modif2(c);
                case 9 -> ListePiloteDuPays2(c,p);
                //case 10 -> Classementcomplet2(c);
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

    public void addPilote2(Course c) {
        System.out.println("Ajout d'un pilote à la course : " + c.getNom());
        Pilote p = pv.selectionner();
        boolean ok = courseController.addPilote(p, c);
        if (ok) {
            affMsg("Pilote ajouté\n");
        } else {
            affMsg("Erreur lors de l'ajout du pilote\n");
        }
    }

    public void supPilote2(Course c) {
        System.out.println("Pilote à supprimer de la course (indiquer le n° de la ligne): ");
        Pilote p = pv.selectionner();
        if (p == null) {
            affMsg("Aucun pilote sélectionné. Opération annulée.");
            return;
        }
        try {
            courseController.supPilote(p, c);
            affMsg("pilote supprimé avec succès de la course\n");
        } catch (Exception e) {
            affMsg("Erreur lors de la suppression du pilote de la course: " + e.getMessage());
        }
    }

    private void ListePiloteDuPays2(Course c,Pays p) {
        List<Pilote> lp = courseController.ListePiloteDuPays(c,p);
        if (lp.isEmpty()) {
            affMsg("aucun pilote");
        } else {
            System.out.println("Liste des pilotes pour le pays de la course " + c.getNom() + " : ");
            affList(lp);
        }
    }
    public void modif2(Course c) {
        Pilote p = pv.selectionner();

        System.out.println("Nouvelle place : ");
        int place = lireInt();
        System.out.println("Nouveau gain : ");
        BigDecimal gain = sc.nextBigDecimal();
        boolean m = courseController.modif(p, place, gain, c);
        if (m) {
            affMsg("Modifié avec succès\n");
        } else {
            affMsg("Problème lors de la modification\n");
        }
    }
    public void resultat2(Course c) {
        Pilote p = pv.selectionner();
        System.out.println("Place : ");
        int place = lireInt();
        System.out.println("Gain : ");
        BigDecimal gain = sc.nextBigDecimal();
        Classement cl = courseController.resultat(p, place, gain, c);
        if (cl != null) {
            affMsg("Ajout du résultat du pilote avec succès\n");
        } else {
            affMsg("Problème lors de l'enregistrement du résultat\n");
        }
    }

    private void Classementcomplet2(Course course) {
        boolean cl = courseController.classementComplet(course);
        if (cl) {
            affMsg("Tous les pilotes inscrits ont une place\n");
        } else {
            affMsg("Des pilotes n'ont pas de place encore\n");
        }
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
            special(course, null);
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
        System.out.print("Nom de la course : ");
        String nom = sc.nextLine();
        int km;
        do {
            System.out.print("Km de la course : ");
            km = Integer.parseInt(sc.nextLine());
            if (km < 0) {
                System.err.println("Km doit être >= à 0");
            }
        } while (km < 0);
        System.out.print("Date de la course (format YYYY-MM-DD): ");
        LocalDate dateCourse = LocalDate.parse(sc.nextLine());
        BigDecimal priceMoney = null;
        do {
            System.out.print("PriceMoney : ");
            try {
                priceMoney = new BigDecimal(sc.nextLine());
                if (priceMoney.compareTo(BigDecimal.ZERO) < 0) {
                    System.err.println("PriceMoney doit etre >= à 0");
                }
            } catch (NumberFormatException e) {
                System.err.println("entrée invalide");
                priceMoney = null;
            }
        } while (priceMoney == null || priceMoney.compareTo(BigDecimal.ZERO) < 0);
        Course c = courseController.addCourse(new Course(0, nom, km, dateCourse, priceMoney));
        if (c != null) {
            affMsg("création de : " + c);
        } else {
            affMsg("erreur de création");
        }
    }
    @Override
    public Course selectionner() {
        int nl = choixListe(lc);
        Course course = lc.get(nl - 1);
        return course;
    }
}