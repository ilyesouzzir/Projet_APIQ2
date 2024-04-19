/*
package MVC.Model;

import metier.Pays;
import myconnections.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaysModelDB extends PaysDAO {
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
        String query1 = "insert into APIPays( SIGLE, NOM, LANGUE) values(?,?,?)";
        String query2 = "select IDPAYS from APIPAYS where SIGLE= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, pays.getSigle());
            pstm1.setString(2, pays.getNom());
            pstm1.setString(3, pays.getLangue());
            int nvl = pstm1.executeUpdate();
            System.out.println(nvl + " pays inséré");
            if(nvl == 1) {
                pstm2.setString(1, pays.getSigle());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int IDPAYS= rs.getInt(1);
                    System.out.println("IDPAYS = "+IDPAYS);
                    pays.setId_pays(IDPAYS);
                }
                else System.out.println("record introuvable");
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return pays;
    }

    @Override
    public boolean removePays(Pays pays) {
        String query = "delete from APIPays where IDPAYS = ?";
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
    public Pays updatePays(Pays pays) {
        String query = "update APIPays set SIGLE=?, NOM=?, LANGUE=? where IDPAYS = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, pays.getSigle());
            pstm.setString(2, pays.getNom());
            pstm.setString(3, pays.getLangue());
            pstm.setInt(4, pays.getId_pays());
            int n = pstm.executeUpdate();
            if(n != 0) {
                System.out.println(n + " ligne mise à jour");
                return pays;
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
    public Pays readPays(int idPays) {
        String query = "select * from APIPAYS where idpays = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idPays);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String sigle = rs.getString(2);
                String nom = rs.getString(3);
                String langue = rs.getString(4);
                Pays pays = new Pays(sigle, nom, langue);
                pays.setId_pays(idPays);
                return  pays;

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
    public List<Pays> getPays() {
        List<Pays> lp = new ArrayList<>();
        String query = "select * from APIPays";
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
    public List getNotification() {
        return getPays();
    }
}

 */