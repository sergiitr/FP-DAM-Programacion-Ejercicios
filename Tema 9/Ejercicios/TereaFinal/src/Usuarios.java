public class Usuarios {
    private String nombre;
    private int numero;
    private String correo;

    public Usuarios(String nombre, int numero,  String correo) {
        this.correo = correo;
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}