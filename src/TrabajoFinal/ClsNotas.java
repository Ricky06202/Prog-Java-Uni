package TrabajoFinal;

import javax.swing.JOptionPane;

/**
 * ClsNotas
 */
public class ClsNotas {
    public static void main(String[] args) {
        var funciones = new ClsNotas();
        final int cantidadEstudiantes = 5;
        var estudiantes = new ArrObj[cantidadEstudiantes];
        for (int contador = 0; contador < cantidadEstudiantes; contador++) {
            String tomo = funciones.mtdIngresarTexto("Ingrese el Numero de Tomo de su Cedula", "INGRESAR TOMO",2);
            int folio = funciones.mtdIngresarPositivo("Ingrese el Numero de Folio de su Cedula", "INGRESAR FOLIO");
            int asiento = funciones.mtdIngresarPositivo("Ingrese el Numero de Asiento de su Cedula", "INGRESAR ASIENTO");
            var cedula = new Cedula(tomo, folio, asiento);

            String apellido1 = funciones.mtdIngresarTexto("Ingrese Su Primer Apellido", "INGRESAR PRIMER APELLIDO",10);
            String apellido2 = funciones.mtdIngresarTexto("Ingrese Su Segundo Apellido", "INGRESAR SEGUNDO APELLIDO",10);
            String nombre1 = funciones.mtdIngresarTexto("Ingrese Su Primer Nombre", "INGRESAR PRIMER NOMBRE",10);
            String nombre2 = funciones.mtdIngresarTexto("Ingrese Su Segundo Nombre", "INGRESAR SEGUNDO NOMBRE",10);
            var nombreCompleto = new NombreCompleto(nombre1, apellido1, nombre2, apellido2);

            int parcial1 = funciones.mtdIngresarNota("Ingrese la nota de su Parcial 1", "INGRESAR PARCIAL 1");
            int parcial2 = funciones.mtdIngresarNota("Ingrese la nota de su Parcial 2", "INGRESAR PARCIAL 2");
            int parcial3 = funciones.mtdIngresarNota("Ingrese la nota de su Parcial 3", "INGRESAR PARCIAL 3");
            var parciales = new Notas(parcial1, parcial2, parcial3);

            int laboratorio1 = funciones.mtdIngresarNota("Ingrese la nota de su Laboratorio 1", "INGRESAR LABORATORIO 1");
            int laboratorio2 = funciones.mtdIngresarNota("Ingrese la nota de su Laboratorio 2", "INGRESAR LABORATORIO 2");
            int laboratorio3 = funciones.mtdIngresarNota("Ingrese la nota de su Laboratorio 3", "INGRESAR LABORATORIO 3");
            var laboratorios = new Notas(laboratorio1, laboratorio2, laboratorio3);

            int semestral = funciones.mtdIngresarNota("Ingrese la nota de su Semestral", "INGRESAR SEMESTRAL");

            estudiantes[contador] = new ArrObj(cedula, nombreCompleto, parciales, laboratorios, semestral);
        }
        String registroGeneral = 
        "                          Registro General de los Estudiantes\n\n"+
        "    CEDULA              NOMBRE COMPLETO                  PROMEDIO    NOTA FINAL\n\n";
        for (ArrObj estudiante : estudiantes) 
            registroGeneral += estudiante.toString();
        funciones.mtdMostrarMensaje(registroGeneral, "REGISTRO GENERAL");
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
            if(valor >= 0)
                return valor;
            mtdMostrarMensajeError("DEBE SER UN VALOR POSITIVO");
        }
    }

    int mtdIngresarNota(Object mensaje, String titulo){
        while (true) {
            int valor = mtdIngresarPositivo(mensaje, titulo);
            if(valor <= 100)
                return valor;
            mtdMostrarMensajeError("DEBE SER MENOR O IGUAL A 100");
        }
    }

    String mtdIngresarTexto(Object mensaje, String titulo){
        while (true) {
        
            String texto = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            if(texto != null && !texto.trim().isEmpty())
                return texto.trim();
            mtdMostrarMensajeError("NO PUEDE DEJAR VACIO ESTE CAMPO DE TEXTO","ERROR TEXTO INVALIDO");
        
        }
    }

    String mtdIngresarTexto(Object mensaje, String titulo, int limiteCaracteres){
        while (true) {
            String texto = mtdIngresarTexto(mensaje, titulo);
            if(texto.length() <= limiteCaracteres)
                return texto;
            mtdMostrarMensajeError("LIMITE DE CARACTERES EXCEDIDO, NO PUEDE INGRESAR MAS DE " + limiteCaracteres + " CARACTERES","ERROR TEXTO INVALIDO");
        }
    }
}