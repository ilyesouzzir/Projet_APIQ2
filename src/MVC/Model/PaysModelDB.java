package MVC.Model;

import metier.Pays;
import myconnections.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaysModelDB extends DAOPays {
    protected Connection dbConnect;

    public PaysModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }
    @Override
    public Pays addPays(Pays pays) {
        String query1 = "insert into APIPAYS(sigle,nom,langue) values(?,?,?)";
        String query2 = "select idPays from APIPAYS where sigle = ? and nom = ? and langue = ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            pstm1.setString(1, pays.getSigle());
            pstm1.setString(2, pays.getNom());
            pstm1.setString(3, pays.getLangue());
            int n = pstm1.executeUpdate();
            if(n==1){
                pstm2.setString(1, pays.getSigle());
                pstm2.setString(2, pays.getNom());
                pstm2.setString(3, pays.getLangue());

                ResultSet rs = pstm2.executeQuery();
                if(rs.next()){
                    int idPays = rs.getInt(1);
                    pays.setId_pays(idPays);
                    notifyObservers();
                    return pays;
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
    public boolean removePays(Pays pays) {
        String query = "delete from APIPAYS where idpays = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, pays.getId_pays());
            int n = pstm.executeUpdate();
            notifyObservers();
            return n != 0;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }
    @Override
    public Pays updatePays(Pays pays) {
        String query = "update APIPAYS set sigle =?, nom=?, langue=? where idpays = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, pays.getSigle());
            pstm.setString(2, pays.getNom());
            pstm.setString(3, pays.getLangue());
            pstm.setInt(4, pays.getId_pays());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n != 0) return readPays(pays.getId_pays());
            else return null;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public Pays readPays(int idPays) {
        String query = "select * from APIPAYS where idpays = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idPays);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String sigle = rs.getString(2);
                String nom = rs.getString(3);
                String langue = rs.getString(4);
                Pays pays = new Pays(sigle, nom, langue);
                pays.setId_pays(idPays);
                return pays;
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
    public List<Pays> getPays() {
        List<Pays> lp = new ArrayList<>();
        String query = "select * from APIPAYS";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idPays = rs.getInt(1);
                String sigle = rs.getString(2);
                String nom = rs.getString(3);
                String langue = rs.getString(4);
                Pays pays = new Pays(sigle, nom, langue);
                pays.setId_pays(idPays);
                lp.add(pays);
            }
            return lp;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }

    @Override
    public List<Pays> getNotification() {
        return getPays();
    }
}