package DesginPatterns.builder;

public class Championnat {
    public static void main(String[] args) {
        try{
            Pays p1 = new Pays.PaysBuilder()
                    .setIdPays(1)
                    .setSigle("USA")
                    .setNom("Etats-Unis")
                    .setLangue("Anglais")
                    .build();
            System.out.println(p1);
        }catch (Exception e){
            System.out.println("erreur : "+e);
        }
        try{
            Pays p2 = new Pays.PaysBuilder()
                    .setIdPays(1)
                    .setLangue("Francais")
                    .build();
            System.out.println(p2);
        }catch (Exception e){
            System.out.println("erreur : "+e);
        }
        try{
            Pays p3 = new Pays.PaysBuilder()
                    .setIdPays(1)
                    .setNom("Belgique")
                    .setLangue("Français")
                    .build();
            System.out.println(p3);
        }catch (Exception e){
            System.out.println("erreur : "+e);
        }
        try{
            Pays p4 = new Pays.PaysBuilder()
                    .setIdPays(1)
                    .setSigle("ESP")
                    .setNom("Espagne")
                    .setLangue("Espagnol")
                    .build();
            System.out.println(p4);
        }catch (Exception e){
            System.out.println("erreur : "+e);
        }
    }
}