import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

import com.google.gson.*;
import java.io.*;


public class Vista {
    private JPanel panel1;
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
    private JLabel nombre;
    private JLabel telefono;
    private JLabel correo;
    private JButton eliminarContacto;
    private JButton importar;
    private JButton exportar;
    private JPanel datos;

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
            frame.setSize(650, 600);
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
                    String rutaImagen = imagen.getAbsolutePath();

                    ImageIcon original = new ImageIcon(rutaImagen);
                    Image escalada = original.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon iconoFinal = new ImageIcon(escalada);

                    fotosPorContacto.put(contactoActual, iconoFinal);
                    fotoLabel.setIcon(iconoFinal);

                    subirFotoButton.setVisible(false);
                    fotoYaSubida = true;

                    // Guardar ruta en base de datos
                    String nombreContacto = contactoActual.getText().trim();
                    try {
                        String sql = "UPDATE usuarios SET foto = ? WHERE nombre = ?";
                        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                            pstmt.setString(1, rutaImagen);
                            pstmt.setString(2, nombreContacto);
                            pstmt.executeUpdate();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al guardar la ruta de la foto: " + ex.getMessage());
                    }

                    contactoActual = null;
                }
            });


            eliminarContacto.addActionListener(e -> {
                if (contactoActual == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un contacto para eliminar.");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este contacto?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    contactoActual.setText("");
                    if (contactoActual == nombre1) {
                        tlfn1.setText("");
                        correo1.setText("");
                    } else if (contactoActual == nombre2) {
                        tlfn2.setText("");
                        correo2.setText("");
                    } else if (contactoActual == nombre3) {
                        tlfn3.setText("");
                        correo3.setText("");
                    } else if (contactoActual == nombre4) {
                        tlfn4.setText("");
                        correo4.setText("");
                    }

                    String nombreContacto = contactoActual.getText().trim();
                    if (!nombreContacto.isEmpty()) {
                        try  {
                            String sql = "DELETE FROM usuarios WHERE nombre = ?";
                            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                                pstmt.setString(1, nombreContacto);
                                int rowsAffected = pstmt.executeUpdate();
                                if (rowsAffected > 0) {
                                    JOptionPane.showMessageDialog(null, "Contacto eliminado con éxito.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontró el contacto en la base de datos.");
                                }
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el contacto: " + ex.getMessage());
                        }
                    }
                    fotoLabel.setIcon(null);
                    fotoYaSubida = false;
                    contactoActual = null;
                }
            });

            exportar.addActionListener(e -> {
                ArrayList<Usuarios> us = new ArrayList<>();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};
                JTextArea[] telefonos = {tlfn1, tlfn2, tlfn3, tlfn4};
                JTextArea[] correos = {correo1, correo2, correo3, correo4};

                for (int i = 0; i < 4; i++) {
                    String nombre = nombres[i].getText().trim();
                    String telefono = telefonos[i].getText().trim();
                    String correo = correos[i].getText().trim();

                    if (!nombre.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
                        String rutaFoto = "";
                        ImageIcon icon = fotosPorContacto.get(nombres[i]);
                        if (icon != null) {
                            // Obtener ruta de la foto desde la base de datos
                            try  {
                                String sql = "SELECT foto FROM usuarios WHERE nombre = ?";
                                try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                                    pstmt.setString(1, nombre);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        if (rs.next()) {
                                            rutaFoto = rs.getString("foto");
                                        }
                                    }
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Error al obtener ruta de foto: " + ex.getMessage());
                            }
                        }

                        try {
                            int telefonoInt = Integer.parseInt(telefono);
                            us.add(new Usuarios(nombre, telefonoInt, correo));
                        } catch (NumberFormatException ex) {
                            System.out.println("Número inválido para contacto: " + nombre);
                        }
                    }
                }

                String usuariosJSON = gson.toJson(us);

                try (FileWriter fw = new FileWriter("usuarios.json")) {
                    fw.write(usuariosJSON);
                    JOptionPane.showMessageDialog(null, "Contactos exportados correctamente a 'usuarios.json'.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar archivo JSON: " + ex.getMessage());
                }
            });


            datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
            setupNombreClickListeners();

        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    private boolean insertarContactoSiVacio(JTextArea nombreArea, JTextArea tlfnArea, JTextArea correoArea, String nombre, String telefono, String correo, Connection conexion, int telefonoInt) throws SQLException {
        if (isEmpty(nombreArea)) {
            nombreArea.setText(nombre);
            tlfnArea.setText(telefono);
            correoArea.setText(correo);
            contactoActual = nombreArea;
            subirFotoButton.setVisible(true);

            String sql = "INSERT INTO usuarios (nombre, numero, correo, foto) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setInt(2, telefonoInt);
                pstmt.setString(3, correo);
                pstmt.setString(4, ""); // por ahora sin foto
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
             ResultSet rs = stmt.executeQuery("SELECT nombre, numero, correo, foto FROM usuarios LIMIT 4")) {

            int index = 0;
            while (rs.next() && index < 4) {
                String nombre = rs.getString("nombre");
                int numero = rs.getInt("numero");
                String correo = rs.getString("correo");
                String rutaFoto = rs.getString("foto");

                nombres[index].setText(nombre);
                telefonos[index].setText(String.valueOf(numero));
                correos[index].setText(correo);

                if (rutaFoto != null && !rutaFoto.trim().isEmpty()) {
                    ImageIcon original = new ImageIcon(rutaFoto);
                    Image escalada = original.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    fotosPorContacto.put(nombres[index], new ImageIcon(escalada));
                }

                index++;
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }



    private void setupNombreClickListeners() {
        JTextArea[] nombres = {nombre1, nombre2, nombre3, nombre4};
        JTextArea[] telefonos = {tlfn1, tlfn2, tlfn3, tlfn4};
        JTextArea[] correos = {correo1, correo2, correo3, correo4};

        for (int i = 0; i < nombres.length; i++) {
            int index = i;
            nombres[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    contactoActual = nombres[index];  // guardar cuál contacto está activo
                    datos.removeAll();  // limpiar el panel

                    // Mostrar la foto
                    ImageIcon icon = fotosPorContacto.get(nombres[index]);
                    if (icon != null) {
                        fotoLabel.setIcon(icon);
                    } else {
                        fotoLabel.setIcon(null);
                    }

                    // Añadir los componentes al panel `datos`
                    datos.add(fotoLabel);

                    JLabel nombreLabel = new JLabel("Nombre: " + nombres[index].getText());
                    JLabel telefonoLabel = new JLabel("Teléfono: " + telefonos[index].getText());
                    JLabel correoLabel = new JLabel("Correo: " + correos[index].getText());

                    // Espaciado opcional
                    nombreLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
                    telefonoLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
                    correoLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

                    datos.add(nombreLabel);
                    datos.add(telefonoLabel);
                    datos.add(correoLabel);

                    datos.revalidate();  // actualizar el layout
                    datos.repaint();     // redibujar
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