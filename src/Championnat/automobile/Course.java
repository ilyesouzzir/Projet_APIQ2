package Championnat.automobile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Course {
    /**
     * Identifiant unique de la course.
     */
    protected int id_course;

    /**
     * Nom de la course.
     */
    protected String nom;

    /**
     * Distance de la course en kilomètres.
     */
    protected int km;

    /**
     * Date de la course.
     */
    protected LocalDate dateCourse;

    /**
     * Montant de la prime de la course.
     */
    protected BigDecimal priceMoney;

    /**
     * Ville où se déroule la course.
     */
    private Ville ville;

    /**
     * Liste des classements de la course.
     */
    private List<Classement> list_classement = new ArrayList<Classement>();

    /**
     * Liste des courses.
     */
    private List<Course> listeCourses = new ArrayList<Course>();

    /**
     * Liste des pilotes participant à la course.
     */
    protected List<Pilote> listePilotes = new ArrayList<Pilote>();

    // Constructeurs

    /**
     * Constructeur par défaut de la classe Course.
     */
    public Course() {
    }

    /**
     * Constructeur avec paramètres de la classe Course.
     *
     * @param id_course  L'identifiant de la course.
     * @param nom        Le nom de la course.
     * @param km         La distance de la course en kilomètres.
     * @param dateCourse La date de la course.
     * @param priceMoney Le montant de la prime de la course.
     */
    public Course(int id_course, String nom, int km, LocalDate dateCourse, BigDecimal priceMoney) {
        this.id_course = id_course;
        this.nom = nom;
        this.km = km;
        this.dateCourse = dateCourse;
        this.priceMoney = priceMoney;
    }

    // Méthodes publiques

    /**
     * Récupère l'identifiant de la course.
     *
     * @return L'identifiant de la course.
     */
    public int getId_course() {
        return id_course;
    }

    /**
     * Définit l'identifiant de la course.
     *
     * @param id_course L'identifiant de la course.
     */
    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    /**
     * Récupère le nom de la course.
     *
     * @return Le nom de la course.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la course.
     *
     * @param nom Le nom de la course.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère la distance de la course en kilomètres.
     *
     * @return La distance de la course en kilomètres.
     */
    public int getKm() {
        return km;
    }

    /**
     * Définit la distance de la course en kilomètres.
     *
     * @param km La distance de la course en kilomètres.
     */
    public void setKm(int km) {
        this.km = km;
    }

    /**
     * Récupère la date de la course.
     *
     * @return La date de la course.
     */
    public LocalDate getDateCourse() {
        return dateCourse;
    }

    /**
     * Définit la date de la course.
     *
     * @param dateCourse La date de la course.
     */
    public void setDateCourse(LocalDate dateCourse) {
        this.dateCourse = dateCourse;
    }

    /**
     * Récupère le montant de la prime de la course.
     *
     * @return Le montant de la prime de la course.
     */
    public BigDecimal getPriceMoney() {
        return priceMoney;
    }

    /**
     * Définit le montant de la prime de la course.
     *
     * @param priceMoney Le montant de la prime de la course.
     */
    public void setPriceMoney(BigDecimal priceMoney) {
        this.priceMoney = priceMoney;
    }

    /**
     * Récupère la liste des classements de la course.
     *
     * @return La liste des classements de la course.
     */
    public List<Classement> getList_classement() {
        return list_classement;
    }

    /**
     * Définit la liste des classements de la course.
     *
     * @param list_classement La liste des classements de la course.
     */
    public void setList_classement(List<Classement> list_classement) {
        this.list_classement = list_classement;
    }

    /**
     * Récupère la ville où se déroule la course.
     *
     * @return La ville où se déroule la course.
     */
    public Ville getVille() {
        return ville;
    }

    /**
     * Définit la ville où se déroule la course.
     *
     * @param ville La ville où se déroule la course.
     */
    public void setVille(Ville ville) {
        this.ville = ville;
    }

    /**
     * Récupère la liste des courses.
     *
     * @return La liste des courses.
     */
    public List<Course> getListeCourses() {
        return listeCourses;
    }

    /**
     * Définit la liste des courses.
     *
     * @param listeCourses La liste des courses.
     */
    public void setListeCourses(List<Course> listeCourses) {
        this.listeCourses = listeCourses;
    }

    /**
     * Récupère la liste des pilotes participant à la course.
     *
     * @return La liste des pilotes participant à la course.
     */
    public List<Pilote> getListePilotes() {
        return listePilotes;
    }

    /**
     * Définit la liste des pilotes participant à la course.
     *
     * @param listePilotes La liste des pilotes participant à la course.
     */
    public void setListePilotes(List<Pilote> listePilotes) {
        this.listePilotes = listePilotes;
    }

    /**
     * Ajoute un pilote à la liste des pilotes participant à la course.
     *
     * @param pilote Le pilote à ajouter.
     */
    public void addPilote(Pilote pilote) {
        listePilotes.add(pilote);
    }

    /**
     * Supprime un pilote de la liste des pilotes participant à la course.
     *
     * @param pilote Le pilote à supprimer.
     */
    public void supPilote(Pilote pilote) {
        listePilotes.remove(pilote);
    }

    /**
     * Calcule le gain total de la course.
     *
     * @return Le gain total de la course.
     */
    public BigDecimal gainTotal() {
        /**
         *  total de tous les gains pour la course
         */
        BigDecimal total = new BigDecimal(0);
        for (Classement cl : list_classement) {
            total = total.add(cl.gain);
        }
        return total;
    }

    /**
     * Renvoie le vainqueur de la course.
     *
     * @return Le vainqueur de la course.
     */
    public Pilote vainqueur() {
        for (Classement cl : list_classement) {
            if (cl.getPlace() == 1) {
                return cl.getPilote();
            }
        }
        System.out.println("Aucun vainqueur trouvé pour cette course.");
        return null;
    }

    /**
     * Affiche la liste des pilotes du pays de la course.
     */
    public void ListePiloteDuPays() {
        System.out.println("Liste des pilotes du pays de la course :");

        Pays paysCourse = ville.getPays();

        for (Pilote pilote : listePilotes) {
            if (paysCourse.equals(pilote.getPays())) {
                System.out.println("Nom: " + pilote.getNom() + ", Prénom: " + pilote.getPrenom());
            }
        }
    }

    /**
     * Affiche la liste des pilotes avec leur place et leur gain total.
     */
    public void listePilotePlaceGain() {
        System.out.println("Liste des pilotes avec leur place et leur gain :");
        /**
         * tri
         */
        list_classement.sort(Comparator.comparing(Classement::getPlace));

        for (Classement cl : list_classement) {
            /**
             * Récupère le pilote associé à ce classement
              */
            Pilote pilote = cl.getPilote();

            /**
             * Obtient la place du pilote dans la course à partir du classement
              */
            int place = cl.getPlace();


            System.out.println("Pilote: " + pilote.getNom() + " " + pilote.getPrenom() +
                    ", Place: " + place +
                    ", Gain du classement: " + cl.getGain());
        }


    }


    public boolean classementComplet() {
        /**
         * vérifie si le classement de la course est complet en comparant le nombre de pilotes participant à la course
         * avec le nombre de classements enregistrés pour cette course
         * Elle retourne true si tous les pilotes ont un classement enregistré, c'est-à-dire si le nombre de pilotes est égal au nombre de classements.
         * Sinon, elle retourne false, indiquant que le classement n'est pas complet.
          */

        return listePilotes.size() == list_classement.size();
    }


    /**
     * Modifie le classement d'un pilote dans la course.
     *
     * @param pilote Le pilote dont le classement doit être modifié.
     * @param place  La nouvelle place du pilote dans la course.
     * @param gain   Le gain associé au nouveau classement du pilote.
     */
    public void modif(Pilote pilote, int place, BigDecimal gain) {
        /**
         *  Recherche du pilote dans la liste du classement de la course
         */
        for (Classement cl : list_classement) {
            if (cl.getPilote().equals(pilote)) {
                /**
                 * Mettre à jour le classement existant si le pilote est déjà classé
                  */
                cl.setPlace(place);
                cl.setGain(gain);
                return;
            }
        }
    }

    /**
     * Affiche le résultat d'un pilote dans la course.
     *
     * @param pilote Le pilote dont le résultat doit être affiché.
     * @param place  La place du pilote dans la course.
     * @param gain   Le gain associé au résultat du pilote.
     */
    public void resultat(Pilote pilote, int place, BigDecimal gain) {
        Classement classement = new Classement();
        classement.setPilote(pilote);
        classement.setPlace(place);
        classement.setGain(gain);
        this.list_classement.add(classement);


    }

    /**
     * Renvoie la liste des pays des pilotes participant à la course.
     *
     * @return La liste des pays des pilotes.
     */
    public List<Pays> listePaysPilotes() {
        List<Pays> paysPilotes = new ArrayList<>();

        /**
         * Parcourir de la liste des pilotes
          */
        for (Pilote pilote : listePilotes) {
            Pays paysPilote = pilote.getPays();
            boolean paysExiste = false;

            /**
             *  Vérifie si le pays du pilote existe déjà dans la liste
              */
            for (Pays pays : paysPilotes) {
                if (pays.equals(paysPilote)) {
                    paysExiste = true;
                    break;
                }
            }

            /**
             * Si le pays du pilote n'existe pas déjà dans la liste, on l'ajoute
              */
            if (!paysExiste) {
                paysPilotes.add(paysPilote);
            }
        }

        return paysPilotes;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id_course=" + id_course +
                ", nom='" + nom + '\'' +
                ", km=" + km +
                ", dateCourse=" + dateCourse +
                ", priceMoney=" + priceMoney +
                '}';
    }

}
