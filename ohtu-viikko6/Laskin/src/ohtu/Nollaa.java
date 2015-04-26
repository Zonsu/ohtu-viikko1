/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author Johanna
 */
public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int tulos;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        String syoteString = this.tuloskentta.getText();
        tulos = Integer.parseInt(syoteString);
        this.sovellus.nollaa();
        this.tuloskentta.setText("");
        this.syotekentta.setText("");
    }
    @Override
    public void peru() {
        this.tuloskentta.setText(Integer.toString(tulos));
    }
}
