/*
package MVC.View;

import metier.Pays;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;


public class PaysViewConsole extends PaysAbstractView {
    private Scanner sc = new Scanner(System.in);

    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }
    public void affList(List infos) {
        affListe(infos);
    }
    @Override
    public void menu() {
        update(paysController.getAll());
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

        Pays pays = lp.get(nl-1);
        String nom = modifyIfNotBlank("nom du pays", pays.getNom());
;

        Pays paysMaj = paysController.updatePays(new Pays(pays.getId_pays(), pays.getNom());
        if(paysMaj == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+paysMaj);
    }

    private void rechercher() {
        System.out.println("idPays : ");
        int idPays = sc.nextInt();
        paysController.search(idPays);
    }

    private void retirer() {
        int nl = choixElt(lp);
        Pays pays = lp.get(nl-1);
        boolean ok = paysController.removePays(pays);
        if(ok) affMsg("pays effacé");
        else affMsg("pays non effacé");
    }

    private void ajouter() {
        System.out.print("nom du pays : ");
        String nom = sc.nextLine();


        Pays pays = paysController.addPays(new Pays(0, nom));
        if(pays != null) affMsg("création de :"+pays);
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

 */