public class Coche {
    public Coche(String matricula, String marca ,String modelo) {
        this.marca = marca;
        this.matricula = matricula;
        this.modelo = modelo;
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
   
    private String matricula;
    private String marca;
    private String modelo;
}