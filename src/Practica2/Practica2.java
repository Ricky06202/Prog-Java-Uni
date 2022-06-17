package Practica2;

public class Practica2 {
    public static void main(String[] args) {
        var funciones = new Practica2();
        int[][] MAT = new int[4][4];
        //bucle 16 veces, leer cada vez la direccion y el valor
        // y mostrarlo cada vez para saber como va la matriz
        funciones.mostrarMatrizIntuitiva(MAT);
    }

    Coordenada ingresarCoordenada(){
        int fila = ingresarPositivoMenorA(4);
        int columna = ingresarPositivoMenorA(4);
        return new Coordenada(fila, columna);
    }

    int ingresarPositivoMenorA(int limite){
        while(true){
            int num = ingresarPositivo();
            if(num <= limite)
                return num;
            System.out.println("ERROR EL NUMERO DEBE SER MENOR IGUAL A" + limite);
        }
    }

    int ingresarPositivo(){
        while(true){
            int num = ingresarNumero();
            if(num > 0)
                return num;
            System.out.println("ERROR EL NUMERO DEBE SER POSITIVO");
        }
    }

    int ingresarNumero(){
        while (true) {
            try {
                int num = Integer.parseInt(System.console().readLine());
                return num;
            } catch (Exception e) {
                System.out.println("ERROR NUMERO INCORRECTO");
            }
        }
    }
    
    void mostrarMatrizIntuitiva(int[][] MAT){
        int numeroFila = 1;
        System.out.println("    1    2    3    4 ");
        System.out.println("##____#____#____#____##");
        for (int[] fila : MAT) {
            System.out.print(numeroFila++ + "|");
            for (int numero : fila) {
                System.out.print(String.format(" %3d ",numero));
            }
            System.out.println();
        }
    }
}

class Coordenada{
    private int fila;
    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
