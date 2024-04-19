package DesginPatterns.composite;

import java.math.BigDecimal;

public class TestComposite{
    public static void main(String[] args) {
        // Create instances of Course with different amounts of prizeMoney
        Course race1 = new Course(1, "Race 1", new BigDecimal("1000.00"));
        Course race2 = new Course(2, "Race 2", new BigDecimal("2000.00"));
        Course race3 = new Course(3, "Race 3", new BigDecimal("3000.00"));

        // Create an instance of Championnat
        Championnat championnat = new Championnat(1, "Championnat 1", new BigDecimal("5000.00"));

        // Add elements to championnat
        championnat.addElement(race1);
        championnat.addElement(race2);
        championnat.addElement(race3);

        // Calculate and display the total prizeMoney
        System.out.println("Total Prize Money: " + championnat.totPrizeMoney());
    }
}