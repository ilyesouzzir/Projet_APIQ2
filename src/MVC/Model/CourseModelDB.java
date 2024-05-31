package MVC.Model;

import metier.Classement;
import metier.Course;
import metier.Pays;
import metier.Pilote;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseModelDB extends DAOCourse {
    protected Connection dbConnect;

    public CourseModelDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }
    @Override
    public Course addCourse(Course course) {
        String query1 = "insert into  APICourse(nom, km, dateCourse, priceMoney) values(?,?,?,?)";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS)) {
            pstm1.setString(1, course.getNom());
            pstm1.setInt(2, course.getKm());
            pstm1.setDate(3, java.sql.Date.valueOf(course.getDateCourse()));
            pstm1.setBigDecimal(4, course.getPriceMoney());
            int n = pstm1.executeUpdate();
            if(n==1){
                ResultSet rs = pstm1.getGeneratedKeys();
                if(rs.next()){
                    int idCourse = rs.getInt(1);
                    course.setId_course(idCourse);
                    notifyObservers();
                    return course;
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
    public boolean removeCourse(Course course) {
        String query = "delete from  APICourse where idcourse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId_course());
            int n = pstm.executeUpdate();
            notifyObservers();
            return n != 0;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }
    @Override
    public Course updateCourse(Course course) {
        String query = "update  APICourse set nom =?, km=?, dateCourse=?, priceMoney=? where idcourse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, course.getNom());
            pstm.setInt(2, course.getKm());
            pstm.setDate(3, java.sql.Date.valueOf(course.getDateCourse()));
            pstm.setBigDecimal(4, course.getPriceMoney());
            pstm.setInt(5, course.getId_course());
            int n = pstm.executeUpdate();
            notifyObservers();
            if(n != 0) return readCourse(course.getId_course());
            else return null;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }
    @Override
    public Course readCourse(int idCourse) {
        String query = "select * from  APICourse where idcourse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idCourse);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String nom = rs.getString(2);
                int km = rs.getInt(3);
                LocalDate dateCourse = rs.getDate(4).toLocalDate();
                BigDecimal priceMoney = rs.getBigDecimal(5);

                Course course = new Course(idCourse, nom, km, dateCourse, priceMoney);
                return course;
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
    public List<Course> getCourses() {
        List<Course> lc = new ArrayList<>();
        String query = "select * from  APICourse";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idCourse = rs.getInt(1);
                String nom = rs.getString(2);
                int km = rs.getInt(3);
                LocalDate dateCourse = rs.getDate(4).toLocalDate();
                BigDecimal priceMoney = rs.getBigDecimal(5);
                Course course = new Course(idCourse, nom, km, dateCourse, priceMoney);
                lc.add(course);
            }
            return lc;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }
    @Override
    public List<Classement> listePilotePlaceGain(Classement cl) {
        List<Classement> list = new ArrayList<>();
        String query = "SELECT * FROM Classement ORDER BY place ASC";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, cl.getPlace());
            pstm.setBigDecimal(2, cl.getGain());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                // Assuming you have a constructor or setters to create a Classement object
                Classement classement = new Classement();
                // Set the properties of the 'classement' object based on the ResultSet
                // Add the 'classement' object to the list
                list.add(classement);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }

        return list;

    }

    @Override
    public BigDecimal gainTotal() {
        BigDecimal totalGain = BigDecimal.ZERO;
        String query = "SELECT SUM(gain) FROM Classement";

        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                totalGain = rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }

        return totalGain;
    }

    @Override
    public List<Pays> listePaysPilotes() {
        List<Pays> list = new ArrayList<>();
        String query = "SELECT DISTINCT Pays FROM Pilote";

        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                // Assuming you have a constructor or setters to create a Pays object
                Pays pays = new Pays();
                // Set the properties of the 'pays' object based on the ResultSet
                // Add the 'pays' object to the list
                list.add(pays);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }

        return list;
    }
    @Override
    public Pilote vainqueur() {
        Pilote pilote = null;
        String query = "SELECT * FROM Pilote WHERE id_pilote = (SELECT pilote_id FROM Classement WHERE place = 1 )";

        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                // Assuming you have a constructor or setters to create a Pilote object
                pilote = new Pilote();
                // Set the properties of the 'pilote' object based on the ResultSet
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }

        return pilote;
    }

    @Override
    public void addPilote(Pilote pilote) {
        String query = "INSERT INTO Pilote (id_pilote, nom, prenom, pays) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, pilote.getId_pilote());
            pstm.setString(2, pilote.getNom());
            pstm.setString(3, pilote.getPrenom());
            pstm.setString(4, pilote.getPays().getNom());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }
    }
    @Override
    public void supPilote(Pilote pilote) {
        String query = "DELETE FROM Pilote WHERE id_pilote = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, pilote.getId_pilote());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }
    }
    @Override
    public Classement resultat(Pilote pilote, int place, BigDecimal gain) {
        Classement classement = null;
        String query = "INSERT INTO Classement (pilote_id, place, gain) VALUES (?, ?, ?)";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setInt(1, pilote.getId_pilote());
            pstm.setInt(2, place);
            pstm.setBigDecimal(3, gain);

            int affectedRows = pstm.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    classement = new Classement();
                    classement.setId_classement(generatedKeys.getInt(1));
                    classement.setPilote(pilote);
                    classement.setPlace(place);
                    classement.setGain(gain);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }

        return classement;
    }
    @Override
    public void modif(Pilote pilote, int place, BigDecimal gain) {
        String query = "UPDATE Classement SET place = ?, gain = ? WHERE pilote_id = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, place);
            pstm.setBigDecimal(2, gain);
            pstm.setInt(3, pilote.getId_pilote());

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }
    }

    @Override
    public List<Pilote> ListePiloteDuPays() {
        List<Pilote> list = new ArrayList<>();
        String query = "SELECT * FROM Pilote WHERE pays = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
           // pstm.setString(1, pilote.getPays().getNom());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                // Assuming you have a constructor or setters to create a Pilote object
                Pilote pilote = new Pilote();
                // Set the properties of the 'pilote' object based on the ResultSet
                // Add the 'pilote' object to the list
                list.add(pilote);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }

        return list;
    }
    @Override
    public boolean classementComplet() {
        String query = "SELECT COUNT(*) FROM Classement WHERE place = 0";

        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                int count = rs.getInt(1);
                return count == 0;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);

        }

        return false;
    }
    @Override
    public List<Course> getNotification() {
        return getCourses();
    }
}