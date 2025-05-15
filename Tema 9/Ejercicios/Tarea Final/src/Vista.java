import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.io.*;

public class Vista {
    private JPanel panel1;
    private JButton nombre;
    private JButton telefono;
    private JButton correo;
    private JTextArea nombre1;
    private JTextArea tlfn1;
    private JTextArea correo1;
    private JTextArea nombre2;
    private JTextArea tlfn2;
    private JTextArea correo2;
    private JTextArea nombre3;
    private JTextArea tlfn3;
    private JTextArea correo3;
    private JTextArea nombre4;
    private JTextArea tlfn4;
    private JTextArea correo4;
    private JButton agregarContacto;
    private JLabel fotoLabel;
    private JButton subirFotoButton;

    private boolean fotoYaSubida = false;
    private JTextArea contactoActual;
    private final Map<JTextArea, ImageIcon> fotosPorContacto = new HashMap<>();

    public static String URL = "jdbc:sqlite:usuarios.db";

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
                            System.out.println("Error al ejecutar SQL: " + e.getMessage());
                            sqlCompleto.setLength(0);
                        }
                    }
                }
                System.out.println("SQL ejecutado exitosamente.");
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }
        return true;
    }

    public Vista() {
        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("¡Conexión exitosa!");
            ejecutarSQLDesdeArchivo("usuarios.sql");

            JFrame frame = new JFrame("Agenda Contactos");
            frame.setContentPane(panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            subirFotoButton.setVisible(false);

            cargarContactosDesdeDB(conexion);

            agregarContacto.addActionListener(e -> {
                if (fotoYaSubida) {
                    JOptionPane.showMessageDialog(null, "Solo se puede subir la foto después de ingresar los datos del nuevo contacto.");
                    return;
                }

                String _nombre = JOptionPane.showInputDialog(null, "Introduce nombre del artista:");
                if (_nombre == null || _nombre.trim().isEmpty()) return;

                String _tlfn = JOptionPane.showInputDialog(null, "Introduce número del artista:");
                if (_tlfn == null || _tlfn.trim().isEmpty()) return;

                String _correo = JOptionPane.showInputDialog(null, "Introduce correo del artista:");
                if (_correo == null || _correo.trim().isEmpty()) return;

                int telefonoInt;
                try {
                    telefonoInt = Integer.parseInt(_tlfn.trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El teléfono debe ser un número válido.");
                    return;
                }

                try {
                    if (insertarContactoSiVacio(nombre1, tlfn1, correo1, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;
                    if (insertarContactoSiVacio(nombre2, tlfn2, correo2, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;
                    if (insertarContactoSiVacio(nombre3, tlfn3, correo3, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;
                    if (insertarContactoSiVacio(nombre4, tlfn4, correo4, _nombre, _tlfn, _correo, conexion, telefonoInt)) return;

                    JOptionPane.showMessageDialog(null, "No hay más espacio para nuevos contactos.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al guardar contacto en base de datos: " + ex.getMessage());
                }
            });

            subirFotoButton.addActionListener(e -> {
                if (contactoActual == null) return;

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Selecciona una foto");
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File imagen = fileChooser.getSelectedFile();
                    ImageIcon original = new ImageIcon(imagen.getAbsolutePath());
                    Image escalada = original.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon iconoFinal = new ImageIcon(escalada);

                    fotosPorContacto.put(contactoActual, iconoFinal);
                    fotoLabel.setIcon(iconoFinal);

                    subirFotoButton.setVisible(false);
                    fotoYaSubida = true;
                    contactoActual = null;
                }
            });

            setupNombreClickListeners();

        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    private boolean insertarContactoSiVacio(JTextArea nombreArea, JTextArea tlfnArea, JTextArea correoArea,
                                            String nombre, String telefono, String correo,
                                            Connection conexion, int telefonoInt) throws SQLException {

        if (isEmpty(nombreArea)) {
            nombreArea.setText(nombre);
            tlfnArea.setText(telefono);
            correoArea.setText(correo);
            contactoActual = nombreArea;
            subirFotoButton.setVisible(true);

            String sql = "INSERT INTO usuarios (nombre, numero, correo) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setInt(2, telefonoInt);
                pstmt.setString(3, correo);
                pstmt.executeUpdate();
            }

            return true;
        }
        return false;
    }

    private void cargarContactosDesdeDB(Connection conexion) {
        JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};
        JTextArea[] telefonos = {tlfn1, tlfn2, tlfn3, tlfn4};
        JTextArea[] correos = {correo1, correo2, correo3, correo4};

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT nombre, numero, correo FROM usuarios LIMIT 4")) {

            int index = 0;
            while (rs.next() && index < 4) {
                nombres[index].setText(rs.getString("nombre"));
                telefonos[index].setText(String.valueOf(rs.getInt("numero")));
                correos[index].setText(rs.getString("correo"));
                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void setupNombreClickListeners() {
        JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};

        for (JTextArea area : nombres) {
            area.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ImageIcon icon = fotosPorContacto.get(area);
                    if (icon != null) {
                        fotoLabel.setIcon(icon);
                    } else {
                        fotoLabel.setIcon(null);
                    }
                }
            });
        }
    }

    private boolean isEmpty(JTextArea area) {
        return area.getText().trim().isEmpty();
    }

    private void createUIComponents() {
        fotoLabel = new JLabel();
        fotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fotoLabel.setVerticalAlignment(SwingConstants.CENTER);
    }
}
