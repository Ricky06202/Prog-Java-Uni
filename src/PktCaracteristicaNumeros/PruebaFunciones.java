package PktCaracteristicaNumeros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PruebaFunciones {
    ClsCaracteristicaNumeros funciones = new ClsCaracteristicaNumeros();
    @Test
    public void pruebaEnteroPotencia(){
        assertEquals((int)Math.pow(2,3), funciones.enteroPotencia(2,3));
        assertEquals((int)Math.pow(3,4), funciones.enteroPotencia(3,4));
        assertEquals((int)Math.pow(4,5), funciones.enteroPotencia(4,5));
        assertEquals((int)Math.pow(5,6), funciones.enteroPotencia(5,6));
    }
    @Test
    public void pruebaPrimo(){
        assertEquals('X',funciones.calc_primo(1));
        assertEquals('P',funciones.calc_primo(2));
        assertEquals('P',funciones.calc_primo(3));
        assertEquals('X',funciones.calc_primo(4));
    }
    @Test
    public void pruebaPerfecto(){
        assertEquals('P',funciones.calc_perfecto(28));
        assertEquals('P',funciones.calc_perfecto(496));
        assertEquals('P',funciones.calc_perfecto(8128));
    }
    @Test
    public void pruebaInvertido(){
        assertEquals(321,funciones.calc_invertir(123));
        assertEquals(654,funciones.calc_invertir(456));
    }
    @Test
    public void pruebaCifras(){
        assertEquals(1,funciones.calc_cifras(0));
        assertEquals(6,funciones.calc_cifras(123456));
        assertEquals(4,funciones.calc_cifras(1233));
    }
    @Test
    public void pruebaAbundante(){
        assertTrue(funciones.calc_abundante(12));
        assertTrue(funciones.calc_abundante(18));
        assertTrue(funciones.calc_abundante(20));
        assertTrue(funciones.calc_abundante(24));
        assertTrue(funciones.calc_abundante(100));
        assertTrue(funciones.calc_abundante(102));
    }
    @Test
    public void pruebaArmstrong(){
        assertTrue(funciones.calc_armstrong(371));
        assertTrue(funciones.calc_armstrong(8208));
        assertTrue(funciones.calc_armstrong(4210818));
    }
    @Test
    public void pruebaParImpar(){
        assertEquals('P',funciones.calc_parImpar(0));
        assertEquals('I',funciones.calc_parImpar(1));
        assertEquals('I',funciones.calc_parImpar(23));
        assertEquals('P',funciones.calc_parImpar(432));
    }
    @Test
    public void pruebaFactorial(){
        assertEquals(1,funciones.calc_factorial(0));
        assertEquals(1,funciones.calc_factorial(1));
        assertEquals(2,funciones.calc_factorial(2));
        assertEquals(6,funciones.calc_factorial(3));
        assertEquals(24,funciones.calc_factorial(4));
    }
    @Test
    public void pruebaAmigos(){
        assertEquals('A',funciones.calc_amigos(220,284));
        assertEquals('A',funciones.calc_amigos(1184,1210));
        assertEquals('A',funciones.calc_amigos(2620,2924));
    }
    @Test
    public void pruebaCapicua(){
        assertEquals('C',funciones.calc_capicua(212));
        assertEquals('C',funciones.calc_capicua(1001));
        assertEquals('C',funciones.calc_capicua(12321));
        assertEquals('C',funciones.calc_capicua(2893982));
    }
}
