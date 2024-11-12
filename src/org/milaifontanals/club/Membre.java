/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.club;

/**
 *
 * @author beni
 */
public class Membre {
    private int j;
    private int e;
    private char titular_convidat;

    public Membre(int j, int e, char titular_convidat) throws DataException {
        setJ(j);
        setE(e);
        setTitular_convidat(titular_convidat);
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) throws DataException {
        if(j < 1)
            throw new DataException("El jugador no pot ser null");
        this.j = j;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) throws DataException {
        if(e < 1)
            throw new DataException("El equip no pot ser null");
        this.e = e;
    }

    public char getTitular_convidat() {
        return titular_convidat;
    }

    public void setTitular_convidat(char titular_convidat) throws DataException {
        if(titular_convidat == 'C' || titular_convidat == 'T' )
            throw new DataException("Nomes pot ser C(conviat) o T(Titullar)");
        this.titular_convidat = titular_convidat;
    }
    
    
    
}
