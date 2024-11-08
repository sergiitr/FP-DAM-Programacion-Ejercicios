public class ejercicio1 {
    public static void main(String[] args) {
        /**
         * Hacemos los objetos e1 y e2 pasando nosotros los parametros
         */
        EcuacionesLineales e1 = new EcuacionesLineales(1,1,2,2,1,2);
        System.out.println("Ecuacion 1:\n"+e1.toString());
        EcuacionesLineales e2 = new EcuacionesLineales(2,1,-1,2,7,-1);
        System.out.println("Ecuacion 2:\n"+e2.toString());

        /**
         * Hacemos el objeto e3 con el constructor x defecto
         */
        EcuacionesLineales e3 = new EcuacionesLineales();

        if (e1.equals(e2) == true)
            System.out.println("e1 y e2 son iguales");
        else
            System.out.println("e1 y e2 NO son iguales");

        if (e1.equals(e3) == true)
            System.out.println("e1 y e3 son iguales");
        else
            System.out.println("e1 y e3 NO son iguales");
    }
}
