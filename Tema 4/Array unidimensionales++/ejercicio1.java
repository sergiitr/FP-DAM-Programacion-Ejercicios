import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int TOTAL_EMPLEADOS=5;
        int totalEmpleados=0
        Empleado[] empleado=new Empleado[TOTAL_EMPLEADOS];

        int opcion;
        String dni;
        do {
            System.out.println("Introduduzca valor: ");
            opcion=sc.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        for (int i=0;i<totalEmpleados;i++) {
                            System.out.println("--- Empleado "+(i+1)+" ---");
                            System.out.println(empleado[i].toString());
                        }
                    }
                    break;
                case 3:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        System.out.println("Introduzca un dni: ");
                        dni=sc.nextLine();
                        for (int i=0; i<totalEmpleados;i++) {
                            if (dni==empleado[i].getDni()) {
                                System.out.println(empleado[i].toString());
                            } 
                        }
                    }
                    break;

                case 4:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        double edadMedia;
                        int aux=0;
                        for (int i=0; i<totalEmpleados; i++) {
                            aux += empleado[i].getEdad();
                        }
                        edadMedia = (double)aux/totalEmpleados;
                    }
                    break;
                case 5:
                    
                    break;
                case 6:
                    if (totalEmpleados==0)
                        System.out.println("No hay empleados");
                    else {
                        System.out.println("Introduzca un dni: ");
                        dni=sc.nextLine();
                        for (int i=0; i<totalEmpleados;i++) {
                            if (dni==empleado[i].getDni()) {
                                String nuevoNombre;
                                System.out.print("Introduce el nuevo nombre: ");
                                nuevoNombre=sc.nextLine();
                                empleado[i].setNombre(nuevoNombre);
                            } 
                        }
                    }
                    break;

                case 7:
                    
                    break;
                case 8:
                    break;
                default: 
                    System.out.println("Se sale del programa");
                    break;
            }
        } while (opcion < 9);
    }    
}

// Empleado(String dni, String nombre, String apellidos, int edad, int sueldo)