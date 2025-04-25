// --- NOTAS --- 
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
            Connection con;
            String url = "jdbc:mysql://localhost/academia";
            con = DriverManager.getConnection(url, USUARIO, CONTRASENIA);
            System.out.println("Conexión exitosa.");
            
            
            double notaCorte;
            String asignatura;

            System.out.print("Introduce nota de corte: ");
            notaCorte=sc.nextDouble();
            sc.nextLine();
            System.out.print("Introduce asignatura: ");
            asignatura=sc.nextLine();

            String sql = "SELECT dni,alumno.nombre FROM alumno,asignatura,matricula WHERE matricula.nota >= ? AND dni=dniAlumno AND asignatura.idAsignatura=matricula.idAsignatura AND asignatura.nombre=?;";
            PreparedStatement sentencia = con.prepareStatement(sql);

            sentencia.setDouble(1, notaCorte); 
            sentencia.setString(2, asignatura);
            ResultSet rs = sentencia.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("dni")+"\t"+rs.getString("nombre"));   
            }   
                
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
}

