package TrabajoFinal;

public class ClsCalculo {
    int mtdPromedio(Notas parciales, Notas laboratorios, int semestral){
        parciales.setPorcentaje(30);
        float promedio = parciales.getPromedio();

        laboratorios.setPorcentaje(35);
        promedio += laboratorios.getPromedio();

        float porcentajeSemestral = 35 / 100f;
        promedio += semestral * porcentajeSemestral;
        
        return (int)promedio;
    }
    
    String mtdNota(int promedio){
        return promedio >= 91 ? "A" :
        promedio >= 81 ? "B" : 
        promedio >= 71 ? "C" :
        promedio >= 61 ? "D" :
        promedio >= 0 ? "F" : "SE";
    }
}
