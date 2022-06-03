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
        final int cantidadDeEmpleados = 50;
        String listaEmpleados = "";
        float sumaBono = 0, sumaSalarioTotal = 0, sumaSalarioReal = 0;
        for (int empleado = 1; empleado <= cantidadDeEmpleados; empleado++) {
            String IdentificadorEmpleado = "EMPLEADO #" + empleado;
            //lectura de los datos
            String nombre = principal.ingresarTexto("Ingrese el nombre del empleado", IdentificadorEmpleado);
            float horasTrabajadas = principal.ingresarPositivo("Ingrese la cantidad de horas trabajadas", IdentificadorEmpleado);
            float pagoPorHora = principal.ingresarPositivo("Ingrese el Pago por Hora", IdentificadorEmpleado);
            int diaDeCumpleaños = (int)principal.ingresarPositivo("Ingrese el dia de cumpleaños", IdentificadorEmpleado);
            int mesDeCumpleaños = (int)principal.ingresarPositivo("Ingrese el mes de cumpleaños", IdentificadorEmpleado);
            
            float salarioNormal = horasTrabajadas * pagoPorHora;

            //!BONIFICACIONES
            float bono = 50; // empieza en 50 por que es diciembre
            bono += proyecto1.calc_perfecto(principal.sumaDeDigitos(diaDeCumpleaños)) == 'P' ? 50 : 0;
            bono += proyecto1.calc_primo(mesDeCumpleaños) == 'P' ? 30 : 0;
            int aleatorio1 = principal.enteroAleatorio();
            int aleatorio2 = principal.enteroAleatorio();
            bono += proyecto1.calc_amigos(aleatorio1,aleatorio2) == 'A' ? 100 : 0;
            bono += proyecto1.calc_armstrong(aleatorio1) || proyecto1.calc_armstrong(aleatorio2) ? 150 : 0;

            float salarioTotal = salarioNormal + bono;

            float salarioReal = proyecto1.calc_invertir((int)salarioTotal);
            salarioReal = salarioTotal > salarioReal ? salarioTotal : salarioReal;

            listaEmpleados += String.format("%-20s %12.2f %12.2f %12.2f %12.2f\n", nombre,salarioNormal,bono,salarioTotal,salarioReal);

            //todo
            if(empleado == 3)
                break;
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
                mostrarMensajeError("EL NUMERO INGRESADO ES INCORRECTO","ERROR NUMERO INVALIDO");
            }
        }
    }

    float ingresarPositivo(Object mensaje, String titulo){
        while (true) {
            float valor = ingresarNumero(mensaje, titulo);
            if(valor > 0)
                return valor;
            mostrarMensajeError("DEBE SER UN VALOR POSITIVO","ERROR NUMERO INVALIDO");
        }
    }

    int enteroAleatorio(){
        return new Random().nextInt(250, 8500 + 1); // se le suma 1 al limite superio para incluirlo
    }

}