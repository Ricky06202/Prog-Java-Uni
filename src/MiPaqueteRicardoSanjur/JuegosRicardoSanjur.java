package MiPaqueteRicardoSanjur;
// Proyecto 3 = Cuadrado Magico
// Proyecto 4 = Juego De La Vida

public class JuegosRicardoSanjur {
    
}

class CuadradoMagico{
    private int[][] cuadrado;
    private int tamaño;
    
    public CuadradoMagico(int tamaño){
        this.tamaño = tamaño;
        cuadrado = new int[tamaño][tamaño];
    }

    public void llenarCuadrado(){
        int numero = 0, fila = 0, columna = tamaño/2, filaAterior = fila, columnaAterior = columna;
        while (++numero <= tamaño*tamaño) {
            if(cuadrado[fila][columna] != 0) {
                fila = filaAterior + 1;
                columna = columnaAterior;
            }
            cuadrado[fila][columna] = numero;
            filaAterior = fila--;
            columnaAterior = columna++;
            if(fila < 0)
                fila += tamaño;
            if(columna == tamaño)
                columna = 0; 
        }
    }
}
