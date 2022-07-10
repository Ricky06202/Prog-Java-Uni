package TrabajoFinal;

public class Notas{
    private int nota1, nota2, nota3;
    private float porcentaje;

    /**
     * @param nota1
     * @param nota2
     * @param nota3
     */
    public Notas(int nota1, int nota2, int nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje/300f;
    }

    public float getPromedio(){
        return (nota1 + nota2 + nota3) * porcentaje;
    }
}