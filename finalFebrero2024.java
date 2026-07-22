public class finalFebrero2024{

    final static int M = 15;
    final static int N = 3;
    final static int X = 200;
    final static int SEPARADOR = 0;
    public static void main(String[] args) {

        int [][] ventas = {
                        {0,0,150,200,165,0,154,352,240,256,0,900,750,0,0,},
                        {0,940,105,265,845,215,0,245,65,48,0,741,125,542,0},
                        {0,851,543,625,845,914,0,754,184,0,637,917,0,0,0}
                        };

        int [] arregloA = {1, 3, 0}; //meses a procesar

        recorrerMatriz(ventas, arregloA);


    }

    public static void recorrerMatriz(int [][] matriz, int [] arregloA){
        for(int j = 0; j < arregloA.length; j++){
            int mes = arregloA[j];

            if(mes > 0 && mes <= N){ // mes válido
                int cantDias = procesarFila(matriz[mes-1]); 
                System.out.println("Para el mes " + mes + " la cantidad de días que cumplen es: " + cantDias);
            }
        }
    }

    public static boolean esMesSolicitado(int fila, int mesSolicitado){
        if(fila == mesSolicitado-1){
            return true;
        }
        return false;
    }

    public static int procesarFila(int [] fila){
        int ini = 0;
        int fin = -1;
        int diasSuperioresX = 0;

        while(ini < M){
            ini = obtener_inicio_secuencia_desde(fila, fin+1);
            fin = obtener_fin_secuencia(fila, ini);

            if(ini <= fin){
                if(esSecuenciaSuperiorProm(fila, ini, fin)){
                    diasSuperioresX++;
                }else{
                    eliminarSecuencia(fila, ini, fin);
                }
            }
        }
        return diasSuperioresX; //devuelvo cantidad de sec q tienen un prom > X
    }

    public static void eliminarSecuencia(int [] fila, int ini, int fin){
        for(int i = ini; i <= fin; i++){
            corrimientoIzq(fila, i);
        }
    }

    public static void corrimientoIzq(int [] arreglo, int posAmodificar){
        for(int i = posAmodificar; i < M-1; i++){
            arreglo[i] = arreglo[i+1];
        }
        arreglo[M-1] = 0;
    }


    public static boolean esSecuenciaSuperiorProm(int [] fila,int ini, int fin){
        double promedioSec = obtenerPromedio(fila, ini, fin);

        if( promedioSec > X){
            return true;
        }
        return false;
    }

    public static double obtenerPromedio(int [] fila, int ini, int fin){
        int suma = 0;
        int contador = 0;

        for(int pos = ini;pos<=fin;pos++){
            suma+=fila[pos];
            contador++;
        }

        return (double) suma/contador; //obtengo el promedio de las secuencia
    }

    public static int obtener_inicio_secuencia_desde(int [] arreglo, int desde) {
        int i = desde;
        while (i < M && arreglo[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int obtener_fin_secuencia(int [] arreglo, int inicio) {
        int i = inicio;
        while (i < M && arreglo[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }
}