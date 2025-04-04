import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Alumnos> alumnos = new ArrayList<>();
        boolean auxAlumnos=true;
        do {
            String nombre;
            int edad;
            double notaMedia;
            System.out.print("Introduce nombre (fin para acabar): ");
            nombre=sc.nextLine();
            System.out.print("Introduce edad: ");
            edad=sc.nextInt();
            sc.nextLine();
            System.out.print("Introduzca nota media: ");
            notaMedia=sc.nextDouble();
            sc.nextLine();
            if(!nombre.equals("fin")){
                Alumnos al = new Alumnos(nombre, edad, notaMedia);
                alumnos.add(al);
            } else
                auxAlumnos=false;
        } while (auxAlumnos);
        System.out.println(alumnos);

        // Ficheros salida
        ObjectOutputStream flujoSalida = null;
        // -- Aprobados
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream("alumnosAprobados.dat"));
            for (int i=0; i<alumnos.size(); i++) {
                if (alumnos.get(i).getNotaMedia()>=5.0) {
                    flujoSalida.writeObject(alumnos.get(i));
                }
            }
        } catch (IOException ex) {
            System.out.println("Hola");
            System.out.println(ex);
        } finally {
            if (flujoSalida != null) {
                try {
                    flujoSalida.close();
                } catch (IOException ex) {
                    System.out.println("Adios");
                    System.out.println(ex);
                }
            }
        }

        flujoSalida = null;
        // -- Suspensos
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream("alumnosSuspensos.dat"));
            for (int i=0; i<alumnos.size(); i++) {
                if (alumnos.get(i).getNotaMedia()<5.0) {
                    flujoSalida.writeObject(alumnos.get(i));
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (flujoSalida != null) {
                try {
                    flujoSalida.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
}