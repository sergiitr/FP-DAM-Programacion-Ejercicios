public class Taxi extends Vehiculos {
    public Taxi(String matricula, String modelo, int potenciaCV, int numeroLicencia) {
        super(matricula, modelo, potenciaCV);
        this.numeroLicencia = numeroLicencia;
    }
    
    public int getNumeroLicencia() {
        return numeroLicencia;
    }
    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    
    public double getImpuestoCirculacion() {
        return super.impuestoCirculacion = (double)super.impuestoCirculacion+super.impuestoCirculacion*0.1;
    }
    
    private int numeroLicencia;
}