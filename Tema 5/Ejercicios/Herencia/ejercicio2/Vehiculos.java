public class Vehiculos {
    public Vehiculos(String matricula, String modelo, int potenciaCV) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.potenciaCV = potenciaCV;
        this.impuestoCirculacion = 100;
    }
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getPotenciaCV() {
        return potenciaCV;
    }
    public void setPotenciaCV(int potenciaCV) {
        this.potenciaCV = potenciaCV;
    }
    public int getImpuestoCirculacion() {
        return impuestoCirculacion;
    }
    public void setImpuestoCirculacion(int impuestoCirculacion) {
        this.impuestoCirculacion = impuestoCirculacion;
    }

    protected int impuestoCirculacion;
    protected String matricula;
    protected String modelo;
    protected int potenciaCV;

}
