/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.club;

/**
 *
 * @author beni
 */
public class Categoria {
    private String categoria;
    private int edat_minima; 
    private int edat_maxima; 

    //FALTA PROGRAMAR EL CONTROL DE LAS EDADES
    
    public Categoria(String categoria, int edat_minima, int edat_maxima) throws DataException {
        setCategoria(categoria);
        this.edat_minima = edat_minima;
        this.edat_maxima = edat_maxima;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws DataException {
        if(categoria == null || categoria.length() <3)
            throw new DataException("La categoria no pot ser null o tindre una longitud inferior a 3");
        
        this.categoria = categoria;
    }

    public int getEdat_minima() {
        return edat_minima;
    }

    public void setEdat_minima(int edat_minima) {
        this.edat_minima = edat_minima;
    }

    public int getEdat_maxima() {
        return edat_maxima;
    }

    public void setEdat_maxima(int edat_maxima) {
        this.edat_maxima = edat_maxima;
    }
    
    
}
