import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Vista {
    public static String URL = "jdbc:sqlite:chinook.db";
    private JButton verArtistas;
    private JButton verAlbumArtista;
    private JButton insertarAlbum;
    private JButton actualizarAlbum;
    private JButton eliminarAlbum;
    private JPanel panel1;

    public static boolean ejecutarSQLDesdeArchivo(String archivoSQL) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoSQL))) {
            StringBuilder sqlCompleto = new StringBuilder();
            String linea;

            try (Connection conexion = DriverManager.getConnection(URL)) {
                Statement stmt = conexion.createStatement();

                while ((linea = br.readLine()) != null) {
                    sqlCompleto.append(linea).append("\n");

                    if (linea.trim().endsWith(";")) {
                        try {
                            stmt.execute(sqlCompleto.toString());
                            sqlCompleto.setLength(0);
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

    public Vista() {
        Scanner sc = new Scanner(System.in);


        JFrame frame = new JFrame("panel1");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        verArtistas.addActionListener(e -> {
            try{
                if (ejecutarSQLDesdeArchivo("./chinook.sql"))
                    ejecutarSQLDesdeArchivo("./chinook.sql");
                else
                    System.out.println("Se ha cargado anteriormente");
                Connection conexion = DriverManager.getConnection(URL);
                String nombreArtista;
                System.out.print("Introduce nombre artista: ");
                nombreArtista = sc.nextLine();

                String sql = "SELECT albums.AlbumId, albums.Title FROM albums,artists WHERE albums.ArtistId=artists.ArtistId AND artists.Name='"+nombreArtista+"'";

                int albumID;
                String tituloAlbum;
                Statement stmt = conexion.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    albumID=rs.getInt("AlbumId");
                    tituloAlbum=rs.getString("Title");
                    System.out.println(albumID + "\t" + tituloAlbum);
                }

                conexion.close();
            }  catch (SQLException ex) {
                System.out.println("Error al hacer el select: "+ex.getErrorCode());

            }

        });
    }
}
