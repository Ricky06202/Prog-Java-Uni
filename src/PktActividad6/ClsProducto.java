package PktActividad6;

public class ClsProducto {
    private ClsFecha caducidad;
    private int lote;

    public ClsProducto(ClsFecha caducidad, int lote){
        this.caducidad = caducidad;
        this.lote = lote;
    }

    public ClsProducto(){
        this(new ClsFecha(),0);
    }

    

    @Override
    public String toString() {
        return "Fecha de caducidad = " + caducidad + "\nNumero de lote = " + lote;
    }

    public ClsFecha getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(ClsFecha caducidad) {
        this.caducidad = caducidad;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    
}
