package Actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema1 {
    // 1. Escriba un programa que lea el total de venta de 5 facturas. El programa debe imprimir:

    // Total de facturas cuyas ventas son mayores a 1000.00.
    // Total de facturas cuyas ventas son mayores o iguales a 450 y menores o iguales a 1000.
    // Total de facturas cuyas ventas son menores a 450.
    public static void main(String[] args) throws IOException{
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int mayores1000 = 0, entre450Y1000 = 0, menores450 = 0;
        for (int i = 0; i < 5; i++) {
            float totalVentas = Float.parseFloat(leer.readLine());
            if(totalVentas > 1000)
                mayores1000++;
            else if(totalVentas >= 450)
                entre450Y1000++;
            else
                menores450++;
        }
        System.out.println("Total de Facturas mayores a 1000 = " + mayores1000);
        System.out.println("Total de Facturas mayores o igual a 450 y menores o iguales a 1000 = " + entre450Y1000);
        System.out.println("Total de Facturas menores a 450 = " + menores450);
    }
}
