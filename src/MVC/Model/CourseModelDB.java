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
    public List<Classement> listePilotePlaceGain(Course course) {
        List<Classement> list = new ArrayList<>();
        String query = "select cl.idclassement, pi.idpilote , pi.matricule,pi.nom , pi.prenom , pi.datenaiss, cl.place , cl.gain from apiclassement cl join apipilote pi on cl.idPilote=pi.idPilote where idcourse=? order by cl.place";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId_course());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idClassement = rs.getInt("idclassement");
                int idPilote = rs.getInt("idpilote");
                String matriculePilote = rs.getString("matricule");
                String nomPilote = rs.getString("nom");
                String prenomPilote = rs.getString("prenom");
                LocalDate dateNaissPilote = rs.getDate("dateNaiss").toLocalDate();
                Pilote pi = new Pilote(idPilote, matriculePilote, nomPilote, prenomPilote, dateNaissPilote);
                int place = rs.getInt("place");
                BigDecimal gain = rs.getBigDecimal("gain");
                Classement classement = new Classement();
                classement.setId_classement(idClassement);
                classement.setPilote(pi);
                classement.setPlace(place);
                classement.setGain(gain);
                list.add(classement);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
        }
        return list;

    }
    @Override
    public BigDecimal gainTotal(Course course) {
        BigDecimal total = new BigDecimal(0);
        String query = "select sum(gain) as totalGain from apiclassement where idcourse = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId_course());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                total = rs.getBigDecimal("totalGain");
            }
        } catch (SQLException e) {
            System.err.println("erreur sql : " + e);
        }
        return total;
    }

    @Override
    public List<Pays> listePaysPilotes(Course course) {
        List<Pays> liste = new ArrayList<>();
        String query = "SELECT distinct p.idPays, p.sigle, p.nom, p.langue \n" +
                "FROM apipays p \n" +
                "JOIN apipilote pi ON p.idPays=pi.idPays\n" +
                "JOIN apiclassement cl ON cl.idPilote = pi.idPilote\n" +
                "WHERE cl.idCourse = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId_course());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idPays = rs.getInt("idPays");
                String sigle = rs.getString("sigle");
                String nomPays = rs.getString("nom");
                String langue = rs.getString("langue");
                Pays p = new Pays(idPays, sigle, nomPays, langue);
                if (!liste.contains(p)) {
                    liste.add(p);
                }
            }
        } catch (SQLException e) {
            System.err.println("erreur sql : " + e);
        }
        return liste;
    }
    @Override
    public Pilote vainqueur(Course course) {
        Pilote p = null;
        String query = "select * from apiclassement cl join apipilote pi on cl.idpilote = pi.idpilote where cl.idcourse = ? and cl.place = 1";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId_course());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                // aide par SatckOverflow pour savoir que je pouvais mettre les noms des colonnes pour qu'ils reconnaissent mieux quand il y a plusieurs tables
                p = new Pilote(rs.getInt("idPilote"), rs.getString("matricule"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("datenaiss").toLocalDate());
            }
        } catch (SQLException e) {
            System.err.println("erreur sql : " + e);
        }
        return p;
    }

    @Override
    public boolean addPilote(Pilote pilote, Course course) {
        String query = "select * from apiclassement where idPilote=? and idCourse=?";
        String query1 = "insert into apiclassement(place, gain, idpilote, idCourse) values(?,?,?,?)";
        String query2 = "select idclassement from apiclassement where place=? and gain=? and idPilote=? and idCourse=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query);
             PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)
        ) {
            pstm.setInt(1, pilote.getId_pilote());
            pstm.setInt(2, course.getId_course());
            ResultSet rs1 = pstm.executeQuery();
            if (rs1.next()) {
                System.out.println("La pilote est déjà enregistré dans la course\n");
                return false;
            } else {
                pstm1.setInt(1, 0);
                pstm1.setBigDecimal(2, BigDecimal.ZERO);
                pstm1.setInt(3, pilote.getId_pilote());
                pstm1.setInt(4, course.getId_course());
                int n = pstm1.executeUpdate();
                if (n == 1) {
                    pstm2.setInt(1, 0);
                    pstm2.setBigDecimal(2, BigDecimal.ZERO);
                    pstm2.setInt(3, pilote.getId_pilote());
                    pstm2.setInt(4, course.getId_course());
                    ResultSet rs = pstm2.executeQuery();
                    if (rs.next()) {
                        return true;
                    } else {
                        System.err.println("record introuvable");
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("erreur sql : " + e);
            return false;
        }
    }
    @Override
    public boolean supPilote(Pilote pilote, Course course) {
        String query = "DELETE FROM APICLASSEMENT WHERE idpilote = ? AND idcourse = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, pilote.getId_pilote());
            pstm.setInt(2, course.getId_course());
            int n = pstm.executeUpdate();
            if (n != 0) {
                System.out.println("Le pilote a bien été supprimé de la course");
                return true;
            } else {
                System.err.println("Le pilote n'existe pas pour cette course");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql :" + e);
            return false;
        }
    }

    @Override
    public Classement resultat(Pilote pilote, int place, BigDecimal gain,Course course) {
        String query1 = "select * from apiclassement where idPilote = ? and idCourse = ?";
        String query2 = "insert into apiclassement(place, gain, idpilote, idcourse) values (?,?,?,?)";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2)
        ) {
            pstm1.setInt(1, pilote.getId_pilote());
            pstm1.setInt(2, course.getId_course());
            ResultSet rs = pstm1.executeQuery();
            if (rs.next()) {
                pstm2.setInt(1, place);
                pstm2.setBigDecimal(2, gain);
                pstm2.setInt(3, pilote.getId_pilote());
                pstm2.setInt(4, course.getId_course());
                int n = pstm2.executeUpdate();
                if (n == 1) {
                    return new Classement(place, gain, pilote);
                } else {
                    System.err.println("record introuvable");
                    return null;
                }
            } else {
                System.err.println("Le pilote n'est pas inscrit pour cette course\n");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql : " + e);
            return null;
        }
    }


    @Override
public boolean modif(Pilote pilote, int place, BigDecimal gain, Course course) {
    String query = "UPDATE APIClassement SET place = ?, gain = ? WHERE idpilote = ? and idcourse = ?";

    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
        pstm.setInt(1, place);
        pstm.setBigDecimal(2, gain);
        pstm.setInt(3, pilote.getId_pilote());
        pstm.setInt(4, course.getId_course());

        pstm.executeUpdate();
    } catch (SQLException e) {
        System.err.println("erreur sql :" + e);
    }
    if (place == -1) {
        query = "update apiclassement set place = ?, gain = ? where idCourse = ? and idPilote = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, place);
            pstm.setBigDecimal(2, gain);
            pstm.setInt(3, course.getId_course());
            pstm.setInt(4, pilote.getId_pilote());
            int n = pstm.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                System.err.println("Le pilote n'est pas inscrit dans cette course");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("erreur sql : " + e);
            return false;
        }
}
return true;
}

    @Override
    public List<Pilote> ListePiloteDuPays(Course course, Pays pays) {
        List<Pilote> listeP = new ArrayList<>();
        String query = "select pi.* from apipilote pi\n" +
                "                JOIN apiclassement cl on cl.idpilote = pi.idPilote\n" +
                "                JOIN apicourse c on c.idcourse=cl.idcourse\n" +
                "                WHERE c.idcourse = ? and pi.idpays = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId_course());
            pstm.setInt(2, pays.getId_pays());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idPilote = rs.getInt("idpilote");
                String matriculePilote = rs.getString("matricule");
                String nomPilote = rs.getString("nom");
                String prenomPilote = rs.getString("prenom");
                LocalDate dateNaissPilote = rs.getDate("dateNaiss").toLocalDate();
                Pilote pilote = new Pilote(idPilote, matriculePilote, nomPilote, prenomPilote, dateNaissPilote);
                listeP.add(pilote);
            }
        } catch (SQLException e) {
            System.err.println("erreur sql : " + e);
        }
        return listeP;
    }
    @Override
    public boolean classementComplet(Course course) {
        String query = "SELECT place FROM APIClassement where idcourse= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, course.getId_course());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int place = rs.getInt(1);
                if (place != -1 && place < 1) {
                    return false;
                }
            }
            return true;
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