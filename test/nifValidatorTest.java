
import org.milaifontanals.club.Jugador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isard
 */
public class nifValidatorTest {
    public static void main(String[] args) {
        String[] nifs = {
            // Primera lista
            "23456789B", "34567890R", "45678901S", "56789012H", "12345678Z",
            "54657690L", "29430978V", "14271329J", "62925756Q", "32411415Z",
            "27336827Q",
            
            // Segunda lista
            "01981089P", "99879902N", "48808862W", "00611241Q", "80384029E",
            "71889574K", "08122513V", "79634972W", "19847563H", "91827271Q",
            "28472734P",
            
            // Tercera lista
            "29382726K", "83928392J", "93847281F", "94829291J", "89099366P",
            "13531089Y", "54548875C", "81364063E"
        };

        System.out.println("Validación de NIFs:");
        System.out.println("===================");
        
        int validos = 0;
        int invalidos = 0;

        for (String nif : nifs) {
            boolean esValido = Jugador.NifValidator(nif);
            System.out.printf("%-10s : %s%n", nif, esValido ? "✅ Válido" : "❌ NO válido");
            
            if (!esValido) {
                invalidos++;
                // Calcular la letra correcta para NIFs inválidos
                try {
                    String numbers = nif.substring(0, 8);
                    int num = Integer.parseInt(numbers);
                    char letraCorrecta = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(num % 23);
                    System.out.println("   → La letra correcta para " + numbers + " debería ser: " + letraCorrecta);
                } catch (Exception e) {
                    System.out.println("   → No se pudo calcular la letra correcta");
                }
            } else {
                validos++;
            }
        }

        System.out.println("\nResumen:");
        System.out.println("========");
        System.out.println("Total NIFs probados: " + nifs.length);
        System.out.println("NIFs válidos: " + validos);
        System.out.println("NIFs inválidos: " + invalidos);
    }

}
