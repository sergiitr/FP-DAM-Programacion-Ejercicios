public class Estanteria {
    public void guardarLibro(Libro libro) {
        if(librosGuardados<CANT_LIBROS) {
            libros[librosGuardados]=libro;
        }
    }
    public void sacarLibro(Libro libro) {
        if(librosGuardados<CANT_LIBROS) {
            libros[librosGuardados]=null;
            librosGuardados--;
        }
    }

    private final int CANT_LIBROS=10;
    private Libros[CANT_LIBROS] libros;
    private int librosGuardados;
}
