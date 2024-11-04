import java.awt.geom.Line2D;
public class ejercicio7s2 {
    public static void main(String[] args) {
        Line2D.Double line = new Line2D.Double(5, 2, 6, 9); 
        System.out.println(line.getP1());
        System.out.println(line.getP2());
        line.setLine(5, 2, 6, 9);
       // System.out.println(line.distance(5,2,6,9) );
    }
}