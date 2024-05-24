package DesginPatterns.composite;

import java.math.BigDecimal;

public class TestComposite{
    public static void main(String[] args) {
        // Create instances of Championnat with different amounts of prizeMoney
        Championnat championnat1 = new Championnat(1, "Championnat 1", new BigDecimal("1000.00"));
        Championnat championnat2 = new Championnat(2, "Championnat 2", new BigDecimal("2000.00"));
        Championnat championnat3 = new Championnat(3, "Championnat 3", new BigDecimal("3010.00"));

        // Create an instance of Championnat
        Championnat superChampionnat = new Championnat(4, "Super Championnat", new BigDecimal("5000.00"));

        // Add elements to superChampionnat
        superChampionnat.addElement(championnat1);
        superChampionnat.addElement(championnat2);
        superChampionnat.addElement(championnat3);

        // Calculate and display the total prizeMoney
        System.out.println("Total Prize Money: " + superChampionnat.totPrizeMoney());
    }
}