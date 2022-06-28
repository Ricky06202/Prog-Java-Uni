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
                int tamaño = funciones.mtdIngresarMayorA5("Ingrese el tamaño de la matriz del universo", "TAMAÑO UNIVERSO");
                Forma forma = funciones.mtdElegirForma("Seleccione La figura inicial", "FIGURA INICIAL");
                var vida = new Vida(tamaño, forma);
                int cantidadGeneraciones = funciones.mtdIngresarPositivo("Ingrese la cantidad de Generaciones\n(Por Cada Generacion Se Mostraran 2 Universos)", "CANTIDAD DE GENERACIONES");
                for (int generaciones = 0; generaciones < cantidadGeneraciones; generaciones++) {
                    System.out.println(vida);
                    var generacion = new Generacion(vida.getUniverso());
                    if(!generacion.sigueAlguienVivo())
                        break;
                    String generacionActual = generacion.toString();
                    boolean repeticionInstantanea, repeticionTardia, muerteTemprana, muerteTardia;

                    muerteTemprana = !generacion.sigueAlguienVivo();
                    repeticionInstantanea = vida.hayVidaInfinita(generacionActual, generacion.siguiente());
                    repeticionTardia = vida.hayVidaInfinita(generacionActual, generacion.siguiente());
                    muerteTardia = !generacion.sigueAlguienVivo();

                    if (repeticionInstantanea || repeticionTardia || muerteTemprana || muerteTardia){
                        if(muerteTemprana){
                            funciones.mtdMostrarMensaje(
                                "Esta civilizacion cayo ante su muerte" +
                                "\nDetendremos la simulacion para dejarla descansar en paz", 
                                "MUERTE DE LA CIVILIZACION");
                            break;
                        }
                        vida.siguiente();
                        System.out.println(vida);
                        if(muerteTardia)
                            funciones.mtdMostrarMensaje(
                                "Esta civilizacion cayo ante su muerte" +
                                "\nDetendremos la simulacion para dejarla descansar en paz", 
                                "MUERTE DE LA CIVILIZACION");
                        else if(repeticionInstantanea)
                            funciones.mtdMostrarMensaje(
                                "Esta civilizacion posee una vida infinita y en paz" +
                                "\nDetendremos la simulacion para dejarlos vivir su inmortalidad", 
                                "CIVILIZACION INMORTAL DE PAZ");
                        else if(repeticionTardia)
                            funciones.mtdMostrarMensaje(
                                "Esta civilizacion posee una vida infinita y alegre" +
                                "\nDetendremos la simulacion para que vivan alegremente su inmortalidad", 
                                "CIVILIZACION ALEGRE INMORTAL");
                        break;
                    }
                    vida.siguiente();
                }
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
    
    int mtdIngresarPositivo(Object mensaje, String titulo){
        while (true) {
            int valor = (int)mtdIngresarNumero(mensaje, titulo);
            if(valor > 0)
                return valor;
            mtdMostrarMensajeError("DEBE SER UN VALOR POSITIVO");
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

    int mtdIngresarMayorA5(Object mensaje, String titulo){
        while (true) {
            int valor = (int)mtdIngresarNumero(mensaje, titulo);
            if(valor >= 5)
                return valor;
            mtdMostrarMensajeError("DEBE SER UN VALOR MAYOR O IGUAL A 5");
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

    Forma mtdElegirForma(Object mensaje, String titulo){
        while(true){
            int opcion = JOptionPane.showOptionDialog(
                null, mensaje, titulo, 
                JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, 
                "X; Cuadrado; Cruz; X y Cuadrado; X y Cruz; Cuadrado y Cruz; X, Cuadrado y Cruz".split("; "), 
                0);
            switch (opcion) {
                case 0:
                    return Forma.X;    
                case 1:
                    return Forma.Cuadrado;
                case 2:
                    return Forma.Cruz;
                case 3:
                    return Forma.X_Cuadrado;
                case 4:
                    return Forma.X_Cruz;
                case 5:
                    return Forma.Cuadrado_Cruz;
                case 6:
                    return Forma.X_Cruz_Cuadrado;
            }
        }
    }
}
