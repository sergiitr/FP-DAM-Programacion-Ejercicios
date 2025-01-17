import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la frase: ");
        String frase = sc.nextLine();

        // Convertimos la frase a minúsculas para ignorar mayúsculas/minúsculas
        frase = frase.toLowerCase();

        // Creamos un array de 26 posiciones para contar cada letra (a-z)
        int[] contador = new int[26];

        // Recorremos la frase y contamos solo las letras
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (caracter >= 'a' && caracter <= 'z') {
                contador[caracter - 'a']++; // Incrementa el índice correspondiente a la letra
            }
        }

        // Imprimimos los resultados
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] > 0) { // Solo mostramos letras que aparecen en la frase
                System.out.println((char) (i + 'a') + ": " + contador[i]);
            }
        }
    }
}
