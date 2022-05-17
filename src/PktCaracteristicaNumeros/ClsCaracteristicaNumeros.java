package PktCaracteristicaNumeros;

import javax.swing.JOptionPane;

/**
 * ClsCaracteristicaNumeros
 */
public class ClsCaracteristicaNumeros {

    int enteroPotencia(int base, int exponente){
        int potencia = 1;
        for (int contador = 0; contador < exponente; contador++)
            potencia *= base;
        return potencia;
    }

    char calc_primo(int numero){
        for (int contador = 2; contador < numero; contador++)
            if(numero % contador == 0)
                return 'X';
        return numero > 1 ? 'P' : 'X';
    }

    char calc_perfecto(int numero){
        if(numero <= 0)
            return 'X';
        int suma = 0;
        for (int contador = 1; contador < numero; contador++)
            suma += numero % contador == 0 ? contador : 0;
        return suma == numero ? 'P' : 'X';
    }

    long calc_invertir(long numero){
        int invertido = 0;
        while (numero != 0) {
            invertido *= 10;
            invertido += numero % 10;
            numero /= 10;
        }
        return invertido;
    }

    int calc_cifras(long numero){
        return Long.toString(numero).length();
    }

    void calc_ulam(int numero){
        if(numero <= 0){
            JOptionPane.showMessageDialog(null, "ERROR: El numero debe ser positivo");
            return;
        }
        String conjeturaDeUlam = "";
        while(numero > 1){
            conjeturaDeUlam += numero + " ";
            numero = numero % 2 == 0 ? numero / 2 : numero * 3 + 1; 
        }
        conjeturaDeUlam += numero;
        JOptionPane.showMessageDialog(null,conjeturaDeUlam);
    }

    boolean calc_abundante(int numero){
        if(numero <= 0)
            return false;
        int suma = 0;
        for (int contador = 1; contador <= numero; contador++) 
            suma += numero % contador == 0 ? contador : 0;
        return suma > numero * 2;
    }

    boolean calc_armstrong(int numero){
        String numeroEnCadena = Integer.toString(numero);
        int suma = 0;
        for (int posicion = 0; posicion < calc_cifras(numero); posicion++) {
            int digito = numeroEnCadena.charAt(posicion) - '0';
            suma += enteroPotencia(digito,calc_cifras(numero));
        }
        return suma == numero;
    }

    char calc_parImpar(int numero){
        return numero % 2 == 0 ? 'P' : 'I';
    }

    int calc_factorial(int numero){
        if(numero < 0)
            return 0;
        int factorial = 0;
        for (int contador = 1; contador < numero; contador++)
            factorial += numero % contador == 0 ? contador : 0;
        return factorial;
    }

    char calc_amigos(int numero){
        int sumaDivisores1 = 0;
        for (int contador = 1; contador < numero; contador++) 
            sumaDivisores1 += numero % contador == 0 ? contador : 0;
        int sumaDivisores2 = 0;
        for (int contador = 1; contador < sumaDivisores1; contador++) 
            sumaDivisores2 += numero % contador == 0 ? contador : 0;
        return numero == sumaDivisores2 ? 'A' : 'X';
    }

    char calc_capicua(int numero){
        return numero == calc_invertir(numero) ? 'C' : 'X';
    }
}