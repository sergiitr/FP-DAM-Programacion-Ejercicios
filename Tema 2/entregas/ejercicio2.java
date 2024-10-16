/**
 * Ver si la contraseña es la misma o no
 * @author Sergio Trillo
 */
import java.util.Scanner;
public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int soldados;
		String forma;

		System.out.println("Introduzca el numero de soldados:");
		soldados=sc.nextInt();

		System.out.println("Introduzca forma: ");
		forma = sc.nextLine();

		forma = forma.toLowerCase();

		switch (forma) {
			case "linea":
				for (int i=0;i<soldados; i++)
					System.out.println("*");
				break;
			case "cuadrado":
				break;
			case "triangulo":
				break;
			default:
				System.out.println("Figura no valida");
				break
		};
	}
}
