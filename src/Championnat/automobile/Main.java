package Championnat.automobile;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;
        System.out.println("Salut");

        // Création d'une instance de Course
        Course Coureur = new Course(1, "Course de test", 100, LocalDate.now(), BigDecimal.valueOf(1000));

        do {
            System.out.println("Bienvenue dans le gestionnaire du championnat automobile !");
            System.out.println("1. ");
            System.out.println("2. Afficher les pilotes");
            System.out.println("3.");
            System.out.println("4. ");
            System.out.println("5. Ajouter un coureur/pilote ");
            System.out.println("6.Supprimer un coureur/pilote ");
            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    // Appeler la méthode pour afficher les équipes
                    break;
                case 2:
                    // Appeler la méthode pour afficher les pilotes
                    afficherListePilotes(Coureur);
                    break;
                case 3:
                    // Appeler la méthode pour afficher le classement
                    break;
                case 4:
                    // Appeler la méthode pour ajouter une équipe
                    break;
                case 5:
                    // Appeler la méthode pour ajouter un pilote
                    ajouterPilote(Coureur);
                    break;
                case 6:supprimerPilote(Coureur);
                    // Appeler la méthode pour enregistrer un résultat de course
                    break;
                case 0:
                    System.out.println("Merci d'avoir utilisé le gestionnaire du championnat automobile. Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);
    }

    // Méthode pour ajouter un pilote à une course
    public static void ajouterPilote(Course Coureur) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ajout d'un pilote à la course :");

        System.out.print("Entrez l'ID du pilote : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        System.out.print("Entrez le matricule du pilote : ");
        String matricule = scanner.nextLine();

        System.out.print("Entrez le nom du pilote : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le prénom du pilote : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez l'année de naissance du pilote : ");
        int anneeNaissance = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        System.out.print("Entrez le mois de naissance du pilote (1-12) : ");
        int moisNaissance = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        System.out.print("Entrez le jour de naissance du pilote (1-31) : ");
        int jourNaissance = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        // Création de l'objet LocalDate pour la date de naissance du pilote
        LocalDate dateNaissance = LocalDate.of(anneeNaissance, moisNaissance, jourNaissance);

        // Création de l'objet Pilote avec les données entrées par l'utilisateur
        Pilote pilote = new Pilote(id, matricule, nom, prenom, dateNaissance);

        // Ajout du pilote à la course
        Coureur.addCoureur(pilote);

        System.out.println("Pilote ajouté avec succès à la course !");

    }

    // Méthode pour afficher la liste des pilotes de la course
    public static void afficherListePilotes(Course Coureur) {
        System.out.println("Liste des pilotes de la course :");
        for (Pilote pilote : Coureur.listePilotes) {
            System.out.println(pilote.getNom() + " " + pilote.getPrenom() + " (ID: " + pilote.getId_pilote() + ")");
        }
    }
    // Méthode pour supprimer un pilote d'une course
    public static void supprimerPilote(Course Coureur) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Suppression d'un pilote de la course :");
        afficherListePilotes(Coureur);

        System.out.print("Entrez l'ID du pilote à supprimer : ");
        int idPiloteASupprimer = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        // Recherche du pilote dans la liste des pilotes de la course
        Pilote piloteASupprimer = null;
        for (Pilote pilote : Coureur.listePilotes) {
            if (pilote.getId_pilote() == idPiloteASupprimer) {
                piloteASupprimer = pilote;
            }
        }

        // Suppression du pilote s'il est trouvé
        if (piloteASupprimer != null) {
            Coureur.supCoureur(piloteASupprimer);
            System.out.println("Le pilote a été supprimé avec succès de la course.");
        } else {
            System.out.println("Aucun pilote trouvé avec l'ID spécifié.");
        }
    }


}
