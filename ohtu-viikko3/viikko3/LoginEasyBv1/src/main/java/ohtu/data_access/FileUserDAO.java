/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author johanna
 */
public class FileUserDAO implements UserDao {

    private File tiedosto;

    public FileUserDAO(String tiedosto) {

        this.tiedosto = new File(tiedosto);

    }

    @Override
    public List<User> listAll() {

        ArrayList<User> lista = new ArrayList();

        Scanner lukija;
        try {
            lukija = new Scanner(tiedosto);
        } catch (FileNotFoundException ex) {
            lukija = null;
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (lukija != null) {

            while (lukija.hasNextLine()) {
                String nimi = lukija.nextLine();
                String salasana = lukija.nextLine();

                User kayttaja = new User(nimi, salasana);
                lista.add(kayttaja);
            }
            lukija.close();
        }

        return lista;
    }

    @Override
    public User findByName(String name) {
       List<User> lista = listAll();
       
        for (User kayttaja : lista) {
            if (kayttaja.getUsername().equals(name)) {
                return kayttaja;
               
            }
        }
        return null;
    }

    @Override
    public void add(User user) {

        FileWriter kirjoittaja = null;
        
        try {
            kirjoittaja = new FileWriter(this.tiedosto);
            kirjoittaja.append(user.getUsername() + "\n");
            kirjoittaja.append(user.getPassword() + "\n");
            kirjoittaja.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }

}
