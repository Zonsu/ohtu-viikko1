package ohtu.kivipaperisakset;

public class KPSParempiTekoaly extends KPS {

    private TekoalyParannettu tekoaly;

    public KPSParempiTekoaly() {
        tekoaly = new TekoalyParannettu(20);
    }

    @Override
    protected String tokaSiirto() {
        
        String tietokoneenSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tietokoneenSiirto);
        
        if (onkoOkSiirto(ekanSiirto)) {
            tekoaly.asetaSiirto(ekanSiirto);
        }
        return tietokoneenSiirto;
    }
}
