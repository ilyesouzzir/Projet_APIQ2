package MVC.Model;

import metier.Course;
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
    public List<Course> getNotification() {
        return getCourses();
    }
}