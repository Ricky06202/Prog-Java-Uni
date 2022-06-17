package PktActividad6;

class ClsProductoFresco extends ClsProducto{
    private ClsFecha envasado;
    private String pais;
    
    public ClsProductoFresco(ClsFecha caducidad, int lote, ClsFecha envasado, String pais){
        super(caducidad, lote);
        this.envasado = envasado;
        this.pais = pais;
    }
    
    public ClsProductoFresco(){
        super();
        envasado = new ClsFecha();
        pais = "";
    }

    @Override
    public String toString() {
        return super.toString() + "\nFecha de envasado = " + envasado + "\nPais de Origen = " + pais;
    }

    public ClsFecha getEnvasado() {
        return envasado;
    }

    public void setEnvasado(ClsFecha envasado) {
        this.envasado = envasado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
}