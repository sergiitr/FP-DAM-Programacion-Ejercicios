import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int contQuijote=0, contSancho=0, contCardenio=0, contDulcinea=0, contRucio=0, contRocinante=0, contFierabras=0, contBarataria=0, contHamete=0;
        String rutaArchivo = "../Ficheros_actividades/Quijote.txt";
        ArrayList<String> palabras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(" ");
                String pal = campos[0].trim();
                if (pal.equals("Quijote") || pal.equals("Quijote,") && contQuijote==0){
                    palabras.add(pal);
                    contQuijote++;
                } else if (pal.equals("Quijote") || pal.equals("Quijote,") && contQuijote>0){
                    contQuijote++;
                } else if (pal.equals("Sancho") && contSancho==0){
                    palabras.add(pal);
                    contSancho++;
                } else if (pal.equals("Sancho") && contSancho>0){
                    contSancho++;
                } else if (pal.equals("Cardenio") && contCardenio==0){
                    palabras.add(pal);
                    contCardenio++;
                } else if (pal.equals("Cardenio") && contCardenio>0){
                    contCardenio++;
                } else if (pal.equals("Dulcinea") && contDulcinea==0){
                    palabras.add(pal);
                    contDulcinea++;
                } else if (pal.equals("Dulcinea") && contDulcinea>0){
                    contDulcinea++;
                } else if (pal.equals("Rucio") && contRucio==0){
                    palabras.add(pal);
                    contRucio++;
                } else if (pal.equals("Rucio") && contRucio>0){
                    contRucio++;
                } else if (pal.equals("Rocinante") && contRocinante==0){
                    palabras.add(pal);
                    contRocinante++;
                } else if (pal.equals("Rucio") && contRocinante>0){
                    contRocinante++;
                } else if (pal.equals("Fierabrás") && contRocinante==0){
                    palabras.add(pal);
                    contFierabras++;
                } else if (pal.equals("Fierabrás") && contRocinante>0){
                    contFierabras++;
                } else if (pal.equals("Barataria") && contBarataria==0){
                    palabras.add(pal);
                    contBarataria++;
                } else if (pal.equals("Fierabrás") && contBarataria>0){
                    contBarataria++;
                } else if (pal.equals("Hamete") && contHamete==0){
                    palabras.add(pal);
                    contHamete++;
                } else if (pal.equals("Hamete") && contHamete>0){
                    contHamete++;
                }
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }

        System.out.println(palabras);
        System.out.println("Contador Quijote: "+contQuijote);
        System.out.println("Contador Sancho: "+contSancho);
    }
}
