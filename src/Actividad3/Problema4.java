package Actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema4 {
    // Lea el día, mes y año de una fecha cualquiera e imprima la fecha del día siguiente

    // Ejemplo: si la fecha leída es 24/3/2010, entonces, la fecha del día siguiente es 25/3/2010

    // NOTA: Tome en cuenta los siguientes elementos:

    // Los años bisiestos son múltiplos de 4.
    // Hay meses que tienen 30 ó 31 días
    // El cambio de año.

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String fecha = leer.readLine();
        int dia = Integer.parseInt(fecha.substring(0, fecha.indexOf("/")));
        fecha = fecha.substring(fecha.indexOf("/")+1);
        int mes = Integer.parseInt(fecha.substring(0, fecha.indexOf("/")));
        int año = Integer.parseInt(fecha.substring(fecha.indexOf("/")+1));
        dia++;
        int cantidadDiasPorMes;
        int cantidadMesesPorAño = 12;
        if (mes == 2)
            if(año % 4 == 0)
                cantidadDiasPorMes = 29;
            else
                cantidadDiasPorMes = 28;
        else if (mes <= 7 && mes % 2 == 1 || mes >= 8 && mes % 2 == 0)
            cantidadDiasPorMes = 31;
        else
            cantidadDiasPorMes = 30;
        if(dia > cantidadDiasPorMes){
            dia = dia % cantidadDiasPorMes;
            mes++;
            if (mes > cantidadMesesPorAño){
                año += mes / cantidadMesesPorAño;
                mes = mes % cantidadMesesPorAño;
            }
        }
        System.out.println(dia + "/" + mes + "/" + año);
    }
}
