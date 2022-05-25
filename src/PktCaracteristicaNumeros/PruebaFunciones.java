package PktCaracteristicaNumeros;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PruebaFunciones {
    ClsCaracteristicaNumeros funciones = new ClsCaracteristicaNumeros();
    @Test
    public void pruebaDeEnteroPotencia(){
        assertEquals((int)Math.pow(2,3), funciones.enteroPotencia(2,3));
        assertEquals((int)Math.pow(3,4), funciones.enteroPotencia(3,4));
        assertEquals((int)Math.pow(4,5), funciones.enteroPotencia(4,5));
        assertEquals((int)Math.pow(5,6), funciones.enteroPotencia(5,6));
    }
}
