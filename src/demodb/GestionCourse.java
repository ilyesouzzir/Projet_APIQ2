package demodb;

import myconnections.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class GestionCourse {
    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;
    private int id_act = 1;

    public static void main(String[] args) {
        GestionCourse gestionCourse = new GestionCourse();
        gestionCourse.gestion();
    }

    public void gestion() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        do {
            System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.tous\n6.fin");
            System.out.println("choix : ");
            int ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2 :recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                   tous();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);

    }

    public void ajout() {
        System.out.println("nom course : ");
        String nom_course = sc.nextLine();
        System.out.println("km de la course : ");
        int km = sc.nextInt();
        System.out.println("date de la course : ");
        System.out.println("année : ");
        int annee = sc.nextInt();
        System.out.println("mois : ");
        int mois = sc.nextInt();
        System.out.println("jour : ");
        int jour = sc.nextInt();
        LocalDate dateCourse = LocalDate.of(annee, mois, jour);
        System.out.println("priceMoney  : ");
        BigDecimal priceMoney = sc.nextBigDecimal();

        String query1 = "insert into APICourse( NOM, KM, DATECOURSE, PRICEMONEY) values(?,?,?,?)";
        String query2 = "select IDCOURSE from APICOURSE where NOM= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, nom_course);
            pstm1.setInt(2, km);
            pstm1.setDate(3, Date.valueOf(dateCourse));
            pstm1.setBigDecimal(4, priceMoney);
            int nvl = pstm1.executeUpdate();
            System.out.println(nvl + " course insérée");
            if(nvl == 1) {
                pstm2.setString(1, nom_course);
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int IDCOURSE= rs.getInt(1);
                    System.out.println("IDCOURSE = "+IDCOURSE);
                }
                else System.out.println("record introuvable");
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }
    public void modification() {
        System.out.println("id de la course modifiée : ");
        int idrech_course = sc.nextInt();
        sc.skip("\n");
        System.out.println("nouveau nom de la course : ");
        String ncourse = sc.nextLine();
        System.out.println("nouveau km de la course : ");
        int km = sc.nextInt();
        System.out.println("nouvelle date de la course : ");
        System.out.println("année : ");
        int annee = sc.nextInt();
        System.out.println("mois : ");
        int mois = sc.nextInt();
        System.out.println("jour : ");
        int jour = sc.nextInt();
        LocalDate dateCourse = LocalDate.of(annee, mois, jour);
        System.out.println("nouveau priceMoney  : ");
        BigDecimal priceMoney = sc.nextBigDecimal();
        sc.skip("\n");

        String query = "update APICourse set NOM=?, KM=?, DATECOURSE=?, PRICEMONEY=? where IDCOURSE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, ncourse);
            pstm.setInt(2, km);
            pstm.setDate(3, Date.valueOf(dateCourse));
            pstm.setBigDecimal(4, priceMoney);
            pstm.setInt(5, idrech_course);
            int n = pstm.executeUpdate();
            if(n != 0) {
                System.out.println(n + " ligne mise à jour");
            } else {
                System.out.println("record introuvable");
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }
    public void recherche() {
        System.out.println("Entrez l'ID de la course recherchée : ");
        int id_course = sc.nextInt();
        String query = "SELECT * FROM APICOURSE WHERE IDCOURSE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, id_course);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int km = rs.getInt("km");
                String nom = rs.getString("nom");
                Date dateCourse = rs.getDate("datecourse");
                BigDecimal priceMoney = rs.getBigDecimal("pricemoney");

                System.out.println("Détails de la course:");
                System.out.println("ID de la course: " + id_course);
                System.out.println("Nom: " + nom);
                System.out.println("Kilomètres: " + km);
                System.out.println("Date: " + dateCourse);
                System.out.println("Price Money: " + priceMoney);
            }
            else {
                System.out.println("Aucun enregistrement trouvé pour l'ID de course donné.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }


    public void suppression() {
        System.out.println("id de la course à supprimer  ");
        int idrech_course = sc.nextInt();
        String query = "delete from APICourse where IDCOURSE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idrech_course);
            int n = pstm.executeUpdate();
            if(n!=0){
                System.out.println(n+ "ligne supprimée");
            }

            else{
                System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }
    private void tous() {
        String query = "SELECT * FROM APICourse";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idcourse = rs.getInt("IDCOURSE");
                String nom = rs.getString("NOM");
                int km = rs.getInt("KM");
                Date dateCourse = rs.getDate("DATECOURSE");
                BigDecimal priceMoney = rs.getBigDecimal("PRICEMONEY");

                System.out.println("ID de la course: " + idcourse);
                System.out.println("Nom: " + nom);
                System.out.println("Kilomètres: " + km);
                System.out.println("Date: " + dateCourse);
                System.out.println("Price: " + priceMoney);
                System.out.println();

            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        }
    }



}
