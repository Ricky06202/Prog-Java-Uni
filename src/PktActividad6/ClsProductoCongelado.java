package PktActividad6;

class ClsProductoCongelado extends ClsProducto {
    private float temperatura;

    public ClsProductoCongelado(ClsFecha caducidad, int lote, float temperatura) {
        super(caducidad, lote);
        this.temperatura = temperatura;
    }

    public ClsProductoCongelado(){
        super();
        temperatura = 0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nTemperatura recomendada = %.2f °C", temperatura);
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    
}