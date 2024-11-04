public class Empleado {
    public Empleado() {
        this.nombre = "Sergio";
        this.apellido = "Trillo";
        this.sueldo = 1200;
    }
    public Empleado(String nombre, String apellido, int sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getSueldo() {
        return sueldo;
    }
    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    

    @Override
    public String toString() {
        return nombre + "\t\t" + apellido + "\t\t" + sueldo + "€";
    }



    private String nombre;
    private String apellido;
    private int sueldo;
}
