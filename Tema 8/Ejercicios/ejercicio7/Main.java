import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void verAlbunesArtista() {
        Scanner sc = new Scanner(System.in);
        String URL = "jdbc:sqlite:chinook.db";
        Connection conexion = DriverManager.getConnection(URL);
        System.out.println("Conexión exitosa.");

        try{
            String nombreArtista;
            System.out.print("Introduce nombre artista: ");
            nombreArtista = sc.nextLine();
            // Leer datos
            String sql = "SELECT albums.* FROM albums,artists WHERE albumns.ArtistId=artists.ArtistId AND artists.Name="+nombreArtista;
            
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("ArtistId") + "\t" + rs.getString("Name"));
            }
            
            conexion.close();
        }  catch (SQLException ex) {
            System.out.println("Error al hacer el select");
            ex.printStackTrace();
        }
    }

    public static void verArtista() {
        String URL = "jdbc:sqlite:chinook.db";
        Connection conexion = DriverManager.getConnection(URL);
        System.out.println("Conexión exitosa.");

        try{
            Statement stmt = conexion.createStatement();
            // Leer datos
            String sql = "SELECT * FROM artists";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("ArtistId") + "\t" + rs.getString("Name"));
            }
            
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al hacer el select");
            ex.printStackTrace();
        }
    }

    public static void insertarAlbum() {
        String URL = "jdbc:sqlite:chinook.db";
        Connection conexion = DriverManager.getConnection(URL);
        System.out.println("Conexión exitosa.");
        try {
            String sql = "INSERT INTO albums(Title,ArtistId) VALUES()";
            Statement stmt = conexion.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Filas afectadas: " + rowsAffected);
        } catch (SQLException ex) {
            System.out.println("Error al hacer el select");
            ex.printStackTrace();
        }
    }

    public static void actualizarAlbum() {
        Scanner sc = new Scanner(System.in);
        String URL = "jdbc:sqlite:chinook.db";
        Connection conexion = DriverManager.getConnection(URL);
        System.out.println("Conexión exitosa.");
        String nuevoNombre, antiguoNombre;
        System.out.print("Introduce album q quieras actualizar nombre: ");
        nuevoNombre=sc.nextLine();
        System.out.print("Introduce nuevo nombre: ");
        antiguoNombre=sc.nextLine();
        try {
            String sql = "UPDATE albums SET Title='"+nuevoNombre+"' WHERE Title='"+antiguoNombre+"'";
            Statement stmt = conexion.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Filas afectadas: " + rowsAffected);
        } catch (SQLException ex) {
            System.out.println("Error al hacer el select");
            ex.printStackTrace();
        }
    }

    public static void eliminarAlbum() {
        Scanner sc = new Scanner(System.in);
        String URL = "jdbc:sqlite:chinook.db";
        Connection conexion = DriverManager.getConnection(URL);
        System.out.println("Conexión exitosa.");
        String nombreAlbum;
        System.out.print("Introduce nombre album que quieras eliminar: ");
        nombreAlbum=sc.nextLine();
        
        try {
            String sql = "DELETE FROM albums WHERE Title='"+nombreAlbum;
            Statement stmt = conexion.createStatement();
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println("Filas afectadas: " + rowsAffected);
        } catch (SQLException ex) {
            System.out.println("Error al hacer el select");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String URL = "jdbc:sqlite:chinook.db";
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");

            int opcion;
            System.out.println("1.- Ver artistas");
            System.out.println("2.- Ver albunes");
            System.out.println("3.- Insertar albun");
            System.out.println("4.- Actalizar album");
            System.out.println("5.- Eliminar album");
            System.out.println("6.- Salir");

            do {
                System.out.print("Introduce opcion: ");
                opcion=sc.nextInt();
            } while(opcion<1 || opcion>6);
            switch (opcion) {
                case 1:
                    verArtista();
                    break;
                case 2:
                    verAlbunesArtista();
                    break;
                case 3:
                    insertarAlbum();
                    break;
                case 4:
                    actualizarAlbum();
                    break;
                case 5:
                    eliminarAlbum();
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
    }
}