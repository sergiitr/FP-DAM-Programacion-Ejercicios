class Cuenta {
    public Cuenta() {
    }

    public Cuenta(String titular, int cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    private String titular;
    private int cantidad;
}