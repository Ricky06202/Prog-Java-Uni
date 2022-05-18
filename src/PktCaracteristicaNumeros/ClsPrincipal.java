package PktCaracteristicaNumeros;

import javax.swing.JOptionPane;

/**
 * ClsPrincipal
 */
public class ClsPrincipal {

    public static void main(String[] args) {
        ClsCaracteristicaNumeros funcion = new ClsCaracteristicaNumeros();
        while (true) { // (null, "Seleccione una de las opciones", "MENU", JOptionPane.);
            int opcion = JOptionPane.showOptionDialog(null, 
                "Seleccione una de las opciones", 
                "MENU                                                                                                                                                                           (Para terminar el programa cierre este menu en la X de la esquina)", 
                JOptionPane.NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                new String[] {
                    "Calcular Potencia",
                    "Calcular Primo",
                    "Calcular Perfecto",
                    "Calcular Invertido",
                    "Calcular Cifras",
                    "Calcular Ulam",
                    "Calcular Abundante",
                    "Calcular Armstrong",
                    "Calcular Par o Impar",
                    "Calcular Factorial",
                    "Calcular Amigos",
                    "Calcular Capicua"}, 
                0);
            int numero = 0;
            if (opcion >= 1 && opcion <= 9 || opcion == 11)
                numero = Integer.parseInt(JOptionPane.showInputDialog (null, "Ingrese un Numero", "LECTURA DE NUMERO", JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 0:
                    int base = Integer.parseInt(JOptionPane.showInputDialog (null, "Ingrese la base", "LECTURA DE BASE", JOptionPane.INFORMATION_MESSAGE));
                    int exponente = Integer.parseInt(JOptionPane.showInputDialog (null, "Ingrese el exponente", "LECTURA DE EXPONENTE", JOptionPane.INFORMATION_MESSAGE));
                    JOptionPane.showMessageDialog(null, "El numero " + base + " elevado a la " + exponente +  " es igual a: " + funcion.enteroPotencia(base,exponente), "Calcular Potencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + (funcion.calc_primo(numero) == 'X' ? " no" : "") + " es primo", "Calcular Primo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + (funcion.calc_perfecto(numero) == 'X' ? " no" : "") + " es perfecto", "Calcular Perfecto", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + " invirtiendolo es: " + funcion.calc_invertir(numero), "Calcular Invertido", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + " tiene " + funcion.calc_cifras(numero) + " cifras", "Calcular Cifras", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5:
                    funcion.calc_ulam(numero);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + (!funcion.calc_abundante(numero) ? " no" : "") + " es abundante", "Calcular Abundante", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + (!funcion.calc_armstrong(numero) ? " no" : "") + " es armstrong", "Calcular Armstrong", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + " es" + (funcion.calc_parImpar(numero) == 'P' ? " par" : " impar"), "Calcular Par o Impar", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "El Factorial del numero " + numero + " es: " + funcion.calc_factorial(numero), "Calcular Factorial", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 10:
                    int numero1 = Integer.parseInt(JOptionPane.showInputDialog (null, "Ingrese el Primer Numero", "LECTURA DEL PRIMER NUMERO", JOptionPane.INFORMATION_MESSAGE));
                    int numero2 = Integer.parseInt(JOptionPane.showInputDialog (null, "Ingrese el Segundo Numero", "LECTURA DEL SEGUNDO NUMERO", JOptionPane.INFORMATION_MESSAGE));
                    JOptionPane.showMessageDialog(null, "Los numeros " + numero1 + " y " + numero2 + (funcion.calc_amigos(numero1,numero2) == 'X' ? " no" : "") + " son amigos", "Calcular Amigos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 11:
                    JOptionPane.showMessageDialog(null, "El numero " + numero + (funcion.calc_capicua(numero) == 'X' ? " no" : "") + " es capicua", "Calcular Capicua", JOptionPane.INFORMATION_MESSAGE);
                    break;         
                default:
                    System.exit(0);
            }
        }
    }
}