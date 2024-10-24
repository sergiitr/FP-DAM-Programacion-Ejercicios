public class ejercicio4 {
    public static void main(String[] args) {
        /**
         * Se lanza una excepción si no se introducen datos o son menores que 3.
         * Si se introducen 3 o más, se muestra un mensaje de bienvenida.
         */
        try {
            /**
             * Si el número de argumentos es exactamente 3
             * Mostrar mensaje de bienvenida usando los tres argumentos (nombre completo)
             */
            if(args.length == 3)
                System.out.println("Bienvenido " + args[2] + " " + args[0] + " " + args[1]);
            /**
             * Si hay más de 3 argumentos
             * Notificar que se han introducido más parámetros de los necesarios
             * Mostrar mensaje de bienvenida usando solo los tres primeros argumentos
             */
            else if (args.length > 3) {
                System.out.println("Se han metido más parámetros, se generará con los 3 primeros");
                System.out.println("Bienvenido " + args[2] + " " + args[0] + " " + args[1]);
            } else {
                /**
                 * Lanzar una excepción si se proporcionan menos de 3 argumentos
                 */
                throw new Exception();
            }
        } catch (Exception e) {
            /**
             * Captura la excepción (que no haya suficientes argumentos)
             */
            System.out.println("Datos insuficientes. Se debe proporcionar al menos 3 parámetros.");
        }
    }
}
