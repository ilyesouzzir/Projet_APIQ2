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
            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));
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
                    return;
            }
        } while (true);
    }
    public void specialPilote() {
        update(piloteController.getAll());
        do {
            int ch = choixListe(Arrays.asList("ajouter un pilote", "supprimer un pilote", "rechercher un pilote", "mettre à jour un pilote", "lister les pilotes", "menu principal"));
            if(ch==6) return;
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

                default:
                    affMsg("Choix invalide");
            }
        } while (true);
    }

    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void modifier() {
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
        System.out.println("id_pilote : ");
        int idPilote = sc.nextInt();
        Pilote p = piloteController.search(idPilote);
        if(p == null) affMsg("recherche infructueuse");
        else affMsg(p.toString());
    }

    private void retirer() {
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