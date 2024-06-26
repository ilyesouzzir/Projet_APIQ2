package MVC.View;

import MVC.View.PaysAbstractView;
import metier.Pays;
import metier.Pilote;

import static utilitaires.Utilitaire.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PaysViewConsole extends PaysAbstractView {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(paysController.getAll());
        do {
            int ch = choixListe(Arrays.asList("ajouter un pays", "supprimer un pays", "rechercher un pays", "mettre à jour un pays", "lister les pays", "menu principal"));
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
    public void special(Pays p) {
        do {
            int choix = choixListe(Arrays.asList("Liste des pilotes du pays", "Menu principal"));
            switch (choix) {
                case 1 -> listePilotes(p);
                case 2 -> {
                    return;
                }
            }
        } while (true);
    }
    public void listePilotes(Pays pays) {
        List<Pilote> liste = paysController.listePilotes(pays);
        if (liste.isEmpty()) {
            System.out.println("La liste est null\n");
        } else {
            System.out.println("Liste des pilotes du pays " + pays.getNom() + " : ");
            System.out.println(liste);
        }
    }

    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void modifier() {
        System.out.println("Veuillez entrer l'ID du pays à modifier : ");
        int nl = choixElt(lp) - 1;
        Pays pays = lp.get(nl);
        String sigle = modifyIfNotBlank("sigle", pays.getSigle());
        String nom = modifyIfNotBlank("nom", pays.getNom());
        String langue = modifyIfNotBlank("langue", pays.getLangue());
        Pays p = paysController.updatePays(new Pays(pays.getId_pays(),sigle, nom, langue));
        if(p == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+p);
    }

    private void rechercher() {
        System.out.println("Veuillez entrer l'ID du pays à rechercher : ");
        System.out.println("id_pays : ");
        int idPays = sc.nextInt();
        sc.nextLine();

        Pays p = paysController.search(idPays);
        if(p == null) affMsg("recherche infructueuse");
        else affMsg(p.toString());
        special(p);
    }

    private void retirer() {
        System.out.println("Veuillez entrer l'ID du pays à supprimer : ");
        int nl = choixElt(lp) - 1;
        Pays pays = lp.get(nl);
        boolean ok = paysController.removePays(pays);
        if(ok) affMsg("pays effacé");
        else affMsg("pays non effacé");
    }

    private void ajouter() {
        System.out.print("sigle : ");
        String sigle = sc.nextLine();
        System.out.print("nom: ");
        String nom = sc.nextLine();
        System.out.print("langue: ");
        String langue = sc.nextLine();
        Pays p = paysController.addPays(new Pays(sigle, nom, langue));
        if(p != null) affMsg("création de :"+p);
        else affMsg("erreur de création");
    }

    @Override
    public Pays selectionner() {
        update(paysController.getAll());
        int nl = choixListe(lp);
        Pays pays = lp.get(nl - 1);
        return pays;
    }
}