package MiPaqueteRicardoSanjur.JuegoDeLaVida;

public class Vida {
    private int tamaño, cantidadGeneraciones;
    private Generacion generacion;
    private Forma forma;

	/**
	 * @param tamaño
	 * @param cantidadGeneraciones
	 * @param forma
	 */
	public Vida(int tamaño, int cantidadGeneraciones, Forma forma) {
		this.tamaño = tamaño;
		this.cantidadGeneraciones = cantidadGeneraciones;
		this.forma = forma;
        generacion = new Generacion(tamaño, forma);
	}
}