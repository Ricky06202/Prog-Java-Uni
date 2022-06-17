package PktActividad6;

class ClsFecha {
    private int dia;
    private int mes;
    private int año;

    public ClsFecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public ClsFecha() {
        this(0, 0, 0);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d",dia, mes, año);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    
}