import java.util.Scanner;
public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Distancia2Puntos d1 = new Distancia2Puntos();
        System.out.println("La distancia es: "+d1.distancia()+"cm");

        Distancia2Puntos d2 = new Distancia2Puntos(5,2,6,4);
        System.out.println("La distancia es: "+d2.distancia()+"cm");


        /**Distancia2Puntos d3 = new Distancia2Puntos();
        int a1,b1, a2,b2;
        System.out.println("Introduzca coordenadas (x,y) del pnto A:");
        a1=sc.nextInt();
        a2=sc.nextInt();

        System.out.println("Introduzca coordenadas (x,y) del pnto A:");
        b1=sc.nextInt();
        b2=sc.nextInt();

        d3.setX1(a1);
        d3.setX2(a2);
        d3.setY1(b1);
        d3.setY2(b2);
        System.out.println("La distancia es: "+d3.distancia()+"cm"); */
    }
}
