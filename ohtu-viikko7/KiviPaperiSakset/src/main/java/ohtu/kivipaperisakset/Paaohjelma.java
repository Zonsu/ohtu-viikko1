package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Komentotehdas komennot = new Komentotehdas();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            Peli komento = komennot.hae(vastaus);
            
            if (komento == null) {
                break;
            }
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            komento.pelaa();
            
//            if (vastaus.endsWith("a")) {
//                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
//                Peli kaksinpeli = Peli.uusiKaksinPeli();
//                kaksinpeli.pelaa();
//            } else if (vastaus.endsWith("b")) {
//                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
//                Peli parempiTekoaly = Peli.uusiParempiTekoaly();
//                parempiTekoaly.pelaa();
//            } else if (vastaus.endsWith("c")) {
//                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
//                Peli tkoaly = Peli.uusiTkoaly();
//                tkoaly.pelaa();
//            } else {
//                break;
//            }

        }

    }
}
