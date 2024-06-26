package MVC.View;

import MVC.View.PiloteAbstractView;
import metier.Pilote;
import static utilitaires.Utilitaire.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PiloteViewConsole extends PiloteAbstractView {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(piloteController.getAll());
        do {
            int ch = choixListe(Arrays.asList("ajouter un pilote", "supprimer un pilote", "rechercher un pilote", "mettre à jour un pilote", "lister les pilotes","Gain total d'un pilote toutes courses confondues", "menu principal"));
            switch (ch) {
                case 1:
                    update(piloteController.getAll());
                    ajouter();
                    break;
                case 2:
                    update(piloteController.getAll());
                    retirer();
                    break;
                case 3:
                    update(piloteController.getAll());
                    rechercher();
                    break;
                case 4:
                    update(piloteController.getAll());
                    modifier();
                    break;
                case 5:affList(piloteController.getAll());
                break;
                case 6: getTotalGains();
                    return;
            }
        } while (true);
    }


    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void getTotalGains(){
        System.out.println("Veuillez entrer l'ID du pilote pour obtenir le total des gains : ");
        int idPilote = sc.nextInt();
        int totalGains = piloteController.getTotalGains(idPilote);
        System.out.println("Le total des gains pour le pilote avec l'ID " + idPilote + " est : " + totalGains);
    }
    private void modifier() {
        System.out.println("Veuillez entrer l'ID du pilote à modifier : ");
        int nl = choixElt(lp) - 1;
        Pilote pilote = lp.get(nl);
        String matricule = modifyIfNotBlank("matricule", pilote.getMatricule());
        String nom = modifyIfNotBlank("nom", pilote.getNom());
        String prenom = modifyIfNotBlank("prenom", pilote.getPrenom());
        LocalDate datenaiss = LocalDate.parse(modifyIfNotBlank("datenaiss", pilote.getDatenaiss().toString()));
        Pilote p = piloteController.updatePilote(new Pilote(pilote.getId_pilote(), matricule, nom, prenom, datenaiss));
        if(p == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+p);
    }

    private void rechercher() {
        System.out.println("Veuillez entrer l'ID du pilote à rechercher : ");
        int idPilote = sc.nextInt();
        Pilote p = piloteController.search(idPilote);
        if(p == null) affMsg("recherche infructueuse");
        else affMsg(p.toString());
    }

    private void retirer() {
        System.out.println("Veuillez entrer l'ID du pilote à supprimer : ");
        int nl = choixElt(lp) - 1;
        Pilote pilote = lp.get(nl);
        boolean ok = piloteController.removePilote(pilote);
        if(ok) affMsg("pilote effacé");
        else affMsg("pilote non effacé");
    }

    private void ajouter() {
        System.out.print("matricule : ");
        String matricule = sc.nextLine();
        System.out.print("nom : ");
        String nom = sc.nextLine();
        System.out.print("prenom: ");
        String prenom = sc.nextLine();
        System.out.print("datenaiss: ");
        LocalDate datenaiss = LocalDate.parse(sc.nextLine());
        Pilote p = piloteController.addPilote(new Pilote(0, matricule, nom, prenom, datenaiss));
        if(p != null) affMsg("création de :"+p);
        else affMsg("erreur de création");
    }

    @Override
    public Pilote selectionner() {
        update(piloteController.getAll());
        int nl = choixListe(lp);
        Pilote pilote = lp.get(nl - 1);
        return pilote;
    }
}