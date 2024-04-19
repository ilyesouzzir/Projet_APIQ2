package DesginPatterns.observer;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Championnat {
    public static void main(String[] args) {
        Pays pays1 = new Pays("PB", "Pays-Bas", "neerlandais");
        Pays pays2 = new Pays("AN", "Angleterre", "anglais");
        Course c1 = new Course(1, "Gp de Monaco", 15000, LocalDate.of(2024, 4, 5), new BigDecimal(20000));
        Course c2 = new Course(2, "Gp de Spa", 7000, LocalDate.of(2024, 5, 5), new BigDecimal(8500));
        Pilote p1 = new Pilote(1, "Verstappen", "Max", "VM", LocalDate.of(1997, 9, 30));
        Pilote p2 = new Pilote(2, "Hamilton", "Lewis", "HL", LocalDate.of(1985, 1, 7));
        c1.addObserver(p1);
        c1.addObserver(p2);
        c2.addObserver(p2);

        c1.setDateCourse(LocalDate.of(2024, 3, 1));
        c2.setDateCourse(LocalDate.of(2024, 5, 4));
    }
}