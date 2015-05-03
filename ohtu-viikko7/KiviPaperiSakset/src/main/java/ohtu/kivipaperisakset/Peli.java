/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author Johanna
 */
public class Peli {

    private KPS kps;

    protected Peli(KPS kps) {
        this.kps = kps;
    }

    public static Peli uusiKaksinPeli() {
        return new Peli(new KPSPelaajaVsPelaaja());
    }

    public static Peli uusiParempiTekoaly() {
        return new Peli(new KPSParempiTekoaly());
    }

    public static Peli uusiTkoaly() {
        return new Peli(new KPSTekoaly());
    }
    
    public void pelaa() {
        kps.pelaa();
    }
}
