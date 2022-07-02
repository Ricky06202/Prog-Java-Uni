package TrabajoFinal;

class Cedula{
// son las partes de las cedula
    private String tomo;
    private int folio, asiento;
    
    /**
     * @param tomo
     * @param folio
     * @param asiento
     */
    public Cedula(String tomo, int folio, int asiento) {
        this.tomo = tomo;
        this.folio = folio;
        this.asiento = asiento;
    }
    
    @Override
    public String toString() {
        return String.format("Cedula: %s-%d-%d\n", tomo, folio, asiento);
    }
}