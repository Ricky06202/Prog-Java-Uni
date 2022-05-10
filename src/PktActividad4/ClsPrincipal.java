package PktActividad4;
public class ClsPrincipal {
    public static void main(String[] args) {
        ClsSecundaria objDeClsSecundaria = new ClsSecundaria();
        while (true) {
            objDeClsSecundaria.mtdLimpiarPantalla();
            objDeClsSecundaria.mtdMenu();
            System.out.print("Ingrese La Opcion: ");
            int opcionElegida = objDeClsSecundaria.mtdLeerOpcion();
            System.out.println();
            switch (opcionElegida) {
                case 1:
                    objDeClsSecundaria.mtdCalculoDeInteres();
                    break;
                case 2:
                    objDeClsSecundaria.mtdComisionDelVendedor();
                    break;
                case 3:
                    objDeClsSecundaria.mtdTotalDeLaCompra();
                    break;
                case 4:
                    objDeClsSecundaria.mtdCalificacionFinal();
                    break;
                case 5:
                    objDeClsSecundaria.mtdPorcentajeDeGenero();
                    break;
                case 6:
                    objDeClsSecundaria.mtdCalculoDeLaEdadExacta();
                    break;
                case 7:
                    System.exit(0);
            }
            objDeClsSecundaria.mtdPausa();
        }
    }
}
