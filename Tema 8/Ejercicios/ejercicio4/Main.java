// Iniciar sesion Mysql:    mysql -h localhost -u usuario -p
// Ejecutar java:           java -cp ./JAR/mysql-connector-j-9.3.0.jar ./Teoria/ejemplo1/Main.java

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            final String USUARIO = "usuario";
            final String CONTRASENIA = "usuario";
            Connection conexion;
            String url = "jdbc:mysql://localhost/academia";
            conexion = DriverManager.getConnection(url, USUARIO, CONTRASENIA);
            System.out.println("Conexión exitosa.");
            System.out.println("---- OPCIONES ----");
            System.out.println("1) Añadir un nuevo alumno. Deberás pedir los datos del alumno y añadirlo a la tabla correspondiente");
            System.out.println("2) Matricular a un alumno en una asignatura. Deberás pedir el DNI del alumno y matricularlo en todas las asignaturas cuyo nombre esté contenido en un texto solicitado al usuario.");
            System.out.println("3) Actualiza el email de todos los alumnos al dominio que se solicite (por ejemplo, @g.educaand.es).");
            System.out.println("4) Eliminar a un alumno por su DNI, incluyendo su eliminación de la tabla “matricula”.");

            int opcion;
            System.out.print("Introduce opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();  // Consumir la nueva línea restante

            String dni, nombre, apellidos, direccion, mail;
            do { 
                
            } while (true);
            switch (opcion) {
                case 1:
                    String fechaNacimiento = "2023-03-15"; // Fecha fija

                    // Leer datos del usuario
                    System.out.print("Introduce DNI: ");
                    dni = sc.nextLine();
                    System.out.print("Introduce nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Introduce apellidos: ");
                    apellidos = sc.nextLine();
                    System.out.print("Introduce direccion: ");
                    direccion = sc.nextLine();
                    System.out.print("Introduce mail: ");
                    mail = sc.nextLine();

                    // Construir la consulta SQL directamente con los datos ingresados
                    String sqlInsert = "INSERT INTO alumno VALUES ('" + dni + "', '" + nombre + "', '" + apellidos + "', '" + fechaNacimiento + "', '" + direccion + "', '" + mail + "')";

                    // Ejecutar la consulta
                    Statement stmt = conexion.createStatement();
                    int rowsAffected = stmt.executeUpdate(sqlInsert);
                    System.out.println("Filas afectadas: " + rowsAffected);
                    break;
                case 2:
                    String asignatura;
                    int nota;
                    System.out.print("Introduce DNI: ");
                    dni=sc.nextLine();
                    System.out.print("Introduce asignatura: ");
                    asignatura=sc.nextLine();
                    do { 
                        System.out.print("Introduce la nota: ");
                        nota=sc.nextInt();
                    } while (nota<0 || nota>10);
                    String sqlInsert2 = "INSERT INTO matricula VALUES('"+dni+"',(SELECT idAsignatura FROM asignatura WHERE nombre='"+asignatura+"'),"+nota+" );";
                    Statement stmt2 = conexion.createStatement();
                    int rowsAffected2 = stmt2.executeUpdate(sqlInsert2);
                    System.out.println("Filas afectadas: " + rowsAffected2);
                    break;
                case 3:
                    break;
                case 4:
                    break
                default:
                    throw new AssertionError("Opción no válida.");
            }

            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
}
