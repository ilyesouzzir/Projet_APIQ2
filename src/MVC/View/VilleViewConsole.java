package MVC.View;

import MVC.View.VilleAbstractView;
import metier.Pilote;
import metier.Ville;
import static utilitaires.Utilitaire.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VilleViewConsole extends VilleAbstractView {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        update(villeController.getAll());
        do {
            int ch = choixListe(Arrays.asList("ajouter une ville", "supprimer une ville", "rechercher une ville", "mettre à jour une ville","pilote sans doublon qui ont effectué une course", "menu principal"));
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
                case 5: PiloteSansDoublon();
                    return;
            }
        } while (true);
    }


    private List<Pilote> PiloteSansDoublon(){
        System.out.println("Veuillez entrer l'ID de la ville pour laquelle vous voulez trouver les pilotes : ");
        int idVille = sc.nextInt();
        List<Pilote> pilotes = villeController.getPilotesSansDoublon(idVille);
        if(pilotes.isEmpty()) {
            System.out.println("Aucun pilote n'a effectué une course dans cette ville.");
        } else {
            System.out.println("Les pilotes qui ont effectué une course dans cette ville sont : ");
            for (Pilote pilote : pilotes) {
                System.out.println(pilote.toString());
            }
        }
        return pilotes;
    }

    @Override
    public void affList(List l) {
        affListe(l);
    }

    private void modifier() {
        System.out.println("Veuillez entrer l'ID de la ville à modifier : ");
        int nl = choixElt(lv) - 1;
        Ville ville = lv.get(nl);
        String nom = modifyIfNotBlank("nom", ville.getNom());
        double latitude = Double.parseDouble(modifyIfNotBlank("latitude", "" + ville.getLatitude()));
        double longitude = Double.parseDouble(modifyIfNotBlank("longitude", "" + ville.getLongitude()));
        Ville v = villeController.updateVille(new Ville(ville.getId_ville(),nom, latitude, longitude));
        if(v == null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+v);
    }

    private void rechercher() {
        System.out.println("Veuillez entrer l'ID de la ville à rechercher : ");
        System.out.println("id_ville : ");
        int idVille = sc.nextInt();
        Ville v = villeController.search(idVille);
        if(v == null) affMsg("recherche infructueuse");
        else affMsg(v.toString());
    }

    private void retirer() {
        System.out.println("Veuillez entrer l'ID de la ville à supprimer : ");
        int nl = choixElt(lv) - 1;
        Ville ville = lv.get(nl);
        boolean ok = villeController.removeVille(ville);
        if(ok) affMsg("ville effacée");
        else affMsg("ville non effacée");
    }

    private void ajouter() {
        System.out.print("nom : ");
        String nom = sc.nextLine();
        System.out.print("latitude: ");
        double latitude = Double.parseDouble(sc.nextLine());
        System.out.print("longitude: ");
        double longitude = Double.parseDouble(sc.nextLine());
        Ville v = villeController.addVille(new Ville(nom, latitude, longitude));
        if(v != null) affMsg("création de :"+v);
        else affMsg("erreur de création");
    }

    @Override
    public Ville selectionner() {
        update(villeController.getAll());
        int nl = choixListe(lv);
        Ville ville = lv.get(nl - 1);
        return ville;
    }
}