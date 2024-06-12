package DesginPatterns.builder;

import java.time.LocalDate;

public class TestPilote {
    public static void main(String[] args) {
        try {
            Pays pays = new Pays.PaysBuilder()
                    .setIdPays(1)
                    .setSigle("FR")
                    .setNom("France")
                    .setLangue("Francais")
                    .build();

            Pilote pilote = new Pilote.PiloteBuilder()
                    .setId_pilote(1)
                    .setMatricule("PILOTE1")
                    .setNom("Dupond")
                    .setPrenom("Jean")
                    .setDateNaiss(LocalDate.of(2004, 2, 25))
                    .setPays(pays)
                    .setLangue("anglais")
                    .build();

            System.out.println(pilote.toString());
        } catch (Exception e) {
            System.out.println("erreur : "+e);
        }
    }
}