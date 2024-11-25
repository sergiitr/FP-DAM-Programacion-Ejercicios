package tarea03;
import java.text.SimpleDateFormat;
import java.util.Date;
import libtarea3.*;

/**
 * Ejercicio 2
 * @author Sergio Trillo Rodriguez
 */
public class TRSergioControlador {
    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        int navesVolando=0;
        int sumaMins = 0;
        float sumaHoras = 0;
        
        //----------------------------------------------
        //          Creación de objetos
        //----------------------------------------------
        Aeropuerto aeropuerto1 = new Aeropuerto("El Prats", "Barcelona");
        Aeropuerto aeropuerto2 = new Aeropuerto("Barajas", "Madrid");
        Aeropuerto aeropuerto3 = new Aeropuerto("Federico Garcia Lorca", "Granada");
        
        Aeronave Avion1 = new Aeronave();
        Aeronave Avion2 = new Aeronave("EC-123","Boig747");
        Aeronave Avion3 = new Aeronave("EC-456","Boing787",aeropuerto2);

        //----------------------------------------------
        //   Inicio de la secuencia de instrucciones
        //----------------------------------------------
        Date fechaHoy = new Date();
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");        
        String fechaHoraActual = formatoFechaHora.format(fechaHoy);
        
        //Avion1 despega con velocidad 1500, altitud 1750, rumbo 50 y fechaHora actual
        Avion1.despegar(1500,1750,50, fechaHoraActual);
        System.out.printf("Avion1 ha despegado\n");
        
        //Avion2 despega con velocidad 1500, altitud 1850 y rumbo 75
        Avion2.despegar(1500,1850,75, fechaHoraActual);
        System.out.printf("Avion2 ha despegado\n");
        
        //Avion3 despega con velocidad 1500, altitud 1000 y rumbo 180
        Avion3.despegar(1500,1000,180, fechaHoraActual);
        System.out.printf("Avion3 ha despegado\n");
        
        //Comprobar si Avion1 está volando
        if (Avion1.isVolando() == true)
            System.out.printf("El avion1 esta volando\n");
        else
            System.out.printf("El avion2 NO esta volando\n");
        
        //Mostrar la matrícula del Avion2
        System.out.printf("La matricula del avion2 es: %s\n",Avion2.getMatricula());
        
        //Mostrar modelo del Avion3
        System.out.printf("El modelo del avion3 es: %s\n",Avion3.getModelo());
        
        //Modificar rumbo del Avion2 a 90º y mostrarlo
        Avion2.setRumbo(90);
        System.out.printf("El nuevo rumbo es: %dº\n",Avion2.getRumbo());
        
        //Avion3 aterriza en el aeropuerto de Barcelona despues de 75 minutos
        Avion3.aterrizar(aeropuerto1, 75);
        System.out.printf("Avion3 ha aterrizado\n");
        
        //Avion2 aterriza en el aeropuerto de Madrid despues de 80 minutos
        Avion2.aterrizar(aeropuerto2, 80);
        System.out.printf("Avion2 ha aterrizado\n");
        
        //Comprobar si Avion2 está volando
        if (Avion2.isVolando()==true)
            System.out.printf("El avion 2 esta volando\n");
        else
            System.out.printf("El avion 2 NO esta volando\n");
        
        //Modificar altitud del Avion1 a 1250 metros y mostrarlo
        Avion1.setAltitud(1250);
        System.out.printf("La nueva altitud del avion1 es: %dm\n",Avion1.getAltitud());
        
        //Mostrar el tiempo total de vuelo del Avion2
        System.out.printf("El tiempo de vuelo es de %d mins\n",Avion2.getTiempoTotalVuelo());
        
        //Mostrar el aeropuerto del Avion3
        System.out.printf("El aeropuerto del avion3 es: %s\n",Avion3.getAeropuerto());
        
        //Mostrar la fecha y hora de despegue del Avion1
        System.out.printf("La fecha y la hora de despegue del avion1 fue de: %s\n",Avion1.getFechaHoraDespegue());
        
        //Avion3 despega con velocidad 860, altitud 1420 y rumbo 270
        Avion3.despegar(860,1420,270, fechaHoraActual);
        System.out.printf("Avion3 ha despegado\n");
        //Avion1 aterriza en el aeropuerto de Granada despues de 260 minutos
        Avion1.aterrizar(aeropuerto3, 260);
        System.out.printf("Avion1 ha aterrizado\n");
        //Modificar velocidad del Avion3 a 950km/h y mostrarlo
        Avion3.setVelocidad(950);
        System.out.printf("La nueva velocidad del avion3 es de %dkm/h\n",Avion3.getVelocidad());
        
        //Mostrar el nombre del aeropuerto de Madrid
        System.out.printf("La ciudad del aeropuerto1 es: %s\n",aeropuerto1.getCiudad());
        
        //Mostrar el número de aeronaves en este momento en el aeropuerto de Granada
        System.out.printf("En Granada hay %d aviones\n",aeropuerto3.getNumeroAeronaves());
        
        //Mostrar toda la información del Avion1
        System.out.printf("Avion1: %s\n",Avion1.toString());
        //Mostrar toda la información del Avion2
        System.out.printf("Avion2: %s\n",Avion2.toString());
        //Mostrar toda la información del Avion3
        System.out.printf("Avion3: %s\n",Avion3.toString());
        
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
        
        System.out.printf("Ahora mismo hay %d naves volando\n",navesVolando);
        
        // Sumar el tiempo total de vuelo de todas las aeronaves en minutos
        sumaMins = Avion1.getTiempoTotalVuelo() + Avion2.getTiempoTotalVuelo() + Avion3.getTiempoTotalVuelo();
        sumaHoras = (float)sumaMins/60;
        System.out.printf("Tiempo total de aeronaves volando: %f horas.\n",sumaHoras);

        //Mostrar el número total de aeronaves
        System.out.printf("Hay un total de %d aeronaves\n",Avion1.getNumAeronaves());
    }
}