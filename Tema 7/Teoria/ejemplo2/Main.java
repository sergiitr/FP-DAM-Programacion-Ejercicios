import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String texto = ""; // Declaramos la cadena fuera del try-catch para su acceso posterior
        FileReader in = null; // Declaramos FileReader fuera del try-catch
        String rutaArchivo = "C:\\Users\\usuario\\Desktop\\Programacion\\Tema 7\\Teoria\\ejemplo2\\texto.txt";
        
        try {
            in = new FileReader(rutaArchivo);
            int caracter;
            while ((caracter = in.read()) != -1) { // Leemos caracter a caracter
                texto += ((char) caracter); // Agregamos el caracter al texto
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        } finally {
            // Cerramos el flujo en cualquier caso
            if (in != null) {
                try {
                    in.close(); // Cerramos el flujo
                } catch (IOException ex) {
                    System.err.println("Error al cerrar el archivo: " + ex.getMessage());
                }
            }
        }
        String[] cantPalabras;
        cantPalabras = texto.split(" ");

        System.out.println("Hay "+cantPalabras.length+" palabras");
    }
}