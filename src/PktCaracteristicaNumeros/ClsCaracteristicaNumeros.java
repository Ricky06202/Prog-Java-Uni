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

    private int sumaDeDivisores(int numero, boolean incluyendoElNumero) {
        int suma = 0;
        for (int contador = 1; incluyendoElNumero ? contador <= numero: contador < numero ; contador++)
            suma += numero % contador == 0 ? contador : 0;
        return suma;
    }

    char calc_perfecto(int numero){
        return sumaDeDivisores(numero, false) == numero && numero > 0 ? 'P' : 'X';
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
        return Long.toString(Math.abs(numero)).length();
    }

    void calc_ulam(int numero){
        String conjeturaDeUlam = "";
        int contador = 0;
        while(numero > 1){
            conjeturaDeUlam += numero + " ";
            numero = numero % 2 == 0 ? numero / 2 : numero * 3 + 1;
            conjeturaDeUlam += ++contador % 20 == 0 ? "\n" : "";
        }
        conjeturaDeUlam += numero;
        JOptionPane.showMessageDialog(null,conjeturaDeUlam,"Calcular Ulam",JOptionPane.INFORMATION_MESSAGE);
    }

    boolean calc_abundante(int numero){
        return sumaDeDivisores(numero,true) > numero * 2 && numero > 0;
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

    long calc_factorial(int numero){
        return numero <= 0 ? 1 : numero * calc_factorial(numero - 1);
    }

    char calc_amigos(int numero1, int numero2){
        return numero2 == sumaDeDivisores(numero1,false) ? 'A' : 'X';
    }

    char calc_capicua(int numero){
        return numero == calc_invertir(numero) ? 'C' : 'X';
    }

    int ingresar_numero(Object texto, String titulo){
        while (true) {
            try {
                int numero = Integer.parseInt(JOptionPane.showInputDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE));
                return numero;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                "ERROR: Numero Invalido Ingresado","ERROR NUMERO INVALIDO",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    int ingresar_numero_positivo(Object texto, String titulo, boolean aceptarElCero){
        while (true) {
            int numero = ingresar_numero(texto,titulo);
            if (aceptarElCero ? numero >= 0 : numero > 0)
                return numero;
            JOptionPane.showMessageDialog(null,
            "ERROR: El numero debe ser " + (aceptarElCero ? "Mayor o igual a 0" : "positivo"),
            "ERROR NUMERO INVALIDO",JOptionPane.ERROR_MESSAGE);
        }
    }
}