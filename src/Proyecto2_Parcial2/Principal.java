package Proyecto2_Parcial2;

import java.util.Random;

import javax.swing.JOptionPane;

import PktCaracteristicaNumeros.ClsCaracteristicaNumeros;

//
// ────────────────────────────────────────────────────────── I ──────────
//   :::::: P R I N C I P A L : :  :   :    :     :        :          :
// ────────────────────────────────────────────────────────────────────
//
/*
La empresa paga a 50 empleados el salario normal
*Salario Normal = horas trabajadas * pago por hora
!BONIFICACIONES
?si el mes es diciembre a todos les toca bono de 50$
?si la suma de los digitos del dia de nacimiento es 'perfecto' bono de 50$
?si el mes de nacimiento es 'primo' bono de 30$
?de 2 numeros aleatorios entre 250 y 8500, si son 'amigos' bono de 100$
?si uno de esos numeros es 'armstrong' bono de 150$ 
*Salario Total = Salario Normal + Suma de bonos
!Salario Real
se invertira la parte entera del salario total
se compara con el salario total y el que sea mayor sera el salario real

!lectura
Nombre, horas trabajadas, pago por hora, dia y mes de cumpleaños, dos numeros aleatorios
!impresion
Nombre, Salario normal, bono, salario total, salario real
!adicional
despues de la impresion, se deben imprimir los totales de bono, salario total y salario real
 */
public class Principal {
    
    public static void main(String[] args) {
        ClsCaracteristicaNumeros proyecto1 = new ClsCaracteristicaNumeros();
        Principal principal = new Principal();
        final int cantidadDeEmpleados = 2;//50;
        float sumaBono = 0, sumaSalarioTotal = 0, sumaSalarioReal = 0;
        for (int empleado = 1; empleado <= cantidadDeEmpleados; empleado++) {
            String identificadorEmpleado = "EMPLEADO #" + empleado;
            //lectura de los datos
            String nombre = principal.ingresarTexto("Ingrese el nombre del empleado", identificadorEmpleado);
            float horasTrabajadas = principal.ingresarPositivo("Ingrese la cantidad de horas trabajadas", identificadorEmpleado);
            float pagoPorHora = principal.ingresarPositivo("Ingrese el Pago por Hora", identificadorEmpleado);
            int mesDeCumpleaños = principal.ingresarMes("Ingrese el mes de cumpleaños", identificadorEmpleado);
            int diaDeCumpleaños = principal.ingresarDia("Ingrese el dia de cumpleaños", identificadorEmpleado, mesDeCumpleaños);
            
            float salarioNormal = horasTrabajadas * pagoPorHora;

            //!BONIFICACIONES
            String listaBonificaciones = "====INFORME DE BONIFICACIONES====";
            float bono = 50; // empieza en 50 por que es diciembre
            listaBonificaciones += "\nBonificacion por ser diciembre: 50.00";
            if(proyecto1.calc_perfecto(principal.sumaDeDigitos(diaDeCumpleaños)) == 'P'){
                listaBonificaciones += "\nBonificacion por su dia de cumpleaños: 50.00";
                bono += 50;
            }
            if(proyecto1.calc_primo(mesDeCumpleaños) == 'P'){
                listaBonificaciones += "\nBonificacion por su mes de cumpleaños: 30.00";
                bono += 30;
            }
            int aleatorio1 = principal.enteroAleatorio();
            int aleatorio2 = principal.enteroAleatorio();
            if(proyecto1.calc_amigos(aleatorio1,aleatorio2) == 'A'){
                listaBonificaciones += String.format("\nBonificacion por que los numeros aleatorios %d y %d son amigos: 100.00", aleatorio1,aleatorio2);
                bono += 100;
            }
            if(proyecto1.calc_armstrong(aleatorio1) || proyecto1.calc_armstrong(aleatorio2)){
                listaBonificaciones += String.format("\nBonificacion por que el numero aleatorio %d es armstrong: 150.00",proyecto1.calc_armstrong(aleatorio1) ? aleatorio1 : aleatorio2);
                bono += 150;
            }

            float salarioTotal = salarioNormal + bono;

            float salarioReal = proyecto1.calc_invertir((int)salarioTotal);
            salarioReal = salarioTotal > salarioReal ? salarioTotal : salarioReal;

            String listaEmpleado = String.format("Nombre: %s\nSalario Normal: %.2f\nBonificacion: %.2f\nSalario Total: %.2f\nSalario Real: %.2f", nombre,salarioNormal,bono,salarioTotal,salarioReal);
            
            String mensajeAMostrar = listaBonificaciones + "\n====INFORME GENERAL====\n" + listaEmpleado;

            principal.mostrarMensaje(mensajeAMostrar, "REGISTRO DEL " + identificadorEmpleado);

            //!Sumatoria
            sumaBono += bono;
            sumaSalarioTotal += salarioTotal;
            sumaSalarioReal += salarioReal;

        }


        String listaSumatorias = String.format(
            "Total de Bonificaciones:   %12.2f\nTotal de Salarios Totales: %12.2f\nTotal de Salarios Reales:  %12.2f",sumaBono,sumaSalarioTotal,sumaSalarioReal);

        principal.mostrarMensaje(listaSumatorias, "REGISTRO DE LAS SUMATORIAS");
    }

    int ingresarDia(Object mensaje, String titulo, int mes){
        boolean tiene31 = mes <= 7 && mes % 2 == 1 || mes >= 8 && mes % 2 == 0;
        int maximoDeDias;
        if(mes == 2)
            maximoDeDias = 29;
        else if(tiene31)
            maximoDeDias = 31;
        else
            maximoDeDias = 30;
        while (true) {
            int dia = (int)ingresarPositivo(mensaje, titulo);
            if(dia <= maximoDeDias)
                return dia;
            mostrarMensajeError("DIA INCORRECTO, DEBE SER UN NUMERO MENOR O IGUAL A " + maximoDeDias);
        }
    }

    int ingresarMes(Object mensaje, String titulo){
        while (true) {
            int mes = (int)ingresarPositivo(mensaje, titulo);
            if(mes <= 12)
                return mes;
            mostrarMensajeError("MES INCORRECTO, DEBE SER UN NUMERO MENOR O IGUAL A 12");
        }
    }

    int sumaDeDigitos(int numero){
        int suma = 0;
        while (numero != 0) {
            suma += numero % 10;
            numero /= 10;
        }
        return suma;
    }

    void mostrarMensaje(Object mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    void mostrarMensajeError(Object mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    void mostrarMensajeError(Object mensaje){
        mostrarMensajeError(mensaje,"ERROR NUMERO INVALIDO");
    }

    String ingresarTexto(Object mensaje, String titulo){
        while (true) {
        
            String texto = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            if(texto != null && !texto.trim().equals(""))
                return texto;
            mostrarMensajeError("NO PUEDE DEJAR VACIO ESTE CAMPO DE TEXTO","ERROR TEXTO INVALIDO");
        
        }
    }

    float ingresarNumero(Object mensaje, String titulo){
        while (true) {
            try {
                return Float.parseFloat(JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE));
            } catch (Exception e) {
                mostrarMensajeError("EL NUMERO INGRESADO ES INCORRECTO");
            }
        }
    }

    float ingresarPositivo(Object mensaje, String titulo){
        while (true) {
            float valor = ingresarNumero(mensaje, titulo);
            if(valor > 0)
                return valor;
            mostrarMensajeError("DEBE SER UN VALOR POSITIVO");
        }
    }

    int enteroAleatorio(){
        return new Random().nextInt(250, 8500 + 1); // se le suma 1 al limite superio para incluirlo
    }

}