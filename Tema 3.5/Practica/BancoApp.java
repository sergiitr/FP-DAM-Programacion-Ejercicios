public class BancoApp {
    public static void main(String[] args) {
        CuentaBancaria c1 = new CuentaBancaria(110, "Sergio");
        CuentaBancaria c2 = new CuentaBancaria(220, "David");
        CuentaBancaria c3 = new CuentaBancaria(330, "Jesus");

        Banco banco1 = new Banco();
        banco1.agreagarCuenta(c1);
        banco1.agreagarCuenta(c2);
        banco1.agreagarCuenta(c3);

        banco1.listarCuentas();

        
    }
}
