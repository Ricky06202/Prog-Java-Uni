package TrabajoFinal;

class ArrObj{
    String tomo;
    int folio;
    int asiento;
    NombreCompleto nombreCompleto;
    Notas parciales;
    Notas laboratorios;
    int semestral;

    

    /**
     * @param tomo
     * @param folio
     * @param asiento
     * @param nombreCompleto
     * @param parciales
     * @param laboratorios
     * @param semestral
     */
    public ArrObj(String tomo, int folio, int asiento, NombreCompleto nombreCompleto, Notas parciales,
            Notas laboratorios, int semestral) {
        this.tomo = tomo;
        this.folio = folio;
        this.asiento = asiento;
        this.nombreCompleto = nombreCompleto;
        this.parciales = parciales;
        this.laboratorios = laboratorios;
        this.semestral = semestral;
    }
}