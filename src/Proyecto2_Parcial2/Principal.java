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
Nombre Salario normal, bono, salario total, salario real
!adicional
despues de la impresion, se deben imprimir los totales de bono, salario total y salario real
 */
public class Principal {
    
    ClsCaracteristicaNumeros proyecto1 = new ClsCaracteristicaNumeros();
    public static void main(String[] args) {
        Principal principal = new Principal();

        
    }

    void mostrarMensaje(Object mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    void mostrarMensajeError(Object mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    float leer(Object texto, String titulo){
        while (true) {
            float valor = Float.parseFloat(JOptionPane.showInputDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE));
            if(valor > 0)
                return valor;
            System.out.println("DEBE SER UN VALOR POSITIVO");
        }
    }

    int enteroAleatorio(){
        return new Random().nextInt(250, 8500 + 1); // se le suma 1 al limite superio para incluirlo
    }

}