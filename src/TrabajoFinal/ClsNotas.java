package TrabajoFinal;

import javax.swing.JOptionPane;

/**
 * ClsNotas
 */
public class ClsNotas {
    public static void main(String[] args) {
        final int cantidadEstudiantes = 5;
        for (int estudiante = 0; estudiante < cantidadEstudiantes; estudiante++) {
            
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

    String ingresarTexto(Object mensaje, String titulo){
        while (true) {
        
            String texto = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            if(texto != null && !texto.trim().equals(""))
                return texto;
            mtdMostrarMensajeError("NO PUEDE DEJAR VACIO ESTE CAMPO DE TEXTO","ERROR TEXTO INVALIDO");
        
        }
    }
    
}