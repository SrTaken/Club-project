/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.club;

/**
 *
 * @author beni
 */
public class Temporada {
    private int year;

    public Temporada(int year) throws DataException {
        setYear(year);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws DataException {
        if(year < 20 && year>99){
            throw new DataException("El any no es un any valido");
        }
        this.year = year;
    }
    
    
    
}
