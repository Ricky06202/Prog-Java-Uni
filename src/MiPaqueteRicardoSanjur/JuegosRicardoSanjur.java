package MiPaqueteRicardoSanjur;
import javax.swing.JOptionPane;

// Proyecto 3 = Cuadrado Magico
// Proyecto 4 = Juego De La Vida
import MiPaqueteRicardoSanjur.CuadradoMagico.Cuadrado;
import MiPaqueteRicardoSanjur.JuegoDeLaVida.*;

public class JuegosRicardoSanjur {
    public static void main(String[] args) {
        var funciones = new JuegosRicardoSanjur();
        int opcion = JOptionPane.showOptionDialog(
            null, 
            "Seleccione una de las siguientes opciones", 
            "Menu Principal  ->  (Cerrar Para Finalizar)", 
            JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, 
            "El Cuadrado Magico, El Juego De La Vida".split(", "), 0);
        switch (opcion) {
            case 0:
                var cuadrado = new Cuadrado(funciones.mtdIngresarImpar("Ingrese un numero para la matriz cuadrada", "TAMAÑO DE LA MATRIZ CUADRADA"));
                funciones.mtdMostrarMensaje(cuadrado, "CUADRADO MAGICO TAMAÑO " + String.format("%d X %d", cuadrado.getTamaño(), cuadrado.getTamaño()));
                funciones.mtdMostrarMensaje(cuadrado.sumatoriasString(), "VERIFICACION DE SUMATORIAS"); 
                break;
            case 1:
                var vida = new Vida(20, 0, Forma.X);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    void mtdMostrarMensaje(Object mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    void mtdMostrarMensajeError(Object mensaje, String titulo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    void mtdMostrarMensajeError(Object mensaje){
        mtdMostrarMensajeError(mensaje,"ERROR NUMERO INVALIDO");
    }

    float mtdIngresarNumero(Object mensaje, String titulo){
        while (true) {
            try {
                return Float.parseFloat(JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE));
            } catch (Exception e) {
                mtdMostrarMensajeError("EL NUMERO INGRESADO ES INCORRECTO");
            }
        }
    }
    
    int mtdIngresarMayorA3(Object mensaje, String titulo){
        while (true) {
            int valor = (int)mtdIngresarNumero(mensaje, titulo);
            if(valor >= 3)
                return valor;
            mtdMostrarMensajeError("DEBE SER UN VALOR MAYOR O IGUAL A 3");
        }
    }

    int mtdIngresarImpar(Object mensaje, String titulo){
        while (true) {
            int valor = (int)mtdIngresarMayorA3(mensaje, titulo);
            if(valor % 2 == 1)
                return valor;
            mtdMostrarMensajeError("DEBE SER UN VALOR IMPAR");
        }
    }
}
