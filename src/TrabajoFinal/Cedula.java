package TrabajoFinal;

import java.util.Arrays;

class Cedula{
// son las partes de las cedula
    private char[] tomo;
    private int folio, asiento;
    
    /**
     * @param tomo
     * @param folio
     * @param asiento
     */
    public Cedula(String tomo, int folio, int asiento) {
        this.tomo = tomo.toCharArray();
        this.folio = folio;
        this.asiento = asiento;
    }
    
    @Override
    public String toString() {
        return String.format("%s-%d-%d", getTomo(), folio, asiento);
    }

    /**
     * @return the tomo
     */
    public String getTomo() {
        return Arrays.toString(tomo)
            .replace("[", "")
            .replace(", ", "")
            .replace("]", "");
    }  
}