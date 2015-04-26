/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;
import javax.swing.JTextField;

/**
 *
 * @author Johanna
 */
public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int syote;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {

        String syoteString = this.syotekentta.getText();
        syote = Integer.parseInt(syoteString);
        this.sovellus.plus(syote);
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
        this.syotekentta.setText("");

    }
    @Override
    public void peru() {
        this.sovellus.miinus(syote);
        this.tuloskentta.setText(Integer.toString(sovellus.tulos()));
        this.syotekentta.setText("");
    }
}
