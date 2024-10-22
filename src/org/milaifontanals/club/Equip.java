/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.club;

/**
 *
 * @author beni
 */
public class Equip {
    private String nom; 
    private Tipus tipus;
    private Categoria categoria; 
    private Temporada temporada; 

    public Equip(String nom, Tipus tipus, Categoria categoria, Temporada temporada) throws DataException {
        setNom(nom);
        setTipus(tipus);
        setTemporada(temporada);
        setCategoria(categoria);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws DataException {
        if(nom == null || nom.length() <3 )
            throw new DataException("Nom no valid");
        this.nom = nom;
    }

    public Tipus getTipus() {
        return tipus;
    }

    public void setTipus(Tipus tipus) throws DataException {
        if(tipus == null)
            throw new DataException("tipus no pot ser null");
        
        this.tipus = tipus;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) throws DataException {
        if(categoria == null)
            throw new DataException("Categoria no pot ser null");
        this.categoria = categoria;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) throws DataException {
        if(temporada == null)
            throw new DataException("Temporada no pot ser null");
        this.temporada = temporada;
    }
    
}
