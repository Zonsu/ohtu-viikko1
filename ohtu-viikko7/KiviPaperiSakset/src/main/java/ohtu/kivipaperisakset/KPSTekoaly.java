package ohtu.kivipaperisakset;

public class KPSTekoaly extends KPS {

    private Tekoaly tekoaly;

    public KPSTekoaly() {
        tekoaly = new Tekoaly();
    }

    @Override
    protected String tokaSiirto() {
        String tietokoneenSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tietokoneenSiirto);
        return tietokoneenSiirto;
    }
}
