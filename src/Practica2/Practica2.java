package Practica2;

public class Practica2 {
    public static void main(String[] args) {
        var funciones = new Practica2();
        Integer[][] MAT = new Integer[4][4];
        //bucle 16 veces, leer cada vez la direccion y el valor
        // y mostrarlo cada vez para saber como va la matriz
        funciones.leerDireccionYValor(MAT);
    }

    public void leerDireccionYValor(Integer[][] MAT) {
        for (int numero = 0; numero < MAT.length * MAT.length; numero++) {
            mostrarMatrizIntuitiva(MAT);  
            System.out.println("Ingrese La Direccion en la que se añadira el valor");
            Coordenada direccion = ingresarCoordenada();
            if(!esValido(MAT, direccion)){
                System.out.println("LA DIRECCION PROPORCIONADA NO ES VALIDA POR QUE ESTA OCUPADA");
                numero--;
                continue;
            }
            int valor = ingresarNumero("Ingrese el Valor: ");
            añadirValor(MAT, direccion, valor);
        }
        mostrarMatrizIntuitiva(MAT);
    }

    void añadirValor(Integer[][] MAT, Coordenada direccion, int valor){
        MAT[direccion.getFila()][direccion.getColumna()] = valor;
    }

    boolean esValido(Integer[][] MAT, Coordenada direccion) {
        return MAT[direccion.getFila()][direccion.getColumna()] == null;
    }

    Coordenada ingresarCoordenada(){
        int fila = ingresarPositivoMenorA("Ingrese la fila deseada: ",4);
        int columna = ingresarPositivoMenorA("Ingrese la columna deseada: ",4);
        return new Coordenada(fila-1, columna-1);
    }

    int ingresarPositivoMenorA(String texto, int limite){
        while(true){
            int num = ingresarPositivo(texto);
            if(num <= limite)
                return num;
            System.out.println("\nERROR EL NUMERO DEBE SER MENOR IGUAL A " + limite);
        }
    }

    int ingresarPositivo(String texto){
        while(true){
            int num = ingresarNumero(texto);
            if(num > 0)
                return num;
            System.out.println("\nERROR EL NUMERO DEBE SER POSITIVO");
        }
    }

    int ingresarNumero(String texto){
        while (true) {
            try {
                System.out.print(texto);
                int num = Integer.parseInt(System.console().readLine());
                return num;
            } catch (Exception e) {
                System.out.println("\nERROR NUMERO INCORRECTO");
            }
        }
    }
    
    void mostrarMatrizIntuitiva(Integer[][] MAT){
        int numeroFila = 1;
        System.out.println(" #####################");
        System.out.println(" #  1 #  2 #  3 #  4 #");
        System.out.println(" #____#____#____#____#");
        for (Integer[] fila : MAT) {
            System.out.print(numeroFila++ + "|");
            for (Integer numero : fila) {
                System.out.print(String.format("%4d ",numero));
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
