/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johanna
 */
public class StaticsticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

        @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void loytyyPelaaja() {
        Player p = stats.search("Kurri");
        assertEquals("Kurri", p.getName());
    }


    @Test
    public void eiLoydyPelaajaa() {
        Player p = stats.search("lul");
        assertEquals(null, p);
    }

    @Test
    public void loytyyJoukkue() {
        List j = stats.team("EDM");
        assertEquals(3, j.size());
    }

    @Test
    public void palauttaaParhaanPelaajan() {
        List<Player> p = stats.topScorers(1);
        assertEquals("Gretzky", p.get(0).getName());
    }

}
