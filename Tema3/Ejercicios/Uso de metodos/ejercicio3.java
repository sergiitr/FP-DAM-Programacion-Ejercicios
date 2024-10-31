public class ejercicio3 {
    public static void main(String[] args) {
        EcuacionSegundoGrado c1 = new EcuacionSegundoGrado(1,1,3);
        try {
            System.out.println("La solucion positiva es: "+c1.solucion1());
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println("La solucion positiva es: "+c1.solucion2());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
