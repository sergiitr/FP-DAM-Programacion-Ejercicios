public class CuentaBancaria {
    public CuentaBancaria() {
        this.titular = "Sergio";
        this.saldo = 1000.0;
    }

    public CuentaBancaria(double saldo, String titular) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta+=this.contador;
        this.contador++;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            try {
                throw new MontoInvalidoException("Monto negativo");
            } catch (MontoInvalidoException ex) {
                System.out.println("Error: "+ ex.getMessage());
            }
        } else
            this.saldo += monto;
    }

    public void retirar(double monto) {
        if (monto > this.saldo) {

            try {
                throw new FondosInsuficientesException("Se queda negativo");
            } catch (FondosInsuficientesException ex) {
                System.out.println("Error: "+ ex.getMessage());
            }
        } else
            this.saldo -= monto;
    }

    public double mostrarSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaBancaria{");
        sb.append("titular=").append(titular);
        sb.append(", saldo=").append(saldo);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append('}');
        return sb.toString();
    }

    private String titular;
    private double saldo;
    private int numeroCuenta = 1000;
    private static int contador=0;

}

class MontoInvalidoException extends Exception {
    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}

class CuentaNoEncontradaException extends Exception {
    public CuentaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
