public class Autobus extends Vehiculos {
    public Autobus(int numeroPlazas, String matricula, String modelo, int potenciaCV) {
        super(matricula, modelo, potenciaCV);
        this.numeroPlazas = numeroPlazas;
    }
    
    public int getNumeroPlazas() {
        return numeroPlazas;
    }
    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }
    
    private int numeroPlazas;
}