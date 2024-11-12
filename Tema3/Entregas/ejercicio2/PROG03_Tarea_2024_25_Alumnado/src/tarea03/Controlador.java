package tarea03;
import java.text.SimpleDateFormat;
import java.util.Date;
import libtarea3.*;
// ------------------------------------------------------------
//                   Clase Controlador
// ------------------------------------------------------------
/**
 * <p>
 * Clase que representa al <strong>controlador</strong>,
 * que será la clase que utilizaremos y donde se escribirán las diferentes 
 * operaciones en aeronaves y aeropuertos que se nos pide en 
 * el enunciado de la tarea.</p>
 *
 * @author Sergio Trillo Rodriguez
 */
public class Controlador {
    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        int navesVolando=0;
        int sumaMins = 0;
        int sumaHoras = 0;
        int minutosRestantes = 0;
        int cantAeronaves=0;
        
        //----------------------------------------------
        //          Creación de objetos
        //----------------------------------------------
        Aeropuerto aeropuerto1 = new Aeropuerto("El Prats", "Barcelona");
        Aeropuerto aeropuerto2 = new Aeropuerto("Barajas", "Madrid");
        Aeropuerto aeropuerto3 = new Aeropuerto("Federico Garcia Lorca", "Granada");
        
        Aeronave Avion1 = new Aeronave();
        Aeronave Avion2 = new Aeronave("EC-123","Boig747");
        Aeronave Avion3 = new Aeronave("EC-456","Boing787",aeropuerto2);

       
        
        // Instanciar los 3 aeropuertos: Barcelona, Madrid, Granada.
        System.out.println("La ciudad del 1 aeropuerto es: "+aeropuerto1.getCiudad());
        System.out.println("La ciudad del 2 aeropuerto es: "+aeropuerto2.getCiudad());
        System.out.println("La ciudad del 3 aeropuerto es: "+aeropuerto3.getCiudad());
        // Instanciar las 3 aeronaves: Avion1, Avion2, Avion3.
        System.out.println(Avion1.toString());
        System.out.println(Avion2.toString());
        System.out.println(Avion3.toString());

        //----------------------------------------------
        //   Inicio de la secuencia de instrucciones
        //----------------------------------------------
        Date fechaHoy = new Date();
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
        String fechaHoraActual = formatoFechaHora.format(fechaHoy);
        
        //Avion1 despega con velocidad 1500, altitud 1750, rumbo 50 y fechaHora actual
        Avion1.despegar(1500,1750,50, fechaHoraActual);
        System.out.println(Avion1.getVelocidad());
        
        //Avion2 despega con velocidad 1500, altitud 1850 y rumbo 75
        Avion2.despegar(1500,1850,75, fechaHoraActual);
        System.out.println(Avion2.getVelocidad());
        
        //Avion3 despega con velocidad 1500, altitud 1000 y rumbo 180
        Avion3.despegar(1500,1000,180, fechaHoraActual);
        System.out.println(Avion3.getVelocidad());
        
        //Comprobar si Avion1 está volando
        if (Avion1.isVolando() == true)
            System.out.println("El avion1 esta volando");
        else
            System.out.println("El avion2 NO esta volando");
        
        //Mostrar la matrícula del Avion2
        System.out.println("La matricula del avion2 es: "+Avion2.getMatricula());
        
        //Mostrar modelo del Avion3
        System.out.println("El modelo del avion3 es: "+Avion3.getModelo());
        
        //Modificar rumbo del Avion2 a 90º y mostrarlo
        Avion2.setRumbo(90);
        System.out.println("El nuevo rumbo es: "+Avion2.getRumbo()+"º");
        
        //Avion3 aterriza en el aeropuerto de Barcelona despues de 75 minutos
        Avion3.aterrizar(aeropuerto1, 75);
        
        //Avion2 aterriza en el aeropuerto de Madrid despues de 80 minutos
        Avion2.aterrizar(aeropuerto2, 80);
        
        //Comprobar si Avion2 está volando
        if (Avion2.isVolando()==true)
            System.out.println("El avion 2 esta volando");
        else
            System.out.println("El avion 2 NO esta volando");
        
        //Modificar altitud del Avion1 a 1250 metros y mostrarlo
        Avion1.setAltitud(1250);
        System.out.println("La nueva altitud del avion1 es: "+Avion1.getAltitud()+"m");
        
        //Mostrar el tiempo total de vuelo del Avion2
        System.out.println("El tiempo de vuelo es de "+Avion2.getTiempoTotalVuelo()+"mins");
        
        //Mostrar el aeropuerto del Avion3
        System.out.println("El aeropuerto del avion3 es: "+Avion3.getAeropuerto());
        
        //Mostrar la fecha y hora de despegue del Avion1
        System.out.println("La fecha y la hora de despegue del avion1 fue de: "+Avion1.getFechaHoraDespegue());
        
        //Avion3 despega con velocidad 860, altitud 1420 y rumbo 270
        Avion3.despegar(860,1420,270, fechaHoraActual);
        
        //Avion1 aterriza en el aeropuerto de Granada despues de 260 minutos
        Avion1.aterrizar(aeropuerto3, 260);

        //Modificar velocidad del Avion3 a 950km/h y mostrarlo
        Avion3.setVelocidad(950);
        System.out.println("La nueva velocidad del avion3 es de "+Avion3.getVelocidad()+"km/h");
        
        //Mostrar el nombre del aeropuerto de Madrid
        System.out.println("La ciudad del aeropuerto1 es:"+aeropuerto1.getCiudad());
        
        //Mostrar el número de aeronaves en este momento en el aeropuerto de Granada
        System.out.println("En granada hay "+aeropuerto3.getNumeroAeronaves()+" aviones");
        
        //Mostrar toda la información del Avion1
        System.out.println(Avion1.toString());
        //Mostrar toda la información del Avion2
        System.out.println(Avion1.toString());
        //Mostrar toda la información del Avion3
        System.out.println(Avion1.toString());
        
        //----------------------------------------------
        //          Llamadas a métodos estáticos
        //----------------------------------------------
        //Mostrar el número total de aeronaves volando ahora mismo
        
        if (Avion1.isVolando()==true)
            navesVolando+=1;
        if (Avion2.isVolando()==true)
            navesVolando+=1;
        if (Avion3.isVolando()==true)
            navesVolando+=1;
        
        System.out.println("Ahora mismo hay "+navesVolando+" naves volando");
        
        // Sumar el tiempo total de vuelo de todas las aeronaves en minutos
        
        sumaMins= Avion1.getTiempoTotalVuelo() + Avion2.getTiempoTotalVuelo() + Avion3.getTiempoTotalVuelo();
        sumaHoras = sumaMins/60;
        minutosRestantes= sumaMins%60;
        System.out.println("Tiempo total de aeronaves volando: " + sumaHoras + " horas y " + minutosRestantes + " minutos.");

        //Mostrar el número total de aeronaves
        cantAeronaves=Avion1.getNumAeronaves()+Avion2.getNumAeronaves()+Avion3.getNumAeronaves();
        System.out.println("Hay un total de "+cantAeronaves+" aeronaves");
    }
}
