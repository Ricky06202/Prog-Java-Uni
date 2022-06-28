package MiPaqueteRicardoSanjur.JuegoDeLaVida;

public class Generacion{
    private int tamaño, generacionActual = 1;
    private String textoUniverso;
    private char[][] universo;
    private Forma forma;
    private Patron patron;
    private char simboloCelula = '*', 
    simboloBordeHorizontal = '#', simboloBordeVertical = '#';

	/**
	 * @param tamaño
	 * @param forma
	 */
	public Generacion(int tamaño, Forma forma) {
		this.tamaño = tamaño;
		this.forma = forma;
        elegirPatron();
        universo = new char[tamaño][tamaño];
        vaciarUniverso();
        generarUniverso();
        generarMarco();
	}

	/**
	 * @param tamaño
	 * @param universo
	 */
	public Generacion(char[][] universo) {
		this.tamaño = universo.length;
		this.universo = universo;
	}

    /**
     * @return the universo
     */
    public char[][] getUniverso() {
        return universo;
    }

    @Override
    public String toString() {
        textoUniverso();
        return String.format("%s%s%d%s\n", 
        " ".repeat(textoUniverso.split("\n")[0].length()/2 - 5),
        "UNIVERSO ", generacionActual++, 
        " ".repeat(textoUniverso.split("\n")[0].length()/2 - 5)) + textoUniverso;
    }

    public void textoUniverso(){
        textoUniverso = "";
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                textoUniverso += String.format("%c ", universo[fila][columna]);
            }
            textoUniverso += "\n";
        }
    }

    public String siguiente(){
        char[][] universoSiguiente = new char[tamaño][tamaño];
        vaciarUniverso(universoSiguiente);
        for (int fila = 1; fila < tamaño - 1; fila++) 
            for (int columna = 1; columna < tamaño - 1; columna++) {
                int vecinos = 0;
                for (int filaVecino = fila - 1; filaVecino <= fila + 1; filaVecino++) 
                    for (int columnaVecino = columna - 1; columnaVecino <= columna + 1; columnaVecino++) 
                        if(universo[filaVecino][columnaVecino] == simboloCelula)
                            vecinos++;
                    if(vecinos == 3)
                        universoSiguiente[fila][columna] = simboloCelula;
            }
        
        universo = universoSiguiente;
        generarMarco();
        return this.toString();
    }

    public boolean sigueAlguienVivo(){
        for (int fila = 0; fila < tamaño; fila++) 
            for (int columna = 0; columna < tamaño; columna++) 
                if(universo[fila][columna] == simboloCelula)
                    return true;
        return false;
    }

    public void mostrarUniverso(){
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                System.out.printf("%c", universo[fila][columna]);
            }
            System.out.println();
        }
    }
    
    public void elegirPatron(){
        switch (forma) {
            case X:
                patron = (f,c,t) -> f == c || (f + c) == (t - 1);
                break;
            case Cuadrado:
                patron = (f,c,t) -> f == 1 || f == (t - 2) || c == 1 || c == (t - 2);
                break;
            case Cruz:
                patron = (f,c,t) -> f == (t / 2) || c == (t / 2);
                break;
            case X_Cuadrado:
                patron = (f,c,t) -> f == c || f + c == t - 1 || 
                f == 1 || f == t - 2 || c == 1 || c == t - 2; 
                break;
            case X_Cruz:
                patron = (f,c,t) -> f == c || f + c == t - 1 ||
                f == t / 2 || c == t / 2;
                break;
            case Cuadrado_Cruz:
                patron = (f,c,t) -> f == 1 || f == (t - 2) || c == 1 || c == (t - 2) ||
                f == (t / 2) || c == (t / 2);
                break;
            case X_Cruz_Cuadrado:
                patron = (f,c,t) -> f == c || f + c == t - 1 ||
                f == 1 || f == t - 2 || c == 1 || c == t - 2 ||
                f == t / 2 || c == t / 2;
        }
    }

    public void generarUniverso(){
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                if(patron.activo(fila, columna, tamaño))
                    universo[fila][columna] = simboloCelula;
            }
        }
    }

    public void generarMarco(){
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                if(fila == 0 || fila == tamaño - 1 )
                    universo[fila][columna] = simboloBordeHorizontal;
                if(columna == 0 || columna == tamaño - 1)
                    universo[fila][columna] = simboloBordeVertical;
            }
        }
    }

    public void vaciarUniverso(){
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                universo[fila][columna] = ' ';
            }
        }
    }

    public void vaciarUniverso(char[][] universo){
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                universo[fila][columna] = ' ';
            }
        }
    }
}