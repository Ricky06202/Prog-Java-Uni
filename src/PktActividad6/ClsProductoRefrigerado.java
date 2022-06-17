package PktActividad6;

class ClsProductoRefrigerado extends ClsProducto{
    private String codigo;

    public ClsProductoRefrigerado(ClsFecha caducidad, int lote, String codigo) {
        super(caducidad, lote);
        this.codigo = codigo;
    }

    public ClsProductoRefrigerado(){
        super();
        codigo = "";
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nCodigo del organismo de supervision alimentaria = " + codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
}