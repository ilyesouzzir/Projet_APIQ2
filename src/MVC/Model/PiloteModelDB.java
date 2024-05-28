package MVC.Model;

import metier.Pilote;
import myconnections.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PiloteModelDB extends DAOPilote {
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
        String query1 = "insert into APIPILOTE(matricule, nom, prenom, datenaiss) values(?,?,?,?)";
        String query2 = "select idPilote from APIPILOTE where matricule = ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm1.setString(1, pilote.getMatricule());
            pstm1.setString(2, pilote.getNom());
            pstm1.setString(3, pilote.getPrenom());
            pstm1.setDate(4, java.sql.Date.valueOf(pilote.getDatenaiss()));

            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setString(1, pilote.getMatricule());
                pstm2.setString(2, pilote.getNom());
                pstm2.setString(3, pilote.getPrenom());
                pstm2.setDate(4, java.sql.Date.valueOf(pilote.getDatenaiss()));

                ResultSet rs = pstm2.executeQuery();
                if(rs.next()){
                    int idPilote = rs.getInt(1);
                    pilote.setId_pilote(idPilote);
                    notifyObservers();
                    return pilote;
                }
                else {
                    System.err.println("record introuvable");
                    return null;
                }
            }
            else return null;
        }
        catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }
    @Override
    public boolean removePilote(Pilote pilote) {
        String query = "delete from APIPILOTE where idpilote = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, pilote.getId_pilote());
            int n = pstm.executeUpdate();
            notifyObservers();
            return n != 0;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }
    @Override
    public Pilote updatePilote(Pilote pilote) {
        String query = "update APIPILOTE set matricule =?, nom=?, prenom=?, datenaiss=? where idpilote = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, pilote.getMatricule());
            pstm.setString(2, pilote.getNom());
            pstm.setString(3, pilote.getPrenom());
            pstm.setDate(4, java.sql.Date.valueOf(pilote.getDatenaiss()));
            pstm.setInt(5, pilote.getId_pilote());

            int n = pstm.executeUpdate();
            notifyObservers();
            if(n != 0) return readPilote(pilote.getId_pilote());
            else return null;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public Pilote readPilote(int idPilote) {
        String query = "select * from APIPILOTE where idpilote = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idPilote);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String matricule = rs.getString("matricule");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                LocalDate datenaiss = rs.getDate("datenaiss").toLocalDate();

                Pilote pilote = new Pilote(idPilote, matricule, nom, prenom, datenaiss);
                return pilote;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public List<Pilote> getPilotes() {
        List<Pilote> lp = new ArrayList<>();
        String query = "select * from APIPILOTE";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idPilote = rs.getInt("idpilote");
                String matricule = rs.getString("matricule");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                LocalDate datenaiss = rs.getDate("datenaiss").toLocalDate();

                Pilote pilote = new Pilote(idPilote, matricule, nom, prenom, datenaiss);
                lp.add(pilote);
            }
            return lp;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public List<Pilote> getNotification() {
        return getPilotes();
    }
}