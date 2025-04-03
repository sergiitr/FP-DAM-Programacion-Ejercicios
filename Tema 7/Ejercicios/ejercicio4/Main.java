import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Palabras clave a buscar
        String[] palabrasClave = {
                "quijote", "sancho", "cardenio", "dulcinea", "rucio", 
                "rocinante", "fierabras", "barataria", "hamete"
        };
        
        // Inicializamos dos ArrayLists: uno para las palabras clave y otro para sus contadores
        ArrayList<String> listaPalabras = new ArrayList<>();
        ArrayList<Integer> listaContadores = new ArrayList<>();
        
        // Inicializamos las listas con las palabras clave y contadores en 0
        for (String palabra : palabrasClave) {
            listaPalabras.add(palabra);
            listaContadores.add(0);
        }
        
        // Ruta del archivo de entrada y salida
        String rutaArchivoEntrada = "../Ficheros_actividades/Quijote.txt";
        String rutaArchivoSalida = "informe_quijote.txt";
        
        // Expresión regular para separar palabras por cualquier espacio o signo de puntuación
        String regex = "[\\s,;.!?(){}\\[\\]:\"'-]+";
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoEntrada))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                
                // Separar la línea en palabras usando la expresión regular
                String[] palabras = linea.split(regex);
                
                // Contamos las ocurrencias de las palabras clave
                for (String palabra : palabras) {
                    palabra = palabra.trim().toLowerCase();  // Convertimos a minúsculas
                    
                    // Si la palabra no está vacía y es una palabra clave, incrementamos su contador
                    if (!palabra.isEmpty()) {
                        for (int i = 0; i < listaPalabras.size(); i++) {
                            if (listaPalabras.get(i).equals(palabra)) {
                                listaContadores.set(i, listaContadores.get(i) + 1);
                            }
                        }
                    }
                }
            }
            
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
            return;
        }
        
        // Generar el informe
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoSalida))) {
            // Escribimos el encabezado del informe
            bw.write("Informe de menciones en El Quijote\n\n");
            
            // Escribir los resultados de las palabras clave
            for (int i = 0; i < listaPalabras.size(); i++) {
                String descripcion = getDescripcion(listaPalabras.get(i));
                int contador = listaContadores.get(i);
                bw.write(descripcion + " aparece " + contador + " veces.\n");
            }
            
            System.out.println("Informe generado correctamente.");
            
        } catch (IOException ex) {
            System.err.println("Error al generar el informe: " + ex.getMessage());
        }
    }

    // Método para devolver la descripción de cada palabra clave
    public static String getDescripcion(String palabra) {
        switch (palabra) {
            case "quijote":
                return "Quijote, protagonista de la novela";
            case "sancho":
                return "Sancho, el fiel escudero";
            case "cardenio":
                return "Cardenio, personaje al que Don Quijote y Sancho Panza se encontraron cuando iban por un bosque de Sierra Morena";
            case "dulcinea":
                return "Dulcinea, la dama de quien está enamorado el protagonista Don Quijote";
            case "rucio":
                return "Rucio, el burro de Sancho Panza";
            case "rocinante":
                return "Rocinante, el caballo de Don Quijote";
            case "fierabras":
                return "Fierabrás, según Don Quijote, poción mágica capaz de curar todas las dolencias del cuerpo humano";
            case "barataria":
                return "Barataria, ínsula de la que fue gobernador Sancho Panza";
            case "hamete":
                return "Hamete, supuesto historiador musulmán";
            default:
                return "Palabra desconocida";
        }
    }
}
