import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Persona {
    /**
     * Constructor por defecto
     */
    public Persona(){
        this.nombre="Prueba2";
        this.apellidos="Apellidos2";
        this.fNac=LocalDate.of(2024, 12, 12);
    }

    /**
     * Constructor de copia
     */
    public Persona(String nombre, String apellidos, LocalDate fnac){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fNac=fnac;
    }
    
    public boolean comparador(Persona p2) {
        if(this.nombre == p2.nombre && this.apellidos == p2.apellidos && this.fNac == p2.fNac)
            return true;
        else
            return false;
    }

    public boolean comparador2(Persona p2) {
        if(this.nombre.equals(p2.nombre) && this.apellidos.equals(p2.apellidos) && this.fNac.equals(p2.fNac))
            return true;
        else
            return false;
    }

    /**
     * Ponemos los setters de los parametros
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFNac(LocalDate fNac) {
        this.fNac = fNac;
    }

    /**
     * Ponemos los getters de los parametros
     */
    public String getNombre(){
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public LocalDate getfNac() {
        return fNac;
    }

    /**
     * Ponemos los atributos 
     */
    private String nombre;
    private String apellidos;
    private LocalDate fNac;
}

public class CrearPersona{
    public static void main(String[] args) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("d/MM/uuuu");
        
        System.out.println("--- Datos Persona 1 ---");
        Persona p1 = new Persona();
        System.out.println(p1.getNombre());
        System.out.println(p1.getApellidos());
        System.out.println(p1.getfNac().format(formatoFecha).toString());

        System.out.println("\n--- Datos Persona 2 ---");
        LocalDate fechaPrueba=LocalDate.of(2024, 12, 12);
        Persona p2 = new Persona("Prueba2","Apellidos2",fechaPrueba);
        System.out.println(p2.getNombre());
        System.out.println(p2.getApellidos());
        System.out.println(p2.getfNac().format(formatoFecha).toString());

        System.out.println("\n--- Datos Persona 3 ---");
        LocalDate fechaPrueba2=LocalDate.of(2001, 07, 02);
        Persona p3 = new Persona("Sergio","Trillo",fechaPrueba2);
        System.out.println(p3.getNombre());
        System.out.println(p3.getApellidos());
        System.out.println(p3.getfNac().format(formatoFecha).toString());

        System.out.println("\n --- Resultados ---");
        System.out.println("-- Comparador ");
        System.out.println("Comparamos p1 y p2");
        if (p1.comparador(p2) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        System.out.println("Comparamos p1 y p3");
        if (p1.comparador2(p3) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        System.out.println("\n-- Comparador2 ");
        System.out.println("Comparamos p1 y p2");
        if (p1.comparador2(p2) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");

        System.out.println("Comparamos p1 y p3");
        if (p1.comparador2(p3) == true)
            System.out.println("Los objetos son iguales");
        else
            System.out.println("Los objetos son distintos");
    }
}