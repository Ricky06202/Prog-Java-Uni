package MiPaqueteRicardoSanjur.CuadradoMagico;

public class Cuadrado{
    private int[][] cuadrado;
    private int tamaño, numeroMagico;
    private String textoCuadrado, textoSumaFila, textoSumaColumna, textoSumaDiagonal;
    
    public Cuadrado(int tamaño){
        this.tamaño = tamaño;
        cuadrado = new int[tamaño][tamaño];
        numeroMagico = tamaño * ((int)Math.pow(tamaño, 2) + 1) / 2;
        llenarCuadrado();
        textoCuadrado = calcularCuadrado();
        textoSumaFila = calcularSumaFila();
        textoSumaColumna = calcularSumaColumna();
        textoSumaDiagonal = calcularSumaDiagonal();
    }

    @Override
    public String toString() {
        return textoCuadrado + "\nEl numero magico es de: " + numeroMagico;
    }

    public String sumatoriasString(){
        return textoSumaFila + textoSumaColumna + textoSumaDiagonal;
    }

    public void llenarCuadrado(){
        int numero = 0, fila = 0, columna = tamaño/2, 
        filaAterior = fila, columnaAterior = columna;
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

    public String calcularCuadrado(){
        String textoCuadrado = "";
        for (int[] fila : cuadrado) {
            for (int elemento : fila)
                textoCuadrado += String.format("%4d ",elemento);
            textoCuadrado += "\n";
        }
        return textoCuadrado;
    }

    public String calcularSumaFila(){
        int suma;
        String sumaFila = "";
        System.out.println();
        for (int fila = 0; fila < cuadrado.length; fila++) {
            suma = 0;
            for (int columna = 0; columna < cuadrado.length; columna++) 
                suma += cuadrado[fila][columna];
            sumaFila += String.format("Sumatoria de la Fila %d: %d\n",fila, suma);
        }
        return sumaFila;
    }

    public String calcularSumaColumna(){
        int suma;
        String sumaColumna = "";
        System.out.println();
        for (int columna = 0; columna < cuadrado.length; columna++) {
            suma = 0;
            for (int fila = 0; fila < cuadrado.length; fila++) 
                suma += cuadrado[fila][columna];
            sumaColumna += String.format("Sumatoria de la Columna %d: %d\n",columna, suma);
        }
        return sumaColumna;
    }

    public String calcularSumaDiagonal(){
        int sumaDiagonalIzquierda = 0;
        int sumaDiagonalDerecha = 0;
        String sumaDiagonal = "";
        System.out.println();
        for (int izquierda = 0, derecha = cuadrado.length-1; izquierda < cuadrado.length; izquierda++, derecha--) {
            sumaDiagonalIzquierda += cuadrado[izquierda][izquierda];
            sumaDiagonalDerecha += cuadrado[izquierda][derecha];
        }
        sumaDiagonal += String.format("Sumatoria de la Diagonal de Izquierda superior hasta Derecha inferior: %d\n", sumaDiagonalIzquierda);
        sumaDiagonal += String.format("Sumatoria de la Diagonal de Derecha superior hasta Izquierda inferior: %d\n", sumaDiagonalDerecha);
        return sumaDiagonal;
    }

	/**
	 * @return el tamaño de la matriz
	 */
	public int getTamaño() {
		return tamaño;
	}

}