package PktActividad6;

import javax.swing.JOptionPane;

public class ClsTestHerencia2 {
    public static void main(String[] args) {
        var objFunciones = new ClsTestHerencia2();
        while (true) {
            int opcion = JOptionPane.showOptionDialog(
                null, 
                "Seleccione Una De Las Siguientes Opciones", 
                "Menu Principal           (Cierre Esta Ventana Para Terminar El Programa)", 
                JOptionPane.NO_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                "Producto Fresco, Producto Refrigerado, Producto Congelado".split(", "), 
                null);
            if (opcion == -1)
                System.exit(0);
            ClsProducto producto;
            ClsFecha fechaCaducidad = objFunciones.mtdIngresarFecha("Caducidad");
            int lote = (int)objFunciones.mtdIngresarPositivo("Ingrese El Numero De Lote", "NUMERO DE LOTE");
            switch (opcion) {
                case 0:// fresco
                    ClsFecha fechaEnvasado = objFunciones.mtdIngresarFecha("Envasado");
                    String pais = objFunciones.mtdIngresarTexto("Ingrese El Pais De Origen", "PAIS DE ORIGEN");
                    producto = new ClsProductoFresco(fechaCaducidad, lote, fechaEnvasado, pais);
                    objFunciones.mtdMostrarMensaje(producto, "PRODUCTO FRESCO");
                    break;
                case 1:// refrigerado
                    String codigo = objFunciones.mtdIngresarTexto("Ingrese El Codigo del Organismo De Supervision Alimentaria", "Codigo del Organismo De Supervision Alimentaria".toUpperCase());
                    producto = new ClsProductoRefrigerado(fechaCaducidad, lote, codigo);
                    objFunciones.mtdMostrarMensaje(producto, "PRODUCTO REFRIGERADO");
                    break;
                case 2:// congelado
                    float temperatura = objFunciones.mtdIngresarNumero("Ingrese La Temperatura(°C) Recomendada", "Temperatura Recomendada".toUpperCase());
                    producto = new ClsProductoCongelado(fechaCaducidad, lote, temperatura);
                    objFunciones.mtdMostrarMensaje(producto, "PRODUCTO CONGELADO");
                    break;
            }
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

    String mtdIngresarTexto(Object mensaje, String titulo){
        while (true) {
        
            String texto = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            if(texto != null && !texto.trim().equals(""))
            return texto;
            mtdMostrarMensajeError("NO PUEDE DEJAR VACIO ESTE CAMPO DE TEXTO","ERROR TEXTO INVALIDO");
        
        }
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
    
    float mtdIngresarPositivo(Object mensaje, String titulo){
        while (true) {
            float valor = mtdIngresarNumero(mensaje, titulo);
            if(valor > 0)
                return valor;
                mtdMostrarMensajeError("DEBE SER UN VALOR POSITIVO");
            }
    }
    
    int mtdIngresarDia(Object mensaje, String titulo, int mes, int año){
        boolean tiene31 = mes <= 7 && mes % 2 == 1 || mes >= 8 && mes % 2 == 0;
        boolean esBisiesto = año % 4 == 0;
        boolean esFebrero = mes == 2;
        int maximoDeDias;
        if(esFebrero)
        if(esBisiesto)
        maximoDeDias = 29;
        else
        maximoDeDias = 28;
        else if(tiene31)
        maximoDeDias = 31;
        else
        maximoDeDias = 30;
        while (true) {
            int dia = (int)mtdIngresarPositivo(mensaje, titulo);
            if(dia <= maximoDeDias)
            return dia;
            mtdMostrarMensajeError("DIA INCORRECTO, DEBE SER UN NUMERO MENOR O IGUAL A " + maximoDeDias);
        }
    }

    int mtdIngresarMes(Object mensaje, String titulo){
        while (true) {
            int mes = (int)mtdIngresarPositivo(mensaje, titulo);
            if(mes <= 12)
                return mes;
            mtdMostrarMensajeError("MES INCORRECTO, DEBE SER UN NUMERO MENOR O IGUAL A 12");
        }
    }

    ClsFecha mtdIngresarFecha(String tipo){
        int año = (int)mtdIngresarPositivo("Ingrese El Año De " + tipo, "AÑO DE " + tipo.toUpperCase());
        int mes = mtdIngresarMes("Ingrese El Mes De " + tipo, "MES DE " + tipo.toUpperCase());
        int dia = mtdIngresarDia("Ingrese El Dia De " + tipo, "DIA DE " + tipo.toUpperCase(), mes, año);
        return new ClsFecha(dia, mes, año);
    } 
}
