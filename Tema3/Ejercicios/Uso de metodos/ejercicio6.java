public class ejercicio6 {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Antonio", "Garcia", 16349);
        Empleado e2 = new Empleado("Manuel", "López", 23641);
        Empleado e3 = new Empleado("José", "Gómez", 18928);

        System.out.println("Nombre \t\tApellido \tSueldo");
        System.out.println(e1.toString()+"\n"+e2.toString()+"\n"+e3.toString()+"\n");
    }
}
