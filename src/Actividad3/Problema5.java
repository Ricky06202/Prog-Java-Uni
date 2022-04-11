package Actividad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema5 {
    // Se coloca un capital C, a un interés I, durante M años y se desea saber en cuanto se habrá convertido ese capital en m años, sabiendo que es acumulativo.
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        float capital = Float.parseFloat(leer.readLine()), interes = Float.parseFloat(leer.readLine());
        int cantidadAños = Integer.parseInt(leer.readLine());
        capital += capital * interes *cantidadAños;
        System.out.println("El Capital en " + cantidadAños + " se habra convertido en: " + capital);
    }
}
