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
    private Jugador j;
    private Equip e;
    private char titular_convidat;

    public Membre(Jugador j, Equip e, char titular_convidat) throws DataException {
        setJ(j);
        setE(e);
        setTitular_convidat(titular_convidat);
    }

    public Jugador getJ() {
        return j;
    }

    public void setJ(Jugador j) throws DataException {
        if(j == null)
            throw new DataException("El jugador no pot ser null");
        this.j = j;
    }

    public Equip getE() {
        return e;
    }

    public void setE(Equip e) throws DataException {
        if(e == null)
            throw new DataException("El equip no pot ser null");
        this.e = e;
    }

    public char getTitular_convidat() {
        return titular_convidat;
    }

    public void setTitular_convidat(char titular_convidat) throws DataException {
        if(titular_convidat != 'C' && titular_convidat != 'T' )
            throw new DataException("Nomes pot ser C(conviat) o T(Titular)");
        this.titular_convidat = titular_convidat;
    }
    
    
    
}
