/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.HashMap;

public class Komentotehdas {

    private HashMap<String, Peli> komennot;

    public Komentotehdas() {
        komennot = new HashMap<String, Peli>();

        komennot.put("a", Peli.uusiKaksinPeli());
        komennot.put("b", Peli.uusiParempiTekoaly());
        komennot.put("c", Peli.uusiTkoaly());
    }

    public Peli hae(String operaatio) {
        Peli komento = komennot.get(operaatio);
        return komento;
    }
}
