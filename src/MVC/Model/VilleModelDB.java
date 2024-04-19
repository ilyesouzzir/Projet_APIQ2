/*
package MVC.Model;

import metier.Ville;
import myconnections.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VilleModelDB extends VilleDAO {
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
        String query1 = "insert into APIVille( NOM, LATITUDE, LONGITUDE) values(?,?,?)";
        String query2 = "select IDVILLE from APIVILLE where LATITUDE= ? , LONGITUDE= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, ville.getNom());
            pstm1.setDouble(2, ville.getLatitude());
            pstm1.setDouble(3, ville.getLongitude());
            int nvl = pstm1.executeUpdate();
            System.out.println(nvl + " ville insérée");
            if(nvl == 1) {
                pstm2.setString(1, ville.getNom());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int IDVILLE= rs.getInt(1);
                    System.out.println("IDVILLE = "+IDVILLE);
                    ville.setId_ville(IDVILLE);
                }
                else System.out.println("record introuvable");
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return ville;
    }

    @Override
    public boolean removeVille(Ville ville) {
        String query = "delete from APIVille where IDVILLE = ?";
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
    public Ville updateVille(Ville ville) {
        String query = "update APIVille set NOM=?, LATITUDE=?, LONGITUDE=? where IDVILLE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, ville.getNom());
            pstm.setDouble(2, ville.getLatitude());
            pstm.setDouble(3, ville.getLongitude());
            pstm.setInt(4, ville.getId_ville());
            int n = pstm.executeUpdate();
            if(n != 0) {
                System.out.println(n + " ligne mise à jour");
                return ville;
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
    public Ville readVille(int idVille) {
        String query = "select * from APIVILLE where idville = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idVille);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String nom = rs.getString(2);
                double latitude = rs.getDouble(3);
                double longitude = rs.getDouble(4);
                Ville ville = new Ville(nom, latitude, longitude);
                ville.setId_ville(idVille);
                return  ville;

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
    public List<Ville> getVilles() {
        List<Ville> lv = new ArrayList<>();
        String query = "select * from APIVille";
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
    public List getNotification() {
        return getVilles();
    }
}

 */