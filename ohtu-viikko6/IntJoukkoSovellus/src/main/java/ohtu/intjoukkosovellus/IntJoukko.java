package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
            OLETUSKASVATUS = 5;

    private int kasvatuskoko;
    private int[] ljono;
    private int alkioidenLkm;

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti <= 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti tulee olla vähintään 1");
        }
        if (kasvatuskoko <= 0) {
            throw new IndexOutOfBoundsException("Kavatuskoko tulee olla vähintään 1");
        }
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {

        if (kuuluu(luku)) {
            return false;
        }
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;

        if (alkioidenLkm % ljono.length == 0) {
            int[] uusi = ljono.clone();
            ljono = new int[alkioidenLkm + kasvatuskoko];
            System.arraycopy(uusi, 0, ljono, 0, alkioidenLkm);
        }
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int l : ljono) {
            if (l == luku) {
                return true;
            }
        }
        return false;
    }

    public int luvunIndeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == this.ljono[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean poista(int luku) {

        int indeksi = luvunIndeksi(luku);
        if (indeksi != -1) {
            int[] uusi = ljono.clone();
            System.arraycopy(uusi, indeksi + 1, ljono, indeksi, alkioidenLkm - indeksi);
            this.alkioidenLkm--;
            return true;
        }
        return false;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        tuotos += ljono[0];
        
        for (int i = 1; i < alkioidenLkm; i++) {
            tuotos += ", ";
            tuotos += ljono[i];
        }
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {

        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            a.lisaa(bTaulu[i]);
        }
        return a;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            if (b.kuuluu(aTaulu[i])) {
                uusiJoukko.lisaa(aTaulu[i]);
            }
        }
        return uusiJoukko;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko uusiJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            if (!b.kuuluu(aTaulu[i])) {
                uusiJoukko.lisaa(aTaulu[i]);
            }
        }
        return uusiJoukko;
    }

}
