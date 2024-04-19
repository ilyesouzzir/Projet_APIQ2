/*
package MVC.View;

import metier.Ville;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;


public class VilleViewConsole extends VilleAbstractView {
    private Scanner sc = new Scanner(System.in);

    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }
    public void affList(List infos) {
        affListe(infos);
    }
    @Override
    public void menu() {
        update(villeController.getAll());
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
        int nl = choixElt(lv);

        Ville ville = lv.get(nl-1);
        String nom = modifyIfNotBlank("nom de la ville", ville.getNom());

        Ville villeMaj = villeController.updateVille(new Ville(ville.getId_ville(), nom));
        if(villeMaj == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+villeMaj);
    }

    private void rechercher() {
        System.out.println("idVille : ");
        int idVille = sc.nextInt();
        villeController.search(idVille);
    }

    private void retirer() {
        int nl = choixElt(lv);
        Ville ville = lv.get(nl-1);
        boolean ok = villeController.removeVille(ville);
        if(ok) affMsg("ville effacée");
        else affMsg("ville non effacée");
    }

    private void ajouter() {
        System.out.print("nom de la ville : ");
        String nom = sc.nextLine();

        Ville ville = villeController.addVille(new Ville(0, nom));
        if(ville != null) affMsg("création de :"+ville);
        else affMsg("erreur de création");
    }

    @Override
    public Ville selectionner() {
        update(villeController.getAll());
        int nl = choixListe(lv);
        Ville ville = lv.get(nl - 1);
        return ville;
    }
}*

 */