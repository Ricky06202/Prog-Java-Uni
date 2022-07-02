package TrabajoFinal;

class ArrObj{
    private Cedula cedula;
    private NombreCompleto nombreCompleto;
    private Notas parciales, laboratorios;
    private int semestral;
    
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
    }

    
}