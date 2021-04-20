 /*
 *    @author krOzer
 */

import java.util.*;
public class Main {
    private static int hora, minutos, segundos;
    private static long time_start, time_end;
    public static void main(String []args){
        System.out.println((char)27 + "[37mInstituto Tecnologico de Oaxaca");
        System.out.println((char)27 + "[37m      Estructura de Datos");
        System.out.println((char)27 + "[37mAutores:Josue Ysai Martinez Morales\n\n");
        System.out.println((char)27 + "[30m PARA CERRAR EL SUPERMERCADO ESCRIBA *C* ");
        time_start = System.currentTimeMillis();
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        System.out.println("              " + hora + ":" + minutos + ":" + segundos);
        System.out.println((char)27 + "[30m       SuperMercado Esperanza\n" + "            ABIERTO, pase");
        Supermercado s = new Supermercado();
        System.out.println((char)27 + "[30m    Gracias por su preferencia, vuelva pronto");
        time_end = System.currentTimeMillis();
        System.out.println((char)27 + "[34mTiempo de ejecucion: "+ ( time_end - time_start) +" millisegundos");
        System.out.println("Clientes atendidos el dia de hoy: " + s.getclientesatendidos());
        System.out.println("Media de la cola de clientes: " + s.getClientestotal()/s.getclientesa());
        System.out.println("Total de clientes al dia: " + s.getClientestotal());
    }
}