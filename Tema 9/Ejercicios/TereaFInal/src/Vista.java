import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Vista {
    private JPanel panel;
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
    private JTextArea contactoActual; // Para saber a quién se le está asociando la foto
    private final Map<JTextArea, ImageIcon> fotosPorContacto = new HashMap<>();

    public String URL = "jdbc:mysql:usuarios.sql";
    public String USER = "usuario";
    public String PASSWORD = "usuario";
    
    public Vista() {

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa!");
        

            JFrame frame = new JFrame("Formulario");
            frame.setContentPane(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Ocultar el botón de subir foto al inicio
            subirFotoButton.setVisible(false);

            // Acción al pulsar "Agregar Contacto"
            agregarContacto.addActionListener(e -> {
                if (fotoYaSubida) {
                    JOptionPane.showMessageDialog(null, "Solo se puede subir la foto después de ingresar los datos del nuevo contacto.");
                    return;
                }

                String _nombre = JOptionPane.showInputDialog(null, "Introduce nombre del artista: ");
                String _tlfn = JOptionPane.showInputDialog(null, "Introduce número del artista: ");
                String _correo = JOptionPane.showInputDialog(null, "Introduce correo del artista: ");

                if (isEmpty(nombre1)) {
                    nombre1.setText(_nombre);
                    tlfn1.setText(_tlfn);
                    correo1.setText(_correo);
                    contactoActual = nombre1;
                    subirFotoButton.setVisible(true);
                    String sql = "INSERT INTO usuarios (nombre, numero, correo) VALUES ('"+nombre1+"','"+tlfn1+"','"+correo1+"')";
                    
                        
                    Statement pstmt = conexion.prepareStatement(sql);
                    
                } else if (isEmpty(nombre2)) {
                    nombre2.setText(_nombre);
                    tlfn2.setText(_tlfn);
                    correo2.setText(_correo);
                    contactoActual = nombre2;
                    subirFotoButton.setVisible(true);
                } else if (isEmpty(nombre3)) {
                    nombre3.setText(_nombre);
                    tlfn3.setText(_tlfn);
                    correo3.setText(_correo);
                    contactoActual = nombre3;
                    subirFotoButton.setVisible(true);
                } else if (isEmpty(nombre4)) {
                    nombre4.setText(_nombre);
                    tlfn4.setText(_tlfn);
                    correo4.setText(_correo);
                    contactoActual = nombre4;
                    subirFotoButton.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay más espacio para nuevos contactos.");
                }
            });

            // Acción al pulsar "Subir Foto"
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

                    // Asociar imagen con el contacto
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
                        fotoLabel.setIcon(null); // Si no hay foto, borrar la etiqueta
                    }
                }
            });
        }
    }

    private boolean isEmpty(JTextArea area) {
        return area.getText().trim().isEmpty();
    }

    // Método para inicializar el JLabel para la foto
    private void createUIComponents() {
        fotoLabel = new JLabel();
        fotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fotoLabel.setVerticalAlignment(SwingConstants.CENTER);
    }
}
