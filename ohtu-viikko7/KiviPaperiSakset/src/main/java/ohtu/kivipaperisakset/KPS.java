package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KPS {

    protected Scanner scanner;
    protected String ekanSiirto;
    protected String tokanSiirto;

    public KPS() {
        scanner = new Scanner(System.in);
    }

    public void pelaa() {
        
        Pistelasku pistelasku = new Pistelasku();

        while (true) {

            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            
            tokanSiirto = tokaSiirto();
            
            if (!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                break;
            }

            pistelasku.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(pistelasku);
            System.out.println();

        }
    }

    protected abstract String tokaSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
