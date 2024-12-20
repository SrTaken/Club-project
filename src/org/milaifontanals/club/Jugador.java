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
    private static Date actual = actual = new Date();
    private int id = 0;
    private String nom;
    private String cognom; 
    private Sexe sexe; 
    private Date data_naix = new Date();
    private String idLegal; 
    private String iban;
    private String adresa;
    private String poblacio;
    private int cp;
    private String foto; 
    private int any_fi_revisio_medica;

    //TODO ES OBLIGATORIO
    public Jugador(String nom, String cognom, Sexe sexe, Date data_naix, String idLegal, String iban, String adresa, String poblacio, int cp, String foto, int any_fi_revisio_medica) throws DataException {
        setNom(nom);
        setCognom(cognom);
        setSexe(sexe);
        setData_naix(data_naix);
        setIdLegal(idLegal);
        setIban(iban);
        setAdresa(adresa);
        setPoblacio(poblacio);
        setCp(cp);
        setFoto(foto);
        setAny_fi_revisio_medica(any_fi_revisio_medica);
    }
    public Jugador(int id, String nom, String cognom, Sexe sexe, Date data_naix, String idLegal, String iban, String adresa, String poblacio, int cp, String foto, int any_fi_revisio_medica) throws DataException {
        this.id = id;
        setNom(nom);
        setCognom(cognom);
        setSexe(sexe);
        setData_naix(data_naix);
        setIdLegal(idLegal);
        setIban(iban);
        setAdresa(adresa);
        setPoblacio(poblacio);
        setCp(cp);
        setFoto(foto);
        setAny_fi_revisio_medica(any_fi_revisio_medica);
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) throws DataException {
        if(poblacio == null || poblacio.length() < 1)
            throw new DataException("Poblacio no valid");
        this.poblacio = poblacio;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) throws DataException {
        if(cp < 1)
            throw new DataException("CP no valid");
        this.cp = cp;
    }

    
    
    public int getId() {
        return id;
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
    
    public String getSexeString() {
        return sexe.name();
    }

    public void setSexe(Sexe sexe) throws DataException {
        if(sexe == null)
            throw new DataException("El sexe no pot ser null");
        this.sexe = sexe;
    }

    public Date getData_naix() {
        return data_naix;
    }

    public void setData_naix(Date data_naix) throws DataException {
        if(data_naix.compareTo(actual) == 0 || data_naix == null)
            throw new DataException("El any de naixament no es valid");
        
        this.data_naix = data_naix;
    }

    public String getIdLegal() {
        return idLegal;
    }

    public void setIdLegal(String idLegal) throws DataException {
        if(idLegal == null || idLegal.length() < 8 || !NifValidator(idLegal))
            throw new DataException("El idlegal no es valid");
        
        this.idLegal = idLegal;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) throws DataException {
        if(!IbanValidator(iban))
            throw new DataException("IBAN no valid");
        
        this.iban = iban;
    }
    
    public static boolean IbanValidator(String iban) {
        
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

    public void setFoto(String foto) throws DataException {
        if(foto == null || foto.length() < 2)
            throw new DataException("La foto no es valida");
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

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nom=" + nom + ", cognom=" + cognom + ", sexe=" + sexe + ", data_naix=" + data_naix + ", idLegal=" + idLegal + ", iban=" + iban + ", adresa=" + adresa + ", foto=" + foto + ", any_fi_revisio_medica=" + any_fi_revisio_medica + '}';
    }
    
    public static boolean NifValidator(String nif) {
        if (nif == null || nif.trim().isEmpty()) {
            return false;
        }

        nif = nif.toUpperCase().trim();

        if (nif.length() != 9) {
            return false;
        }

        char first = nif.charAt(0);
        String numbers;
        char letter = nif.charAt(8);
        String letrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE";

        try {
            if (first == 'X' || first == 'Y' || first == 'Z') {
                numbers = (first == 'X' ? "0" : first == 'Y' ? "1" : "2") + nif.substring(1, 8);
            } 
            else {
                if (!Character.isDigit(first)) {
                    return false;
                }
                numbers = nif.substring(0, 8);
            }

            for (int i = 0; i < numbers.length(); i++) {
                if (!Character.isDigit(numbers.charAt(i))) {
                    return false;
                }
            }

            int num = Integer.parseInt(numbers);
            char letraCorrecta = letrasNIF.charAt(num % 23);

            return letter == letraCorrecta;

        } catch (Exception e) {
            return false;
        }
    }
}