package Actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.text.DateFormatSymbols;

public class Problema6 {
    // Dada una fecha en formato día/mes/año determinar el número de días y el nombre del mes de dicha fecha, y sacar por pantalla la fecha convertida a formato de día “de” mes “de” año.
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String fecha = leer.readLine(); // 10/3/2010
        int dia = Integer.parseInt(fecha.substring(0, fecha.indexOf("/")));// 10
        fecha = fecha.substring(fecha.indexOf("/")+1); // 3/2010 
        int mes = Integer.parseInt(fecha.substring(0, fecha.indexOf("/")));// 3
        int año = Integer.parseInt(fecha.substring(fecha.indexOf("/")+1));// 2010
        //String nombreMes = new DateFormatSymbols().getMonths()[mes-1];
        String nombreMes = "";
        if(mes==1)
            nombreMes = "enero";
        if(mes==2)
            nombreMes = "febrero";
        if(mes==3)
            nombreMes = "marzo";
        if(mes==4)
            nombreMes = "abril";
        if(mes==5)
            nombreMes = "mayo";
        if(mes==6)
            nombreMes = "junio";
        if(mes==7)
            nombreMes = "julio";
        if(mes==8)
            nombreMes = "agosto";
        if(mes==9)
            nombreMes = "septiembre";
        if(mes==10)
            nombreMes = "octubre";
        if(mes==11)
            nombreMes = "noviembre";
        if(mes==12)
            nombreMes = "diciembre";
        System.out.println(dia + " de " + nombreMes + " de " + año);
    }
}
