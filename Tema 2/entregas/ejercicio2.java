
/**
 * Ejercicio 2 - Formacion de soldados
 * @author Sergio Trillo
 */
import java.util.Scanner;

public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int lineal = 1;
		final int cuadrado = 2;
		final int triangulo = 3;
		
		int soldados,sobrantes=0,soldadosUsados=0,filas=0;
		int forma;
		

		/**
		 * Se introduce el numero de soldados 
		 */
		do {
			System.out.println("Introduzca el numero de soldados (mayor o igual que 1):");
			soldados=sc.nextInt();
		} while (soldados<1);

		/**
		 * Se introduce la forma
		 */
		System.out.println("1 - lineal");
		System.out.println("2 - cuadrado");
		System.out.println("3 - triangulo");
		System.out.println("Introduzca forma: ");
		forma = sc.nextInt();

		/**
		 * Se hace un switch para cada formacion que se pide
		 */
		switch (forma) {
			/**
			 * Se muestra los * seguidos
			 */
			case lineal:
				for (int i=0;i<soldados; i++)
					System.out.print("*");
				break;
			/**
			 * Se muestan los * en forma de cuadrado
			 * Asi mismo los que sobran despues de la formacion
			 */
			case cuadrado:
		                filas = (int) Math.sqrt(soldados);
		                soldadosUsados = filas * filas;
		            
		                // Imprimimos el cuadrado
		                for (int i = 0; i < filas; i++) {
		                    for (int j = 0; j < filas; j++) {
		                        System.out.print("*");
		                    }
		                    System.out.println();
		                }
		            
		                // Calculamos los sobrantes
		                sobrantes = soldados - soldadosUsados;
		                System.out.println("Han sobrado " + sobrantes + " figuras");
				break;
			/**
			 * Se muestan los * en forma de triangulo
			 * Asi mismo los que sobran despues de la formacion
			 */
			case triangulo:
				while (soldadosUsados + (filas + 1) <= soldados) {
					filas++;
					soldadosUsados += filas;
				}
				for (int i=filas; i>=0; i--) {
					for (int j=i;j>0;j--)
						System.out.print("*");
					System.out.println();
				}
				sobrantes = soldados - soldadosUsados;
				System.out.println("Han sobrado "+sobrantes+" figuras");
				break;
			default:
				System.out.println("Figura no valida");
				break;
		};
		System.out.println("");
	}
}
