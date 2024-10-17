
/**
 * Ejercicio 1 Entregas - Estilos de natacion
 * @author Sergio Trillo
 */
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadLargos;
        /**
         * Se comprueba que el numero q se introduzca esté entre 0 y 50
         */
        do {
            System.out.println("Introduzca el numero de largos realizados (entre 0 y 50):");
            cantidadLargos= sc.nextInt();
        } while (cantidadLargos<0 || cantidadLargos>50);

        System.out.print("{");
        for (int i=1; i<=cantidadLargos; i++) {
            if (i%4==1)
                System.out.print(" Crol ");
            if (i%2==0) // Posiciones pares para espalda
                System.out.print(" Espalda ");
            if (i%4==3) // 
                System.out.print(" Braza ");
        }
        System.out.print("}");
        System.out.println();
    }
}
