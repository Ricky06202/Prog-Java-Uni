package Proyecto2_Parcial2;
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
    private ClsCaracteristicaNumeros funciones = new ClsCaracteristicaNumeros();
    public static void main(String[] args) {

    }

    private void mostrarMensaje(Object mensaje){
        System.out.println(mensaje);
    }

    private float leer(){
        while (true) {
            float valor = Float.parseFloat(System.console().readLine());
            if(valor > 0)
                return valor;
            System.out.println("DEBE SER UN VALOR POSITIVO");
        }
    }

}