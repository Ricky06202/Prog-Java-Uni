package TrabajoFinal;

class NombreCompleto {
    private String nombre1, apellido1, 
    nombre2, apellido2;

    /**
     * @param nombre1
     * @param apellido1
     * @param nombre2
     * @param apellido2
     */
    public NombreCompleto(String nombre1, String apellido1, String nombre2, String apellido2) {
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.nombre2 = nombre2;
        this.apellido2 = apellido2;
    }  

    @Override
    public String toString() {
        return String.format("Nombre Completo: %s %s %s %s\n", 
        nombre1, apellido1, nombre2, apellido2);
    }
}