package Actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema3 {
    // Imprimir los múltiplos de 3 de los números de 3 hasta N. Donde N es un valor que tiene que ser leído desde el teclado.
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int cantidadDeVeces = Integer.parseInt(leer.readLine());
        for (int i = 3; i <= cantidadDeVeces; i++) {
            if (i % 3 == 0)
                System.out.println(i);
        }
    }
}
