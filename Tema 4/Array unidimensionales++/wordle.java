import java.util.Random;
import java.util.Scanner;
public class wordle {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        String introducirPalabra;
        int vidas=5;
        boolean correcto=false;

        String[] palabrasOcultas = {"array","programacion","vector"};
        int aleatorio = rd.nextInt(1,palabrasOcultas.length)-1;

        System.out.println(palabrasOcultas[aleatorio]);
        do {
            System.out.print("Palabra oculta: ");
            for (int i=0; i<palabrasOcultas[aleatorio].length();i++) {
                System.out.print("_ ");
            }
            System.out.println("Te quedan "+vidas+" intentos");
            System.out.println("Introduzca una palabra: ");
            introducirPalabra=sc.nextLine();
            System.out.println("-----------Prueba---------------");
            for (int i=0; i<palabrasOcultas[aleatorio].length();i++) {
                if(palabrasOcultas[aleatorio].charAt(i)==introducirPalabra.charAt(i)) {
                    System.out.print(introducirPalabra.charAt(i));
                }else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
            vidas=vidas-1;
        } while (vidas>0 || correcto=true);
    }
}