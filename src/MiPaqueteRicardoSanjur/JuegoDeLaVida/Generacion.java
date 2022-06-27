package MiPaqueteRicardoSanjur.JuegoDeLaVida;

public class Generacion{
    private int tamaño;
    private char[][] universo;
    private Forma forma;
    private Patron patron;
    private char simboloCelula = '*';

	/**
	 * @param tamaño
	 * @param forma
	 */
	public Generacion(int tamaño, Forma forma) {
		this.tamaño = tamaño;
		this.forma = forma;
        elegirPatron(forma);
        universo = new char[tamaño][tamaño];
        generarUniverso();
        mostrarUniverso();
	}

	/**
	 * @param tamaño
	 * @param universo
	 */
	public Generacion(char[][] universo) {
		this.tamaño = universo.length;
		this.universo = universo;
	}

    public void mostrarUniverso(){
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                System.out.printf("%c", universo[fila][columna]);
            }
            System.out.println();
        }
    }
    
    public void elegirPatron(Forma forma){
        switch (forma) {
            case X:
                patron = (f,c,t) -> f == c || (f + c) == (t - 1);
                break;
            case Cuadrado:
                patron = (f,c,t) -> f == 1 || f == (t - 2) || c == 1 || c == (t - 2);
                break;
            case X_Cuadrado:
                patron = (f,c,t) -> f == c || f + c == t - 1 || 
                f == 1 || f == t - 2 || c == 1 || c == t - 2; 
                break;
            case Cruz:
                patron = (f,c,t) -> f == (t / 2) || c == (t / 2);
                break;
            case X_Cruz:
                patron = (f,c,t) -> f == c || f + c == t - 1 ||
                f == t / 2 || c == t / 2;
                break;
            case X_Cruz_Cuadrado:
                patron = (f,c,t) -> f == c || f + c == t - 1 ||
                f == 1 || f == t - 2 || c == 1 || c == t - 2 ||
                f == t / 2 || c == t / 2;
                break;
            default:
                patron = null;
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
}