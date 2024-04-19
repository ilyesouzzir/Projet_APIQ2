/*
package MVC.Model;
import metier.Course;
import myconnections.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseModelDB extends CourseDAO {
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
        String query1 = "insert into APICourse( NOM, KM, DATECOURSE, PRICEMONEY) values(?,?,?,?)";
        String query2 = "select IDCOURSE from APICOURSE where NOM= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, course.getNom());
            pstm1.setInt(2, course.getKm());
            pstm1.setDate(3, Date.valueOf(course.getDateCourse()));
            pstm1.setBigDecimal(4, course.getPriceMoney());
            int nvl = pstm1.executeUpdate();
            System.out.println(nvl + " course insérée");
            if(nvl == 1) {
                pstm2.setString(1, course.getNom());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int IDCOURSE= rs.getInt(1);
                    System.out.println("IDCOURSE = "+IDCOURSE);
                    course.setId_course(IDCOURSE);
                }
                else System.out.println("record introuvable");
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return course;
    }

    @Override
    public boolean removeCourse(Course course) {
        String query = "delete from APICourse where IDCOURSE = ?";
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
    public Course updateCourse(Course course) {
        String query = "update APICourse set NOM=?, KM=?, DATECOURSE=?, PRICEMONEY=? where IDCOURSE = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, course.getNom());
            pstm.setInt(2,course.getKm());
            pstm.setDate(3, Date.valueOf(course.getDateCourse()));
            pstm.setBigDecimal(4, course.getPriceMoney());
            pstm.setInt(5, course.getId_course());
            int n = pstm.executeUpdate();
            if(n != 0) {
                System.out.println(n + " ligne mise à jour");
                return course;
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
    public Course readCourse(int idCourse) {
        String query = "select * from APICOURSE where idcourse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idCourse);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String nom = rs.getString(2);
                int km = rs.getInt(3);
                Date dateCourse = rs.getDate(4);
                BigDecimal priceMoney = rs.getBigDecimal(5);
                Course cours = new Course(idCourse, nom, km, dateCourse.toLocalDate(), priceMoney);
                return  cours;

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
    public List<Course> getCourses() {
        List<Course> lc = new ArrayList<>();
        String query = "select * from APICourse";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idCourse = rs.getInt(1);
                String nom = rs.getString(2);
                int km = rs.getInt(3);
                Date dateCourse = rs.getDate(4);
                BigDecimal priceMoney = rs.getBigDecimal(5);
                Course course = new Course(idCourse, nom, km, dateCourse.toLocalDate(), priceMoney);
                lc.add(course);
            }
            return lc;
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return null;
        }
    }
    public List getNotification() {
        return getCourses();
    }
}

 */