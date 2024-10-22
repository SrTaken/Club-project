/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.club;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beni
 */
public class Usuari {
    String nom;
    String password;

    public Usuari(String nom, String password) throws DataException {
        setNom(nom);
        setPassword(password);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws DataException {
        if(nom == null || nom.length() <3){
            throw new DataException("El nombre no puede ser null o tener una longitud inferior a 3");
        }
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws DataException {
        if(password == null || password.length() <8){
            throw new DataException("El contraseña no puede ser null o tener una longitud inferior a 8");
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException ex) {}
        
        byte[] hashBytes = md.digest(password.getBytes());
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        this.password = sb.toString();
    }
    
    
}
