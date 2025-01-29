import java.util.Objects;
import java.util.Scanner;

public class BancoApp {
    public static void limpiarConsola() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }      
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCuenta, aux, cantidad, cuentaDestino;
        boolean operaciones=true;
        CuentaBancaria c1 = new CuentaBancaria(110, "Sergio");
        CuentaBancaria c2 = new CuentaBancaria(220, "David");
        CuentaBancaria c3 = new CuentaBancaria(330, "Jesus");

        Banco banco1 = new Banco();
        banco1.agreagarCuenta(c1);
        banco1.agreagarCuenta(c2);
        banco1.agreagarCuenta(c3);

        banco1.listarCuentas();
        do {
            System.out.print("Ingrese un numero de cuenta: ");
            numCuenta=sc.nextInt();

            if (!Objects.nonNull(banco1.buscaCuenta(numCuenta)))
                System.out.println("No existe ese numero de cuenta");
            else {
                System.out.println("Los datos de esa cuenta son:\n"+banco1.buscaCuenta(numCuenta).toString());
            
                System.out.println("¿Que operacion quieres hacer en esa cuenta?");
                System.out.println("Pulse 1 para depositar, 2 para retirar, 3 para trasferencia");
                do { 
                    aux = sc.nextInt();
                } while (aux != 1 && aux != 2 && aux != 3);
                switch (aux) {
                    case 1:
                        System.out.print("Introduzca la cantidad que quiera depositar: ");
                        cantidad=sc.nextInt();
                        banco1.buscaCuenta(numCuenta).depositar(cantidad);
                        break;
                    case 2:
                        System.out.print("Introduzca la cantidad que quiera retirar: ");
                        cantidad=sc.nextInt();
                        banco1.buscaCuenta(numCuenta).retirar(cantidad);
                        break;
                    case 3:
                        System.out.print("Introduzca la cantidad que quiera trasferir: ");
                        cantidad=sc.nextInt();
                        
                        System.out.print("Introduzca la cuenta a la que va a ir: ");
                        cuentaDestino=sc.nextInt();
                        
                        if (!Objects.nonNull(banco1.buscaCuenta(cuentaDestino)))
                            System.out.println("No existe ese numero de cuenta");
                        else
                            banco1.buscaCuenta(numCuenta).transferir(banco1.buscaCuenta(cuentaDestino), cantidad);
                        break;
                    default:
                        break;
                }
                System.out.println("Los datos actualizados de esa cuenta son:\n"+banco1.buscaCuenta(numCuenta).toString());
            }
            System.out.print("Quieres hacer otra operacion?? 1 para SI, 2 para NO: ");
            do { 
                aux = sc.nextInt();
            } while (aux != 1 && aux != 2);
            if (aux==1)
                operaciones=true;
            else
                operaciones= false;
            
            limpiarConsola();
        } while (operaciones==true);
    }
}
