import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner (System.in);
    
    public static void anadirAlumno() {
        LocalDate fechaNacimiento;
        String dni,nombre,apellidos,direccion,email;
        fechaNacimiento.now();
        System.out.print("Introduce DNI:");
        dni=sc.nextLine();
        System.out.print("Introduce nombre:");
        nombre=sc.nextLine();
        System.out.print("Introduce apellidos:");
        apellidos=sc.nextLine();
        System.out.print("Introduce direccion:");
        direccion=sc.nextLine();
        System.out.print("Introduce email:");
        email=sc.nextLine();

        Alumno alumno = new Alumno(dni, nombre, apellidos, fechaNacimiento, direccion, email);
        AlumnoDAO alumnos;
        alumnos.crearAlumno(alumno);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do { 
            System.out.println("--- OPCIONES ---");
            System.out.println("1) Añadir nuevo alumno (si ya existe y no se añade, indicarlo en un mensaje )");
            System.out.println("2) Mostrar los datos del alumno (toString) según su DNI");
            System.out.println("3) Actualizar los datos de un alumno (buscar por DNI)");
            System.out.println("4) Eliminar un alumno de la BBDD por su DNI");
            System.out.println("5) Mostrar los datos de todos los alumnos");
            System.out.println("6) Salir");
            
            do { 
                System.out.print("\tIntroduce opcion: ");
                opcion=sc.nextInt();
            } while (opcion>=1 && opcion<=6);

            switch (opcion) {
                case 1:
                    anadirAlumno();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion!=6);
    }
}
