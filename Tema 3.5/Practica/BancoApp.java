import java.util.Objects;
import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCuenta, aux, cantidad;

        CuentaBancaria c1 = new CuentaBancaria(110, "Sergio");
        CuentaBancaria c2 = new CuentaBancaria(220, "David");
        CuentaBancaria c3 = new CuentaBancaria(330, "Jesus");

        Banco banco1 = new Banco();
        banco1.agreagarCuenta(c1);
        banco1.agreagarCuenta(c2);
        banco1.agreagarCuenta(c3);

        banco1.listarCuentas();

        System.out.print("Ingrese un numero de cuenta: ");
        numCuenta=sc.nextInt();

        CuentaBancaria devuelve = banco1.buscaCuenta(numCuenta);
        if (!Objects.nonNull(devuelve))
            System.out.println("No existe ese numero de cuenta");
        else {
            System.out.println("Los datos de esa cuenta son:\n"+devuelve.toString());
        
            System.out.println("¿Que operaciones quieres hacer en esa cuenta?");
            System.out.println("Pulse 1 para depositar ó 2 para retirar");
            do { 
                aux = sc.nextInt();
            } while (aux != 1 && aux != 2);
            if (aux == 1) {
                System.out.print("Introduzca la cantidad que quiera depositar: ");
                cantidad=sc.nextInt();
                devuelve.depositar(cantidad);
            } else {
                System.out.print("Introduzca la cantidad que quiera retirar: ");
                cantidad=sc.nextInt();
                devuelve.retirar(cantidad);
            }
            System.out.println("Los datos actualizados de esa cuenta son:\n"+devuelve.toString());
        }
    }
}
