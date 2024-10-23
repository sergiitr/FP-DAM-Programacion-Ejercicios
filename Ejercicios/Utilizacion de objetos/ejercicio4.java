public class ejercicio4 {
    public static void main(String[] args) {
        /**
         * Se muestra el total de argumentos introducidos
         */
        System.out.println("Se han introducido un total de "+args.length+" argumentos");
        /**
         * Se lanza una excepcion si no se introducen datos o son menores que 3
         * Se muestra por pantalla si se introducen 3 o mas
         */
        try {
            if(args.length==3)
                System.out.println("Bienvenido "+args[2]+" "+args[0]+" "+args[1]);
            else if (args.length >=3) {
                System.out.println("Se han metido mas parmetros, se generara con los 3 primeros");
                System.out.println("Bienvenido "+args[2]+" "+args[0]+" "+args[1]);
            }
        } catch (Exception e) {
            System.out.println("Datos insuficientes");
        }
        
    }
}
