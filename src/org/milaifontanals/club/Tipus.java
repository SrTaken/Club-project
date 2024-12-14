/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.club;

/**
 *
 * @author beni
 */
public enum Tipus {
    H("Masculi"),
    D("Femeni"),
    M("Mixte");
    
    private final String displayName;

    Tipus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName(){
        return displayName;
    }
    public static Tipus fromDisplayName(String displayName) {
        for (Tipus tipus : values()) {
            if (tipus.getDisplayName().equalsIgnoreCase(displayName)) {
                return tipus;
            }
        }
        throw new IllegalArgumentException("No enum constant for displayName: " + displayName);
    }
    
    
}
