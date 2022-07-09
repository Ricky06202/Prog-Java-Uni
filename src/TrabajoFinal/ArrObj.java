package TrabajoFinal;

public class ArrObj{
    private Cedula cedula;
    private NombreCompleto nombreCompleto;
    private Notas parciales, laboratorios;
    private int semestral;
    private int promedio;
    private String notaLetra;
    
    /**
     * @param cedula
     * @param nombreCompleto
     * @param parciales
     * @param laboratorios
     * @param semestral
     */
    public ArrObj(Cedula cedula, NombreCompleto nombreCompleto, Notas parciales, Notas laboratorios, int semestral) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.parciales = parciales;
        this.laboratorios = laboratorios;
        this.semestral = semestral;
        var calculo = new ClsCalculo();
        promedio = calculo.mtdPromedio(this.parciales, this.laboratorios, this.semestral);
        notaLetra = calculo.mtdNota(promedio);
    }

    @Override
    public String toString() {
        return String.format("%-23s %-40s %6d %18s\n\n", 
        cedula.toString(), nombreCompleto.toString(), 
        promedio, notaLetra);
    }
    
}