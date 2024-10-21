
/**
 * Ejercicio 2 - Formacion de soldados
 * @author Sergio Trillo
 */
import java.util.Scanner;

public class ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int LINEAL = 1;
		final int CUADRADO = 2;
		final int TRIANGULO = 3;
		final String ASTERICOS = "*";
		String ESPACIOS = " ";
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
		do{
			System.out.println("1 - lineal");
			System.out.println("2 - cuadrado");
			System.out.println("3 - triangulo");
			System.out.println("Introduzca forma: ");
			forma = sc.nextInt();
		} while (forma<1 || forma>3);
		/**
		 * Se hace un switch para cada formacion que se pide
		 */
		switch (forma) {
			/**
			 * Se muestra los * seguidos
			 */
			case LINEAL:
				for (int i=0;i<soldados; i++)
					System.out.print(ASTERICOS);
				break;
			/**
			 * Se muestan los * en forma de cuadrado
			 * Asi mismo los que sobran despues de la formacion
			 */
			case CUADRADO:
				filas = (int) Math.sqrt(soldados);
				soldadosUsados = filas * filas;
			
				// Imprimimos el cuadrado
				for (int i=0; i<filas; i++) {
					for (int j=0; j<filas; j++)
						System.out.print(ASTERICOS);
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
			case TRIANGULO:
				while (soldadosUsados + (filas + 1) <= soldados) {
					filas++;
					soldadosUsados += filas;
				}

				// Se va mostrando los * dependiendo las filas en la que esté
				for (int i = 0; i < filas; i++) {
					// Imprimir espacios
					for (int j = 0; j < i; j++)
						System.out.print(ESPACIOS);
					// Imprimir asteriscos
					for (int j=(filas-i);j>0;j--)
						System.out.print(ASTERICOS+" ");
					System.out.println();
				}
    
				sobrantes = soldados - soldadosUsados;
				System.out.println("Han sobrado " + sobrantes + " figuras");
				break;
			default:
				System.out.println("Figura no valida");
				break;
		};
		System.out.println("");
	}
}
