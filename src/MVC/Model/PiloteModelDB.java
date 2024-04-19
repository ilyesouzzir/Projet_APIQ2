/*
package MVC.Model;

import metier.Pilote;
import myconnections.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PiloteModelDB extends PiloteDAO {
    protected Connection dbConnect;

    public PiloteModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }

    @Override
    public Pilote addPilote(Pilote pilote) {
        String query1 = "insert into APIPilote( MATRICULE, NOM, PRENOM, DATENAISS) values(?,?,?,?)";
        String query2 = "select IDPILOTE from APIPILOTE where MATRICULE= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, pilote.getMatricule());
            pstm1.setString(2, pilote.getNom());
            pstm1.setString(3, pilote.getPrenom());
            pstm1.setDate(4, Date.valueOf(pilote.getDatenaiss()));
            int nvl = pstm1.executeUpdate();
            System.out.println(nvl + " pilote inséré");
            if(nvl == 1) {
                pstm2.setString(1, pilote.getMatricule());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int IDPILOTE= rs.getInt(1);
                    System.out.println("IDPILOTE = "+IDPILOTE);
                    pilote.setId_pilote(IDPILOTE);
                }
                else System.out.println("record introuvable");
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return pilote;
    }

    @Override
    public boolean removePilote(Pilote pilote) {
        String query = "delete from APIPilote where IDPILOTE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n!=0) return true;
            else return false;

        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return false;
        }
    }

    @Override
    public Pilote updatePilote(Pilote pilote) {
        String query = "update APIPilote set MATRICULE=?, NOM=?, PRENOM=?, DATENAISS=? where IDPILOTE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, pilote.getMatricule());
            pstm.setString(2, pilote.getNom());
            pstm.setString(3, pilote.getPrenom());
            pstm.setDate(4, Date.valueOf(pilote.getDatenaiss()));
            pstm.setInt(5, pilote.getId_pilote());
            int n = pstm.executeUpdate();
            if(n != 0) {
                System.out.println(n + " ligne mise à jour");
                return pilote;
            } else {
                System.out.println("record introuvable");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public Pilote readPilote(int idPilote) {
        String query = "select * from APIPILOTE where idpilote = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idPilote);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                Date datenaiss = rs.getDate(5);
                Pilote pilote = new Pilote(idPilote, matricule, nom, prenom, datenaiss.toLocalDate());
                return  pilote;

            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :"+e);

            return null;
        }
    }

    @Override
    public List<Pilote> getPilotes() {
        List<Pilote> lp = new ArrayList<>();
        String query = "select * from APIPilote";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idPilote = rs.getInt(1);
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                Date datenaiss = rs.getDate(5);
                Pilote pilote = new Pilote(idPilote, matricule, nom, prenom, datenaiss.toLocalDate());
                lp.add(pilote);
            }
            return lp;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }
    public List getNotification() {
        return getPilotes();
    }
}

 */