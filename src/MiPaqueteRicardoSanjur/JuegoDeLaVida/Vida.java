package MiPaqueteRicardoSanjur.JuegoDeLaVida;

public class Vida {
    private Generacion generacion;
	private String parDeGeneraciones;

	/**
	 * @param tamaño
	 * @param cantidadGeneraciones
	 * @param forma
	 */
	public Vida(int tamaño, Forma forma) {
        generacion = new Generacion(tamaño, forma);
		textoParDeGeneraciones(generacion.toString(), generacion.siguiente());
	}

	@Override
	public String toString() {
		return parDeGeneraciones;
	}

	/**
	 * @return el universo de la generacion
	 */
	public char[][] getUniverso() {
		return generacion.getUniverso();
	}

	public void siguiente(){
		textoParDeGeneraciones(generacion.siguiente(), generacion.siguiente());
	}

	public void textoParDeGeneraciones(String generacion1, String generacion2){
		parDeGeneraciones = "";
		String[] lineas1 = generacion1.split("\n");
		String[] lineas2 = generacion2.split("\n");
		for (int linea = 0; linea < lineas1.length; linea++) 
			parDeGeneraciones += lineas1[linea] + "    " + lineas2[linea] + "\n";
	}

	public boolean hayVidaInfinita(String generacion1, String generacion2){
		return generacion1.substring(generacion1.indexOf("\n") + 1).equals(
			generacion2.substring(generacion2.indexOf("\n") + 1));
	}
}