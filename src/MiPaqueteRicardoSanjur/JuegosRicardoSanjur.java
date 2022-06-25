package MiPaqueteRicardoSanjur;
// Proyecto 3 = Cuadrado Magico
// Proyecto 4 = Juego De La Vida

public class JuegosRicardoSanjur {
    public static void main(String[] args) {
        new Cuadrado(5);
    }
}

class Cuadrado{
    private int[][] cuadrado;
    private int tamaño;
    
    public Cuadrado(int tamaño){
        this.tamaño = tamaño;
        cuadrado = new int[tamaño][tamaño];
        llenarCuadrado();
        mostrarCuadradoConsola();
        mostrarSumaFilaConsola();
        mostrarSumaColumnaConsola();
        mostrarSumaDiagonalConsola();
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

    public void mostrarCuadradoConsola(){
        for (int[] fila : cuadrado) {
            for (int elemento : fila)
                System.out.printf("%4d ",elemento);
            System.out.println();
        }
    }

    public void mostrarSumaFilaConsola(){
        int suma;
        System.out.println();
        for (int fila = 0; fila < cuadrado.length; fila++) {
            suma = 0;
            for (int columna = 0; columna < cuadrado.length; columna++) 
                suma += cuadrado[fila][columna];
            System.out.printf("Sumatoria de la Fila %d: %d\n",fila, suma);
        }
    }

    public void mostrarSumaColumnaConsola(){
        int suma;
        System.out.println();
        for (int columna = 0; columna < cuadrado.length; columna++) {
            suma = 0;
            for (int fila = 0; fila < cuadrado.length; fila++) 
                suma += cuadrado[fila][columna];
            System.out.printf("Sumatoria de la Columna %d: %d\n",columna, suma);
        }
    }

    public void mostrarSumaDiagonalConsola(){
        int sumaDiagonalIzquierda = 0;
        int sumaDiagonalDerecha = 0;
        System.out.println();
        for (int diagonal_izquierda = 0, diagonal_derecha = cuadrado.length-1; diagonal_izquierda < cuadrado.length; diagonal_izquierda++, diagonal_derecha--) {
            sumaDiagonalIzquierda += cuadrado[diagonal_izquierda][diagonal_izquierda];
            sumaDiagonalDerecha += cuadrado[diagonal_derecha][diagonal_derecha];
        }
        System.out.printf("Sumatoria de la Diagonal de Izquierda superior hasta Derecha inferior: %d\n", sumaDiagonalIzquierda);
        System.out.printf("Sumatoria de la Diagonal de Derecha superior hasta Izquierda inferior: %d\n", sumaDiagonalDerecha);
    }


}
