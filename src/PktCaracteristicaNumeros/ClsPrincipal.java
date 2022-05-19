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
                "Calcular Potencia",//0
                "Calcular Primo",//1
                "Calcular Perfecto",//2
                "Calcular Invertido",//3
                "Calcular Cifras", //4
                "Calcular Ulam",//5
                "Calcular Abundante",//6
                "Calcular Armstrong",//7
                "Calcular Par o Impar", //8
                "Calcular Factorial",//9
                "Calcular Amigos",//10
                "Calcular Capicua"},//11  
            null);
            
            String titulo = 
            opcion == 0 ? "Calcular Potencia" :
            opcion == 1 ? "Calcular Primo" :
            opcion == 2 ? "Calcular Perfecto" :
            opcion == 3 ? "Calcular invertido" :
            opcion == 4 ? "Calcular Cifras" :
            opcion == 5 ? "Calcular Ulam" :
            opcion == 6 ? "Calcular Abundante" :
            opcion == 7 ? "Calcular Armstrong" :
            opcion == 8 ? "Calcular Par o Impar" :
            opcion == 9 ? "Calcular Factorial" :
            opcion == 10 ? "Calcular Amigos" :
            "Calcular Capicua"; //opcion 11

            int numero = opcion == 1 || opcion == 2 || opcion >= 5 && opcion <= 7 ? 
            funcion.ingresar_numero_positivo(titulo) : 0;

            numero = opcion == 9 ? 
            funcion.ingresar_numero_positivo_incluyendo_0(titulo) : numero;

            numero = opcion == 3 || opcion == 4 || opcion == 8 || opcion == 11 ? 
            funcion.ingresar_numero(titulo) : numero;

            switch (opcion) {
                case 0: //Calcular Potencia
                    int base = funcion.ingresar_numero("Ingrese la base", titulo);
                    int exponente = funcion.ingresar_numero_positivo("Ingrese el exponente", titulo);
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + base + " elevado a la " + exponente +  " es igual a: " + funcion.enteroPotencia(base,exponente), 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1://Calcular Primo
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (funcion.calc_primo(numero) == 'X' ? " no" : "") + " es primo", 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2://Calcular Perfecto
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (funcion.calc_perfecto(numero) == 'X' ? " no" : "") + " es perfecto", 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3://Calcular Invertido
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + " invirtiendolo es: " + funcion.calc_invertir(numero), 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4://Calcular Cifras
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + " tiene " + funcion.calc_cifras(numero) + " cifras", 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5://Calcular Ulam
                    funcion.calc_ulam(numero);
                    break;
                case 6://Calcular Abundante
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (!funcion.calc_abundante(numero) ? " no" : "") + " es abundante", 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7://Calcular Armstrong
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (!funcion.calc_armstrong(numero) ? " no" : "") + " es armstrong", 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 8://Calcular Par o Impar
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + " es" + (funcion.calc_parImpar(numero) == 'P' ? " par" : " impar"), 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9://Calcular Factorial
                    JOptionPane.showMessageDialog(null, 
                    "El Factorial del numero " + numero + " es: " + funcion.calc_factorial(numero), 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 10://Calcular Amigos
                    int numero1 = funcion.ingresar_numero_positivo("Ingrese el Primer Numero", titulo);
                    int numero2 = funcion.ingresar_numero_positivo("Ingrese el Segundo Numero", titulo);
                    JOptionPane.showMessageDialog(null, 
                    "Los numeros " + numero1 + " y " + numero2 + 
                    (funcion.calc_amigos(numero1,numero2) == 'X' ? " no" : "") + " son amigos", 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 11://Calcular Capicua
                    JOptionPane.showMessageDialog(null, 
                    "El numero " + numero + (funcion.calc_capicua(numero) == 'X' ? " no" : "") + " es capicua", 
                    titulo, JOptionPane.INFORMATION_MESSAGE);
                    break;         
                default://salir
                    System.exit(0);
            }
        }
    }
}