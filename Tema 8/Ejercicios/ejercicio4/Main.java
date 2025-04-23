// java -cp ./JAR/mysql-connector-j-9.3.0.jar ./Teoria/ejemplo1/Main.java
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            final String USUARIO="usuario";
            final String CONTRASENIA="usuario";
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
            opcion=sc.nextInt();
            switch (opcion) {
                case 1:
                    String dni,nombre,apellidos,direccion,mail;
                    int dia,mes,anio;
                    System.out.print("Introduce dia: ");
                    dia=sc.nextInt();
                    System.out.print("Introduce mes: ");
                    mesdia=sc.nextInt();
                    System.out.print("Introduce anio: ");
                    anio=sc.nextInt();
                    sc.nextInt();
                    Date fNac=new Date(anio, mes, dia);
                    System.out.print("Introduce DNI: ");
                    dni=sc.nextLine();
                    System.out.print("Introduce nombre: ");
                    nombre=sc.nextLine();
                    System.out.print("Introduce apellidos: ");
                    apellidos=sc.nextLine();
                    System.out.print("Introduce direccion: ");
                    direccion=sc.nextLine();
                    System.out.print("Introduce mail: ");
                    mail=sc.nextLine();

                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    throw new AssertionError();
            }


            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);
            while(rs.next()) {
                System.out.println(rs.getString("dni")+"\t"+rs.getString("NombreAlumno")+" "+rs.getString("totalAsignaturas"));   
            }
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
}