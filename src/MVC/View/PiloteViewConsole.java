/*
package MVC.View;

import metier.Pilote;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;


public class PiloteViewConsole extends PiloteAbstractView {
    private Scanner sc = new Scanner(System.in);

    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }
    public void affList(List infos) {
        affListe(infos);
    }
    @Override
    public void menu() {
        update(piloteController.getAll());
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
        int nl = choixElt(lp);

        Pilote pilote = lp.get(nl-1);
        String nom = modifyIfNotBlank("nom du pilote", pilote.getNom());
        String prenom = modifyIfNotBlank("prenom du pilote", pilote.getPrenom());

        Pilote piloteMaj = piloteController.updatePilote(new Pilote(pilote.getId_pilote(), nom, prenom));
        if(piloteMaj == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+piloteMaj);
    }

    private void rechercher() {
        System.out.println("idPilote : ");
        int idPilote = sc.nextInt();
        piloteController.search(idPilote);
    }

    private void retirer() {
        int nl = choixElt(lp);
        Pilote pilote = lp.get(nl-1);
        boolean ok = piloteController.removePilote(pilote);
        if(ok) affMsg("pilote effacé");
        else affMsg("pilote non effacé");
    }

    private void ajouter() {
        System.out.print("nom du pilote : ");
        String nom = sc.nextLine();
        System.out.print("prenom du pilote : ");
        String prenom = sc.nextLine();

        Pilote pilote = piloteController.addPilote(new Pilote(0, nom, prenom));
        if(pilote != null) affMsg("création de :"+pilote);
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

 */