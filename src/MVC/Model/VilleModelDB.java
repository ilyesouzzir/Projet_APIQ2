package MVC.Model;


import metier.Pilote;
import metier.Ville;
import myconnections.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VilleModelDB extends DAOVille {
    protected Connection dbConnect;

    public VilleModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }

    @Override
    public Ville addVille(Ville ville) {
        String query1 = "insert into APIVILLE(nom,latitude,longitude) values(?,?,?)";
        String query2 = "select idVille from APIVILLE where latitude = ? and longitude=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm1.setString(1, ville.getNom());
            pstm1.setDouble(2, ville.getLatitude());
            pstm1.setDouble(3, ville.getLongitude());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, ville.getNom());
                pstm2.setDouble(1, ville.getLatitude());
                pstm2.setDouble(2, ville.getLongitude());

                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int idVille = rs.getInt(1);
                    ville.setId_ville(idVille);
                    notifyObservers();
                    return ville;
                } else {
                    System.err.println("record introuvable");
                    return null;
                }
            } else return null;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public boolean removeVille(Ville ville) {
        String query = "delete from APIVILLE where idville = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, ville.getId_ville());
            int n = pstm.executeUpdate();
            notifyObservers();
            return n != 0;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public Ville updateVille(Ville ville) {
        String query = "update APIVILLE set nom =?, latitude=?, longitude=? where idville = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, ville.getNom());
            pstm.setDouble(2, ville.getLatitude());
            pstm.setDouble(3, ville.getLongitude());
            pstm.setInt(4, ville.getId_ville());
            int n = pstm.executeUpdate();
            notifyObservers();
            if (n != 0) return readVille(ville.getId_ville());
            else return null;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public Ville readVille(int idVille) {
        String query = "select * from APIVILLE where idville = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idVille);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String nom = rs.getString(2);
                double latitude = rs.getDouble(3);
                double longitude = rs.getDouble(4);
                Ville ville = new Ville(nom, latitude, longitude);
                ville.setId_ville(idVille);
                return ville;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public List<Ville> getVilles() {
        List<Ville> lv = new ArrayList<>();
        String query = "select * from APIVILLE";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idVille = rs.getInt(1);
                String nom = rs.getString(2);
                double latitude = rs.getDouble(3);
                double longitude = rs.getDouble(4);
                Ville ville = new Ville(nom, latitude, longitude);
                ville.setId_ville(idVille);
                lv.add(ville);
            }
            return lv;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public List<Pilote> getPilotesSansDoublon(int idVille) {
        List<Pilote> pilotes = new ArrayList<>();
        String query = "SELECT P.* FROM APIPILOTE P WHERE P.IDPILOTE IN (SELECT DISTINCT CL.IDPILOTE FROM APICLASSEMENT CL JOIN APICOURSE CO ON CL.IDCOURSE = CO.IDCOURSE WHERE CO.IDVILLE = ?)";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idVille);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idPilote = rs.getInt("idpilote");
                String matricule = rs.getString("matricule");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                LocalDate datenaiss = rs.getDate("datenaiss").toLocalDate();
                Pilote pilote = new Pilote(idPilote, matricule, nom, prenom, datenaiss);
                pilotes.add(pilote);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }
        return pilotes;
    }

    @Override
    public List<Ville> getNotification() {
        return getVilles();
    }
}