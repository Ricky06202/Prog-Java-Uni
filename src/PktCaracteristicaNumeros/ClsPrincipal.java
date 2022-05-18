package PktCaracteristicaNumeros;

import javax.swing.JOptionPane;

/**
 * ClsPrincipal
 */
public class ClsPrincipal {

    public static void main(String[] args) {
        ClsCaracteristicaNumeros funcion = new ClsCaracteristicaNumeros();
        while (true) {
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
                null);

            int numero = opcion == 1 || opcion == 2 || opcion >= 5 && opcion <= 7 || opcion == 9 ? 
            funcion.ingresar_numero_positivo("Ingrese un Numero", "LECTURA DE NUMERO",false) : 0;

            numero = opcion == 3 || opcion == 4 || opcion == 8 || opcion == 11 ? 
            funcion.ingresar_numero("Ingrese un Numero", "LECTURA DE NUMERO") : numero;

            switch (opcion) {
                case 0: //Calcular Potencia
                    int base = funcion.ingresar_numero("Ingrese la base", "LECTURA DE BASE");
                    int exponente = funcion.ingresar_numero_positivo("Ingrese el exponente", "LECTURA DE EXPONENTE",true);
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + base + " elevado a la " + exponente +  " es igual a: " + funcion.enteroPotencia(base,exponente), 
                    "Calcular Potencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1://Calcular Primo
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (funcion.calc_primo(numero) == 'X' ? " no" : "") + " es primo", 
                    "Calcular Primo", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2://Calcular Perfecto
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (funcion.calc_perfecto(numero) == 'X' ? " no" : "") + " es perfecto", 
                    "Calcular Perfecto", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3://Calcular Invertido
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + " invirtiendolo es: " + funcion.calc_invertir(numero), 
                    "Calcular Invertido", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4://Calcular Cifras
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + " tiene " + funcion.calc_cifras(numero) + " cifras", 
                    "Calcular Cifras", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5://Calcular Ulam
                    funcion.calc_ulam(numero);
                    break;
                case 6://Calcular Abundante
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (!funcion.calc_abundante(numero) ? " no" : "") + " es abundante", 
                    "Calcular Abundante", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7://Calcular Armstrong
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (!funcion.calc_armstrong(numero) ? " no" : "") + " es armstrong", 
                    "Calcular Armstrong", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 8://Calcular Par o Impar
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + " es" + (funcion.calc_parImpar(numero) == 'P' ? " par" : " impar"), 
                    "Calcular Par o Impar", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9://Calcular Factorial
                    JOptionPane.showMessageDialog(null, 
                    "El Factorial del numero " + numero + " es: " + funcion.calc_factorial(numero), 
                    "Calcular Factorial", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 10://Calcular Amigos
                    int numero1 = funcion.ingresar_numero_positivo("Ingrese el Primer Numero", "LECTURA DEL PRIMER NUMERO",false);
                    int numero2 = funcion.ingresar_numero_positivo("Ingrese el Segundo Numero", "LECTURA DEL SEGUNDO NUMERO",false);
                    JOptionPane.showMessageDialog(null, 
                    "Los numeros " + numero1 + " y " + numero2 + (funcion.calc_amigos(numero1,numero2) == 'X' ? " no" : "") + 
                    " son amigos", "Calcular Amigos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 11://Calcular Capicua
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (funcion.calc_capicua(numero) == 'X' ? " no" : "") + " es capicua", 
                    "Calcular Capicua", JOptionPane.INFORMATION_MESSAGE);
                    break;         
                default://salir
                    System.exit(0);
            }
        }
    }
}