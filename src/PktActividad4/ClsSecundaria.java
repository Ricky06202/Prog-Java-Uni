package PktActividad4;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ClsSecundaria {
    private final Scanner objLeer = new Scanner(System.in);
    
    void mtdCalculoDeInteres(){
        System.out.print("Ingrese la Capital inicial: ");
        float capital = mtdLeerFlotantePositivo();
        System.out.print("\nIngrese la Cantidad de meses: ");
        int cantidadDeMeses = (int)mtdLeerFlotantePositivo();
        final float porcentajeMensual = 0.02f;
        float dineroGanado = capital * porcentajeMensual * cantidadDeMeses;
        System.out.printf("\n\nLa Cantidad de dinero ganada sera de: %.2f\n",
        dineroGanado);
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
            System.out.printf("\nIngrese la venta %d: ",contador+1);
            totalComisiones += mtdLeerFlotantePositivo() * porcentajeExtra;
        }   
        sueldo += totalComisiones;
        System.out.printf("\n\nEl total obtenido por las comisiones es de: %.2f\n", 
        totalComisiones);
        System.out.printf("El total que obtendra en el mes sera de...: %.2f\n", 
        sueldo);
    }

    void mtdTotalDeLaCompra(){
        System.out.print("Ingrese el total de Compras: ");
        float totalDeCompras = mtdLeerFlotantePositivo();
        final float porcentajeDeDescuento = 0.15f;
        totalDeCompras -= totalDeCompras * porcentajeDeDescuento;
        System.out.printf("\n\nCon el Descuento del 15%% aplicado, debera pagar: %.2f\n", 
        totalDeCompras);
    }

    void mtdCalificacionFinal(){
        final int cantidadDeParciales = 3;
        float promedioParciales = 0;
        for (int contador = 0; contador < cantidadDeParciales; contador++) {
            System.out.printf("Ingrese la nota del parcial %d: ",contador+1);
            promedioParciales += mtdLeerNota();
            System.out.println();
        }
        promedioParciales /= cantidadDeParciales;
        System.out.print("Ingrese la nota del examen final: ");
        float notaExamenFinal = mtdLeerNota();
        System.out.print("\nIngrese la nota del trabajo final: ");
        float notaTrabajoFinal = mtdLeerNota();
        final float porcentajeParciales = 0.55f;
        final float porcentajeExamenFinal = 0.30f;
        final float porcentajeTrabajoFinal = 0.15f;
        promedioParciales *= porcentajeParciales;
        notaExamenFinal *= porcentajeExamenFinal;
        notaTrabajoFinal *= porcentajeTrabajoFinal;
        float calificacionFinal = promedioParciales + notaExamenFinal + notaTrabajoFinal;
        System.out.println("\n\n//Calificacion Obtenida en Cada Subdivicion\\\\");
        System.out.printf("Parciales.........: %6.2f%%\n",promedioParciales);
        System.out.printf("Examen Final......: %6.2f%%\n",notaExamenFinal);
        System.out.printf("Trabajo Final.....: %6.2f%%\n",notaTrabajoFinal);
        System.out.printf("Calificacion Final: %6.2f%%\n",calificacionFinal);
    }

    void mtdPorcentajeDeGenero(){
        System.out.print("Ingrese la cantidad de hombres: ");
        int cantidadDeHombres = (int)mtdLeerFlotantePositivo();
        System.out.print("\nIngrese la cantidad de Mujeres: ");
        int cantidadDeMujeres = (int)mtdLeerFlotantePositivo();
        float totalDeEstudiantes = cantidadDeHombres + cantidadDeMujeres;
        System.out.printf("\n\nEl Porcentaje de Hombres del grupo es de: %.2f%%\n",
        cantidadDeHombres / totalDeEstudiantes * 100);
        System.out.printf("El Porcentaje de Mujeres del grupo es de: %.2f%%\n",
        cantidadDeMujeres / totalDeEstudiantes * 100);
    }

    void mtdCalculoDeLaEdadExacta(){
        System.out.print("Ingrese la fecha de hoy (formato dd/mm/aaaa): ");
        objLeer.nextLine();
        String fechaDeHoy = objLeer.nextLine();
        // separamos los dias meses y años de la cadena leida
        int diaDeHoy = obtenerPrimerNumeroDe(fechaDeHoy);
        fechaDeHoy = recortarHastaLaDiagonal(fechaDeHoy);
        int mesDeHoy = obtenerPrimerNumeroDe(fechaDeHoy);
        fechaDeHoy = recortarHastaLaDiagonal(fechaDeHoy);
        int añoDeHoy = obtenerPrimerNumeroDe(fechaDeHoy);
        System.out.print("\nIngrese su cumpleaños (formato dd/mm/aaaa): ");
        String fechaDeCumpleaños = objLeer.nextLine();
        // separamos los dias meses y años de la cadena leida
        int diaDeCumpleaños = obtenerPrimerNumeroDe(fechaDeCumpleaños);
        fechaDeCumpleaños = recortarHastaLaDiagonal(fechaDeCumpleaños);
        int mesDeCumpleaños = obtenerPrimerNumeroDe(fechaDeCumpleaños);
        fechaDeCumpleaños = recortarHastaLaDiagonal(fechaDeCumpleaños);
        int añoDeCumpleaños = obtenerPrimerNumeroDe(fechaDeCumpleaños);

        int diasDehoy = diaDeHoy + añoDeHoy * 365;
        diasDehoy += mtdCacularDiasDeLosMeses(mesDeHoy);
        int diasDeCumpleaños = diaDeCumpleaños + añoDeCumpleaños * 365;
        diasDeCumpleaños += mtdCacularDiasDeLosMeses(mesDeCumpleaños);
        
        int dias = diasDehoy - diasDeCumpleaños;
        int años = dias / 365;
        dias %= 365;
        int meses = mtdCalcularMesesDeLosDias(dias);
        dias %= mtdCalcularDiasRestantesDeLosMeses(dias);

        System.out.printf("\n\nLa edad exacta es: %d años %d meses %d días\n", años, meses, dias);

        Period objEdadExacta = Period.between(
            LocalDate.of(añoDeCumpleaños, mesDeCumpleaños, diaDeCumpleaños), 
            LocalDate.of(añoDeHoy,mesDeHoy,diaDeHoy));

        System.out.printf("\n\nLa edad exacta es: %d años %d meses %d días\n", 
        objEdadExacta.getYears(), objEdadExacta.getMonths(), objEdadExacta.getDays() - 1);
    }

    private int mtdCalcularMesesDeLosDias(int dias){
        int cantDias;
        for (int mes = 1; mes <= 12; mes++) {
            final boolean esFebrero = mes == 2;
            final boolean tiene31 = mes <= 7 && mes % 2 == 1 || mes >= 8 && mes % 2 == 0;
            if(esFebrero)
                cantDias = 28;
            else if(tiene31)
                cantDias = 31;
            else
                cantDias = 30;
            if (dias >= cantDias) 
                  dias -= cantDias;
            else
                return mes - 1;
            
        }
        return 0;
    }

    private int mtdCalcularDiasRestantesDeLosMeses(int dias){
        int cantDias, mes;
        for (mes = 1; mes <= 12; mes++) {
            final boolean esFebrero = mes == 2;
            final boolean tiene31 = mes <= 7 && mes % 2 == 1 || mes >= 8 && mes % 2 == 0;
            if(esFebrero)
                cantDias = 28;
            else if(tiene31)
                cantDias = 31;
            else
                cantDias = 30;
            if(dias < cantDias)
                break;
            if (dias >= cantDias) 
                  dias -= cantDias;
            else
                return dias + cantDias;
            
        }
        return 0;
    }

    private int mtdCacularDiasDeLosMeses(int mesDeHoy) {
        int dias = 0;
        for (int mes = 1; mes <= mesDeHoy; mes++) {
            final boolean esFebrero = mes == 2;
            final boolean tiene31 = mes <= 7 && mes % 2 == 1 || mes >= 8 && mes % 2 == 0;
            if(esFebrero)
                dias += 28;
            else if(tiene31)
                dias += 31;
            else
                dias += 30;
        }
        return dias;
    }

    void mtdMenu(){
        System.out.println("------------------------------------------");
        System.out.println("|//ELIJA UNA DE LAS SIGUIENTES OPCIONES\\\\|");
        System.out.println("|1) Calculo de Interes                   |");
        System.out.println("|2) Comision del vendedor                |");
        System.out.println("|3) Totales de la Compra                 |");
        System.out.println("|4) Calificacion Final                   |");
        System.out.println("|5) Porcentaje de Genero                 |");
        System.out.println("|6) Calculo de la Edad Exacta            |");
        System.out.println("|7) ##SALIR##                            |");
        System.out.println("------------------------------------------");
    }

    int mtdLeerOpcion(){
        while(true){
            int opcion = (int)mtdLeerFlotantePositivo();
            if(opcion <= 7)
                return opcion;
            System.out.println("**ERROR: No Puede ser mayor a 7**");
            System.out.print("Ingreselo Nuevamente: ");
        }
    }

    private String recortarHastaLaDiagonal(String fecha){
        return fecha.substring(fecha.indexOf("/") + 1);
    }

    private int obtenerPrimerNumeroDe(String fecha){
        return Integer.parseInt(fecha.substring(0, fecha.contains("/") ? fecha.indexOf("/") : fecha.length()));
    }

    private float mtdLeerFlotantePositivo(){
        while(true){
            float flotantePositivo = objLeer.nextFloat();
            if(flotantePositivo > 0)
                return flotantePositivo;
            System.out.println("**ERROR: Debe ser Positivo**");
            System.out.print("Ingreselo Nuevamente: ");
        }
    }


    private float mtdLeerNota(){
        while(true){
            float nota = mtdLeerFlotantePositivo();
            if(nota <= 100)
                return nota;
            System.out.println("**ERROR: No Puede ser mayor a 100**");
            System.out.print("Ingreselo Nuevamente: ");
        }
    }

    void mtdLimpiarPantalla(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void mtdPausa(){
        System.out.println("==================================================");
        try {
            new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
