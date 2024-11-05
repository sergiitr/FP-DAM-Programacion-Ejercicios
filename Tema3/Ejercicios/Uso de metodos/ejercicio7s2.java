import java.awt.geom.Line2D;
import java.util.Scanner;

public class ejercicio7s2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario las coordenadas de los puntos A y B
        System.out.print("Introduce la coordenada x de A: ");
        double x1 = sc.nextDouble();
        System.out.print("Introduce la coordenada y de A: ");
        double y1 = sc.nextDouble();

        System.out.print("Introduce la coordenada x de B: ");
        double x2 = sc.nextDouble();
        System.out.print("Introduce la coordenada y de B: ");
        double y2 = sc.nextDouble();

        // Cálculo usando Line2D
        Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
        double distanciaLine2D = line.getP1().distance(line.getP2());
        System.out.println("Distancia calculada usando Line2D: " + distanciaLine2D);
    }
}
