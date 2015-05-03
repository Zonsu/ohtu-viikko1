package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KPS {

    public KPSPelaajaVsPelaaja() {
        
    }

    @Override
    protected String tokaSiirto() {
        System.out.print("Toisen pelaajan siirto: ");
        String siirto = scanner.nextLine();
        return siirto;
    }
}