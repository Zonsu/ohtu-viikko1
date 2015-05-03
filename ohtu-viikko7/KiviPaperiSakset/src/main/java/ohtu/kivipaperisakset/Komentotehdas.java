
package ohtu.kivipaperisakset;

import java.util.HashMap;

public class Komentotehdas {

    private HashMap<String, Peli> komennot;

    public Komentotehdas() {
        komennot = new HashMap<String, Peli>();

        komennot.put("a", Peli.uusiKaksinPeli());
        komennot.put("b", Peli.uusiTkoaly());
        komennot.put("c", Peli.uusiParempiTekoaly());
    }

    public Peli hae(String operaatio) {
        Peli komento = komennot.get(operaatio);
        return komento;
    }
}
