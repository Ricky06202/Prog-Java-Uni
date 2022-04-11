package Actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema2 {
    // Escriba un programa que lea 10 número cualquiera y calcule e imprima las siguientes estadísticas:

    // Imprimir la suma de los números pares leídos.
    // Total de números positivos leídos.
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int totalPares = 0, totalPositivos = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(leer.readLine());
            if (num > 0)
                totalPositivos++;
            if (num % 2 == 0)
                totalPares++;
        }
        System.out.println("Total de Numeros Pares = " + totalPares);
        System.out.println("Total de Numeros Positivos = " + totalPositivos);
    }
}
