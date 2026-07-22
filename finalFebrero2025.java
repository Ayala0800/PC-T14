public class finalFebrero2025 {

    public static final int MAXA = 39;
    public static final int N = 1;
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        
        char [] patentes = {' ','C', 'R', 'D', '2', '2', '3', ' ', 'R', 'P', 'N', '2', '3', '4', ' ', 'A', 'B', '9', '7', 'O', 'E', 'R',' ','C', 'R', 'D', '2', '2', '3',' ','C', 'R', 'D', '2', '2', '3',' ', ' ', ' '};

        char [] resultado = new char[MAXA];

        int inicioMayor = 0;
        int finMayor = 0;

        

        recorrerPatentes(patentes, resultado, inicioMayor, finMayor);
        System.out.println("Patente con mayor ocurrencías: ");
        mostrarMayorPatente(patentes, inicioMayor, finMayor);
        System.out.println("arreglo Resultado: ");
        for(int i = 0; i < MAXA; i++){
            System.out.print("|"+resultado[i]);
        }
        System.out.println("");
    }

    public static void mostrarMayorPatente(char [] arreglo, int inicioMayor, int finMayor){
        for(int i = inicioMayor; i<finMayor;i++){
            System.out.println("|"+arreglo[i]);
        }
        System.out.println("");
    }

    public static void recorrerPatentes(char [] arreglo, char [] resultado, int inicioMayor, int finMayor){

        int contadorOcurrencias = 0;
        int contadorMayor = 0;
        int inicio = 0;
        int fin = -1;
        

        while(inicio < MAXA){
            inicio = obtener_inicio_secuencia_desde(arreglo, fin + 1);
            if(inicio < MAXA){
                fin = obtener_fin_secuencia(arreglo, inicio);
                int tamaño = fin - inicio + 1;

                //una vez encontrada la primer secuencia
                buscarSecuenciasYcomparar(arreglo, inicio, fin, tamaño, contadorOcurrencias, resultado);
            }
        }

        if(contadorOcurrencias > contadorMayor){
            inicioMayor = inicio;
            finMayor = fin;
        }

    }

    public static void buscarSecuenciasYcomparar(char [] arreglo, int inicio, int fin, int tamaño, int contadorOcurrencias, char [] resultado){

        int inicio2 = fin + 1;
        int fin2 = fin;

        while(inicio2 < MAXA){
            inicio2 = obtener_inicio_secuencia_desde(arreglo, fin2+1);
            if(inicio2 < MAXA){
                fin2 = obtener_fin_secuencia(arreglo, inicio2);
                //una vez encontre la proxima secuencia:
                int tamaño2 = fin2 - inicio2 + 1;
                if(tamaño == tamaño2){
                    if(sonIguales(arreglo, inicio, fin, inicio2)){
                        contadorOcurrencias++;
                    }
                }
            }
        }

        if(contadorOcurrencias > N){
            //si aparecio las secuencia aparecio mas de N veces lo copio en resultado.
            copiarEnResultado(arreglo, inicio, fin, resultado);
        }

    }

    public static void copiarEnResultado(char [] arreglo, int inicio, int fin, char [] resultado){
        //copio la secuencia q se repitio mas de N veces en el arreglo "resultado".
        for(int i = inicio; i<fin;i++){
            resultado [i+1] = arreglo[i];
        }
        resultado[fin+1] = ' ';
    }

    public static boolean sonIguales(char [] arreglo, int inicio, int fin, int inicio2){

        while(inicio <= fin && arreglo[inicio] == arreglo[inicio2]){
            inicio++;
            inicio2++;
        }
        return inicio > fin;
    }

    public static int obtener_inicio_secuencia_desde(char [] arreglo, int desde){
        int i = desde;
        while (i < MAXA && arreglo[i] == SEPARADOR) {
            i++;
        }
        return i;
    }

    public static int obtener_fin_secuencia(char [] arreglo, int inicio) {
        int i = inicio;
        while (i < MAXA && arreglo[i] != SEPARADOR) {
            i++;
        }
        return i - 1;
    }
}