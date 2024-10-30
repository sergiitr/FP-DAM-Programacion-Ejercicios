class Cilindro {
    /**
     * Valor de PI
     */
    public final double PI = 3.14;

    /**
     * Constructores
     */
    public Cilindro() {
        this.altura=2;
        this.radio=2;
    }
    public Cilindro(int altura, int radio) {
        this.altura = altura;
        this.radio = radio;
    }

    /**
     * Setters
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    /**
     * Getters
     */
    public int getAltura() {
        return altura;
    }
    public int getRadio() {
        return radio;
    }
    /**
     * Se calcula la superficie del cilindro
     * La formula que se utiliza es: 2πhr+2πr²
     * @return superficie
     */
    public double getSuperficie() {
        superficie=(2*PI*altura*radio)+(2*PI*radio*radio);
        return superficie;
    }
    /**
     * Se calcula el volumen del cilindro
     * La formula que se utiliza es: πr²
     * @return volumen
     */
    public double getVolumen() {
        volumen=PI*radio*radio*altura;
        return volumen;
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return "Cilindro [altura=" + altura + "cm, radio=" + radio + "cm, Superficie=" + getSuperficie() + "cm2, Volumen=" + getVolumen() + "cm3]";
    }

    /**
     * Atributos
     */
    private int altura;
    private int radio;
    private double superficie;
    private double volumen;
}