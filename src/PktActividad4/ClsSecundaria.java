package PktActividad4;

import java.util.Scanner;

public class ClsSecundaria {
    private final Scanner objLeer = new Scanner(System.in);
    
    void mtdCalculoDeInteres(){
        System.out.print("Ingrese la Capital inicial: ");
        float capital = mtdLeerFlotantePositivo();
        System.out.print("Ingrese la Cantidad de meses: ");
        int cantidadDeMeses = (int)mtdLeerFlotantePositivo();
        final float porcentajeMensual = 0.02f;
        float dineroGanado = capital * porcentajeMensual * cantidadDeMeses;
        System.out.printf("La Cantidad de dinero ganada sera de: %.2f", dineroGanado);
    }

    void mtdComisionDelVendedor(){
        System.out.print("Ingrese el Sueldo Base: ");
        float sueldo = mtdLeerFlotantePositivo();
        float totalComisiones = 0;
        final float porcentajeExtra = 0.10f;
        final int cantidadDeComisiones = 3;
        // leemos cada venta y las multiplicamos por el porcentaje extra 
        // para ir acumulando su resultado en la variable de total de comisiones
        for (int contador = 0; contador < cantidadDeComisiones; contador++) {
            System.out.printf("Ingrese la venta %d: ",contador+1);
            totalComisiones += mtdLeerFlotantePositivo() * porcentajeExtra;
        }   
        sueldo += totalComisiones;
        System.out.printf("El total obtenido por las comisiones es de: %.2f", totalComisiones);
        System.out.printf("El total que obtendra en el mes sera de: %.2f", sueldo);
    }

    void mtdTotalDeLaCompra(){
        System.out.print("Ingrese el total de Compras: ");
        float totalDeCompras = mtdLeerFlotantePositivo();
        final float porcentajeDeDescuento = 0.15f;
        totalDeCompras -= totalDeCompras * porcentajeDeDescuento;
        System.out.printf("Con el Descuento del 15% aplicado, debera pagar: %.2f", totalDeCompras);
    }

    void mtdCalificacionFinal(){
        final int cantidadDeParciales = 3;
        float promedioParciales = 0;
        for (int contador = 0; contador < cantidadDeParciales; contador++) {
            System.out.printf("Ingrese la nota del parcial %d: ",contador+1);
            promedioParciales += mtdLeerNota();
        }
        promedioParciales /= cantidadDeParciales;
        System.out.print("Ingrese la nota del examen final: ");
        float notaExamenFinal = mtdLeerNota();
        System.out.print("Ingrese la nota del trabajo final: ");
        float notaTrabajoFinal = mtdLeerNota();
        final float porcentajeParciales = 0.55f;
        final float porcentajeExamenFinal = 0.30f;
        final float porcentajeTrabajoFinal = 0.15f;
        promedioParciales *= porcentajeParciales;
        notaExamenFinal *= porcentajeExamenFinal;
        notaTrabajoFinal *= porcentajeTrabajoFinal;
        System.out.println("//Calificacion Obtenida en Cada Subdivicion\\\\");
        System.out.printf("Parciales.........: %.2f%",promedioParciales);
        System.out.printf("Examen Final......: %.2f%",notaExamenFinal);
        System.out.printf("Trabajo Final.....: %.2f%",notaTrabajoFinal);
        System.out.printf("Calificacion Final: %.2f%",notaTrabajoFinal);
    }

    private float mtdLeerFlotantePositivo(){
        while(true){
            float flotantePositivo = objLeer.nextFloat();
            if(flotantePositivo > 0)
                return flotantePositivo;
            System.out.println("**ERROR: Debe ser Positivo**");
        }
    }

    private float mtdLeerNota(){
        while(true){
            float nota = mtdLeerFlotantePositivo();
            if(nota <= 100)
                return nota;
            System.out.println("**ERROR: No Puede ser mayor a 100**");
        }
    }
}
