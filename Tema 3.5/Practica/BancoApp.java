import java.util.Objects;
import java.util.Scanner;

public class BancoApp {
    /**
     * Metodo para limpiar la pantalla de la consola
     */
    public static void limpiarConsola() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }      
    
    public static int leerEntero(Scanner sc) {
        int input = -1;
        boolean valido = false;
        while (!valido) {
            try {
                input = sc.nextInt();
                valido = true;
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor ingrese un número entero.");
                sc.nextLine(); // Limpiar el buffer del Scanner
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCuenta, aux, cantidad, cuentaDestino;
        boolean operaciones = true;
        CuentaBancaria c1 = new CuentaBancaria(110, "Sergio");
        CuentaBancaria c2 = new CuentaBancaria(220, "David");
        CuentaBancaria c3 = new CuentaBancaria(330, "Jesus");

        Banco banco1 = new Banco();
        banco1.agregarCuenta(c1);
        banco1.agregarCuenta(c2);
        banco1.agregarCuenta(c3);

        System.out.print("Las cuentas que hay en el banco son:");
        banco1.listarCuentas();

        System.out.println("\n\n");
        do {
            System.out.print("Ingrese un numero de cuenta: ");
            numCuenta = leerEntero(sc);
            
            if (!Objects.nonNull(banco1.buscaCuenta(numCuenta)))
                System.out.println("No existe ese numero de cuenta");
            else {
                System.out.println("Los datos de esa cuenta son:\n" + banco1.buscaCuenta(numCuenta).toString());

                System.out.println("¿Qué operación quieres hacer en esa cuenta?");
                System.out.println("Pulse 1 para depositar, 2 para retirar, 3 para transferencia");
                do {
                    aux = leerEntero(sc);
                } while (aux != 1 && aux != 2 && aux != 3);
                
                switch (aux) {
                    case 1:
                        System.out.print("Introduzca la cantidad que quiera depositar: ");
                        cantidad = leerEntero(sc);
                        banco1.buscaCuenta(numCuenta).depositar(cantidad);
                        break;
                    case 2:
                        System.out.print("Introduzca la cantidad que quiera retirar: ");
                        cantidad = leerEntero(sc);
                        banco1.buscaCuenta(numCuenta).retirar(cantidad);
                        break;
                    case 3:
                        System.out.print("Introduzca la cantidad que quiera transferir: ");
                        cantidad = leerEntero(sc);

                        System.out.print("Introduzca la cuenta a la que va a ir: ");
                        cuentaDestino = leerEntero(sc);

                        if (!Objects.nonNull(banco1.buscaCuenta(cuentaDestino)))
                            System.out.println("No existe ese número de cuenta");
                        else
                            banco1.buscaCuenta(numCuenta).transferir(banco1.buscaCuenta(cuentaDestino), cantidad);

                        break;
                    default:
                        break;
                }
                System.out.println("Los datos actualizados de esa cuenta son:\n" + banco1.buscaCuenta(numCuenta).toString());
            }

            limpiarConsola();

            System.out.print("¿Quieres hacer otra operación? 1 para SI, 2 para NO: ");
            aux = leerEntero(sc);
            operaciones = aux == 1;

            limpiarConsola();
        } while (operaciones);
    }
}
