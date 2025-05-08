import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static String URL = "jdbc:sqlite:chinook.db";
    
    /**
     * Abrir conexion de la base de datos
     * @param archivoSQL
     */
    public static boolean ejecutarSQLDesdeArchivo(String archivoSQL) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoSQL))) {
            StringBuilder sqlCompleto = new StringBuilder();
            String linea;
            
            try (Connection conexion = DriverManager.getConnection(URL)) {
                System.out.println("Conexión exitosa.");
                Statement stmt = conexion.createStatement();
                
                while ((linea = br.readLine()) != null) {
                    // Concatenamos la línea al StringBuilder
                    sqlCompleto.append(linea).append("\n");
                    
                    if (linea.trim().endsWith(";")) {
                        try {
                            stmt.execute(sqlCompleto.toString());
                            sqlCompleto.setLength(0);  // Limpiamos el StringBuilder para la siguiente sentencia
                        } catch (SQLException e) {
                            return false;
                            //System.out.println("Error al ejecutar SQL: " + e.getMessage());
                        }
                    }
                }
                System.out.println("SQL ejecutado exitosamente.");
            } catch (SQLException e) {
                return false;
                //System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return true;
    }

    /**
     * Ver album por Artista
     */
    public static void verAlbunesArtista() {
        Scanner sc = new Scanner(System.in);
        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");
            try{
                String nombreArtista;
                System.out.print("Introduce nombre artista: ");
                nombreArtista = sc.nextLine();

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
            
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }

    }

    /**
     * Ver Artistas
     */
    public static void verArtista() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");
    
            try{
                // Leer datos
                String sql = "SELECT * FROM artists";
                Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("ArtistId") + "\t" + resultSet.getString("Name"));
                }
                
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    /**
     * Insertar nuevo Album
     */
    public static void insertarAlbum() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");
            try {
                String sql = "INSERT INTO albums(Title,ArtistId) VALUES()";
                PreparedStatement statement = conexion.prepareStatement(sql);
                int rowsAffected = statement.executeUpdate(sql);
                System.out.println("Filas afectadas: " + rowsAffected);
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
            
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    /**
     * Actualizar Alum
     */
    public static void actualizarAlbum() {
        Scanner sc = new Scanner(System.in);
        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");
            String nuevoNombre, antiguoNombre;
            System.out.print("Introduce album q quieras actualizar nombre: ");
            nuevoNombre=sc.nextLine();
            System.out.print("Introduce nuevo nombre: ");
            antiguoNombre=sc.nextLine();
            try {
                String sql = "UPDATE albums SET Title='"+nuevoNombre+"' WHERE Title='"+antiguoNombre+"'";
                PreparedStatement statement = conexion.prepareStatement(sql);
                int rowsAffected = statement.executeUpdate(sql);
                System.out.println("Filas afectadas: " + rowsAffected);
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
            
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    /**
     * Eliminar Album
     */
    public static void eliminarAlbum() {
        try {
            
            Scanner sc = new Scanner(System.in);
            
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");
            String nombreAlbum;
            System.out.print("Introduce nombre album que quieras eliminar: ");
            nombreAlbum=sc.nextLine();
            
            try {
                String sql = "DELETE FROM albums WHERE Title='"+nombreAlbum;
                PreparedStatement statement = conexion.prepareStatement(sql);
                int rowsAffected = statement.executeUpdate(sql);
                System.out.println("Filas afectadas: " + rowsAffected);
            } catch (SQLException ex) {
                System.out.println("Error al hacer el select");
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Conexion no exitosa");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (ejecutarSQLDesdeArchivo("chinook.sql"))
            ejecutarSQLDesdeArchivo("chinook.sql"); 
        else
            System.out.println("Se ha cargado anterirmente");
        int opcion;
        try {
            do { 
                Connection conexion = DriverManager.getConnection(URL);
                System.out.println("Conexión exitosa.");
    
                System.out.println("1.- Ver artistas");
                System.out.println("2.- Ver albunes");
                System.out.println("3.- Insertar albun");
                System.out.println("4.- Actalizar album");
                System.out.println("5.- Eliminar album");
                System.out.println("6.- Salir");
    
                do {
                    System.out.print("Introduce opcion: ");
                    opcion = sc.nextInt();
                } while (opcion < 1 || opcion > 6);
                
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
                    case 6:
                        System.out.println("Final del programa");
                        break;
                }
            } while (opcion!=6);
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos.");
            ex.printStackTrace();
        }
                
    }
}
