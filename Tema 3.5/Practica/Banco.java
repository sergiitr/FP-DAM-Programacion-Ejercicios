public class Banco {
    public void agreagarCuenta(CuentaBancaria cuenta){
        this.cuentas[this.contador] = cuenta;
        System.out.println("Cuenta agregada con exito");
        this.contador++;
    }

    public CuentaBancaria buscaCuenta(int numero) {
        for (int i=0; i<this.contador; i++) 
            if ( this.cuentas[i].getNumeroCuenta() == numero )
                return this.cuentas[i];

        return null;
    } 

    public void listarCuentas() {
        if (this.contador==0)
            System.out.println("No hay cuentas disponibles");
        else
            for (int i=0; i<this.contador; i++) 
                System.out.println(this.cuentas[i].toString());
    }

    private CuentaBancaria[] cuentas = new CuentaBancaria[100];
    private int cantidadCuentas=100;
    private int contador=0;
}
