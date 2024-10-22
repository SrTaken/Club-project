/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.club;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author beni
 */
public class Jugador {
    private static Date actual = null;
    private String nom;
    private String cognom; 
    private Sexe sexe; 
    private Date data_naix;
    private String idLegal; 
    private String iban;
    private String adresa;
    private String foto; 
    private int any_fi_revisio_medica;

    //TODO ES OBLIGATORIO
    public Jugador(String nom, String cognom, Sexe sexe, Date data_naix, String idLegal, String iban, String adresa, String foto, int any_fi_revisio_medica) throws DataException {
        setNom(nom);
        setCognom(cognom);
        this.sexe = sexe;
        setData_naix(data_naix);
        setIdLegal(idLegal);
        setIban(iban);
        setAdresa(adresa);
        this.foto = foto;
        setAny_fi_revisio_medica(any_fi_revisio_medica);
        
        actual = new Date();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws DataException {
        if(nom == null || nom.length() <3)
            throw new DataException("El nom no pot ser null o tindre una longitud inferior a 3");
        
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) throws DataException {
        if(cognom == null || cognom.length() <3)
            throw new DataException("El cognom no pot ser null o tindre una longitud inferior a 3");
        this.cognom = cognom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Date getData_naix() {
        return data_naix;
    }

    public void setData_naix(Date data_naix) throws DataException {
        if(data_naix.compareTo(actual) == 0)
            throw new DataException("El any de naixament no es valid");
        
        this.data_naix = data_naix;
    }

    public String getIdLegal() {
        return idLegal;
    }

    public void setIdLegal(String idLegal) throws DataException {
        if(idLegal == null || idLegal.length() < 8)
            throw new DataException("El idlegal no es valid");
        
        this.idLegal = idLegal;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) throws DataException {
        if(IbanValidator(iban))
            throw new DataException("IBAN no valid");
        
        this.iban = iban;
    }
    
    private static boolean IbanValidator(String iban) {
        
        String ibanFormateado = iban.replaceAll("\\s+", "").toUpperCase();
        if (ibanFormateado.length() < 15 || ibanFormateado.length() > 34) {
            return false;
        }

        String ibanReordenado = ibanFormateado.substring(4) + ibanFormateado.substring(0, 4);

        StringBuilder ibanNumerico = new StringBuilder();
        for (char c : ibanReordenado.toCharArray()) {
            if (Character.isDigit(c)) {
                ibanNumerico.append(c);
            } else if (Character.isLetter(c)) {
                ibanNumerico.append(Character.getNumericValue(c));
            } else {
                return false; 
            }
        }

        BigInteger ibanBigInt = new BigInteger(ibanNumerico.toString());
        return ibanBigInt.mod(BigInteger.valueOf(97)).intValue() == 1;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) throws DataException {
        if(adresa == null || adresa.length() < 8)
            throw new DataException("La adreça no es valida");
        this.adresa = adresa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getAny_fi_revisio_medica() {
        return any_fi_revisio_medica;
    }

    public void setAny_fi_revisio_medica(int any_fi_revisio_medica) throws DataException {
        if(any_fi_revisio_medica < actual.getYear())
            throw new DataException("El any de fi revisio medica no es valid");
        
        this.any_fi_revisio_medica = any_fi_revisio_medica;
    }   
    
}
