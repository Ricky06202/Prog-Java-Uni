package TrabajoFinal;

import java.util.Arrays;

public class NombreCompleto {
    private char[] nombre1, apellido1, 
    nombre2, apellido2;

    /**
     * @param nombre1
     * @param apellido1
     * @param nombre2
     * @param apellido2
     */
    public NombreCompleto(String nombre1, String apellido1, String nombre2, String apellido2) {
        this.nombre1 = nombre1.toCharArray();
        this.apellido1 = apellido1.toCharArray();
        this.nombre2 = nombre2.toCharArray();
        this.apellido2 = apellido2.toCharArray();
    }  

    @Override
    public String toString() {
        return String.format("%s %s %s %s", 
        getApellido1(), getApellido2(), getNombre1(), getNombre2());
    }

    public String arregloACadena(char[] arreglo){
        return Arrays.toString(arreglo)
            .replace("[", "")
            .replace(", ", "")
            .replace("]", "");
    }

    /**
     * @return the nombre1
     */
    public String getNombre1() {
        return arregloACadena(nombre1);
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return arregloACadena(apellido1);
    }

    /**
     * @return the nombre2
     */
    public String getNombre2() {
        return arregloACadena(nombre2);
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return arregloACadena(apellido2);
    }

    
}