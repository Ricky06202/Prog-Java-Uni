package Actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Actividad42
 */
public class Actividad42 {

    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        String fecha = leer.readLine();
        int dia = Integer.parseInt(fecha.substring(0, fecha.indexOf("/")));
        fecha = fecha.substring(fecha.indexOf("/")+1);
        int mes = Integer.parseInt(fecha.substring(0, fecha.indexOf("/")));
        int año = Integer.parseInt(fecha.substring(fecha.indexOf("/")+1));
        dia++;
        int cuantosDias;
        if (mes == 2) {
            if (año % 4 == 0)
                cuantosDias = 29;
            else
                cuantosDias = 28;
        }
        else if (mes <= 7 && mes % 2 == 1 || mes > 7 && mes % 2 == 0)
            cuantosDias = 31;
        else
            cuantosDias = 30;
        if (dia == cuantosDias+1){
            dia = 1;
            mes++;
            if (mes == 12+1) {
                mes = 1;
                año++;
            }
        }
        else if (dia < 0 || dia > cuantosDias || mes < 0 || mes > 12){
            System.out.println("ERROR!!");
            System.exit(1);
        }
        System.out.println(dia + "/" + mes + "/" + año);
    }
}