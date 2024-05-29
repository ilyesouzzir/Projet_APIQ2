package metier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Course {
    /**
     * compteur d'incrementation pour l'identifiant idClassement
     */
    protected static int id_act = 1;
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

    public List<Classement> listePilotePlaceGain() {
        /**
         *  Tri des classements grace au tri séléction que j'ai appliqué
          */

        triSelection(list_classement);

        /**
         * Retourner simplement la liste des classements triés
          */
        
        return list_classement;
    }
    /**
     * Trie une liste de classement par ordre croissant en utilisant l'algorithme de tri par sélection.
     *
     * @param list La liste de classement à trier.
     */
    public void triSelection(List<Classement> list) {
        int n = list.size();

        /**
         *  Parcours de tous les éléments sauf le dernier
          */

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getPlace() < list.get(minIndex).getPlace()) {
                    minIndex = j;
                }
            }
            /**
             *  Échange des éléments pour placer le minimum à la bonne position
              */

            Classement temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
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
     * methode qui cherche tous les pays des pilotes qui participent Ã
     la course et les stocke 1 seule fois
     * @return liste la liste des pays
     */
    public List<Pays> listePaysPilotes() {
        List<Pays> listePays= new ArrayList<>();
        /**
         * Parcourir de la liste des classements
         */
        for (Classement c : list_classement) {
            /**
             * Récupère le pays du pilote
             */
            Pays pays = c.Pilote.pays;
            /**
             * vérifie si le pays est déja présent dans la liste
             */
            if (!listePays.contains(pays)) {
                listePays.add(pays);
            }
        }
        return listePays;
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
     * Ajoute un classement correspondant à un pilote spécifié.
     *
     * @param pilote Le pilote pour lequel un classement doit être ajouté.
     */
    public void addPilote(Pilote pilote) {
        /**
         * Crée un nouveau classement pour le pilote spécifié et l'ajoute à la liste de classement.
         */
        Classement nvPilote = new Classement();
        nvPilote.setPilote(pilote);
        list_classement.add(nvPilote);
    }

    /**
     * Supprime le classement du pilote spécifié.
     *
     * @param pilote
     * Le pilote dont le classement doit être supprimé.
     */
    public void supPilote(Pilote pilote) {
        /**
         * Cherche le pilote dans le classement et supprime son classement s'il est trouvé.
         */
        for (Classement cl : list_classement) {
            if (cl.getPilote().equals(pilote)) {
                list_classement.remove(cl);
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
    public Classement resultat(Pilote pilote, int place, BigDecimal gain) {
        Classement classement = new Classement();
        classement.setPilote(pilote);
        classement.setPlace(place);
        /**
         * si le pilote abandonne sa place vaudra -1
          */
        if (place == -1) {
            System.out.println("Le pilote " + pilote.getNom() + " a abandonné la course.");
        }
        classement.setGain(gain);
        this.list_classement.add(classement);

        return classement;
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
                 * Mettre Ã  jour le classement existant si le pilote
                 est dÃ©jÃ  classÃ©
                 */
                cl.setPlace(place);
                cl.setGain(gain);
                return;
            }

        }
    }
    /**
     * Affiche la liste des pilotes du pays de la course et retourne cette liste.
     *
     * @return La liste des pilotes du pays de la course.
     */
    public List<Pilote> ListePiloteDuPays() {
        System.out.println("Liste des pilotes du pays de la course :");
        Pays paysCourse = ville.getPays();
        List<Pilote> listePilote = new ArrayList<>();
        for (Classement cl : list_classement) {
            Pays pays = cl.getPilote().getPays();
            if (paysCourse.equals(pays)) {
                listePilote.add(cl.getPilote());
            }
        }
        return listePilote;
    }

    /**
     * Vérifie si le classement est complet en parcourant tous les éléments du classement.
     * Un classement est considéré comme complet si toutes les places sont attribuées.
     *
     * @return true si le classement est complet, sinon false.
     */
    public boolean classementComplet() {
        for (Classement cl : list_classement) {
            if (cl.getPlace() == 0) {
                return false;
            }
        }

        return true;
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
