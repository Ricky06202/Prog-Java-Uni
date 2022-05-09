package PktParcial1RicardoSanjur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClsParcial1RicardoSanjur {
    public static void main(String[] args) throws IOException {
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        //declaracion de las variables a leer
        int departamentoEmpleado, cantidadDeFaltas, horasTrabajadas;
        //declaracion de variables booleanas auxiliares
        boolean esDeContabilidad, esDeProduccion;
        //usamos este bucle para asegurar que se ingresa el departamento adecuado
        while (true) {
            System.out.print("Ingrese El departamento del Empleado: ");
            departamentoEmpleado = Integer.parseInt(leer.readLine());
            esDeContabilidad = departamentoEmpleado == 1;
            esDeProduccion = departamentoEmpleado == 2;
            if (esDeContabilidad || esDeProduccion) 
                break;
            System.out.println("***El departamento debe ser:\n***1 para Contabilidad\n***2 para Produccion");
        }
        //usamos este bucle para asegurar que se ingresa una cantidad de faltas adecuada
        while (true) {
            System.out.print("Ingrese La cantidad de faltas del Empleado: ");
            cantidadDeFaltas = Integer.parseInt(leer.readLine());
            if (cantidadDeFaltas >= 0) 
                break;
            System.out.println("***La cantidad de faltas debe ser positiva");
        }
        //usamos este bucle para asegurar que se ingresa unas horas trabajadas adecuada
        while (true) {
            System.out.print("Ingrese La cantidad de horas trabajadas del Empleado: ");
            horasTrabajadas = Integer.parseInt(leer.readLine());
            if (horasTrabajadas >= 0)
                break;
            System.out.println("***Las horas trabajadas deben ser positivas");
        }
        //asignamos la cantidad de balboas por hora correspondiente al departamento
        final float balboasHora; // balboasHora = esDeContabilidad ? 61.25f : 22.45f;
        if (esDeContabilidad) 
            balboasHora = 61.25f;
        else
            balboasHora = 22.45f;
        //declaramos constantes booleanas auxiliares
        final boolean tiene0Faltas = cantidadDeFaltas == 0;
        final boolean tiene1Falta = cantidadDeFaltas == 1;
        final boolean tiene2Faltas = cantidadDeFaltas == 2;
        final boolean tiene3Faltas = cantidadDeFaltas == 3;
        //asignamos la cantidad de balboas adicionales segun la cantidad de faltas
        final float balboasAdicionales;
        if(tiene0Faltas)
            balboasAdicionales = 185;
        else if (tiene1Falta)
            balboasAdicionales = 120;
        else if (tiene2Faltas)
            balboasAdicionales = 90;
        else if (tiene3Faltas)
            balboasAdicionales = 30;
        else
            balboasAdicionales = 0;
        //calculamos el sueldo neto y el sueldo integrado
        final float sueldoNeto = horasTrabajadas * balboasHora;
        final float sueldoIntegrado = sueldoNeto + balboasAdicionales;
        //imprimimos el reporte
        System.out.println("Reporte del Sueldo Del Empleado:");
        System.out.println("Sueldo neto....................." + sueldoNeto);
        System.out.println("Bono por asistencia............." + balboasAdicionales);
        System.out.println("Sueldo integrado................" + sueldoIntegrado);
    }
}