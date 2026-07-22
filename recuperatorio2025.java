public class recuperatorio2025{

    /*
     * recorro x fila (atleta)
     * busco si existe secuencia (inicio y fin)
     * al encontrar una inicio un contador para saber en cual estoy parado.
     * SI el contador coincide con el arreglo F en la posicion contador:
     * preocesar secuencia
     * restar a cada elemento - E
     * si la resta es < 0 => corrimiento a izquierda
     * contar corrimiento para retornarlo luego.
     */
    
    public static final int MAXF = 4;
    public static final int MAXC = 26;
    public static final int E = 20;
    
    public static void main (String[]args){

        int[][] muestras = {{ -6, 12, 26, 20, 24, 18, -9, -3, 51, 17, 83, 50, -1, 69, 74, 58, -6, 25, 33, 34, -8, 10, 25, 25, 44, -9 },
                        { -1, -2, 85, 86, 88, -9, -5, 12, 15, 18, 20, 35, 38, -7, 60, 61, 64, 50, -5, 18, 18, -8, 77, 62, 99, -2 },
                        { -4, 13, 20, 19, 31, 37, -5, -6, -8, 26, 28, 40, 39, -2, 36, 38, 34, 32, -9, 38, 15, -8, 12, 25, 20, -6 },
                        { -7, 85, 58, 57, 96, -6, 36, 42, 52, 41, -5, 25, 28, 36, 40, -8, 63, 66, 70, -6, 28, 21, 16, 23, 17, -3 }};
        
        int[] arrF = {2, 3, 1, 5};
        

        System.out.println("\nMatriz Original: ");
        mostrarMatriz(muestras);
        recorrerMatriz(muestras, arrF);
        System.out.println("\nMatriz modificada ");
        mostrarMatriz(muestras);

    }

    public static void recorrerMatriz(int [][] muestras, int [] arrF){
        int total = 0;
        for(int i = 0; i < MAXF; i++){
            total+= recorrerFila(muestras[i], arrF[i], i);
        }
        System.out.println("\nel total de eliminaciones fue: "+ total);
    }

    public static int recorrerFila(int [] fila, int posSecFallida, int atleta){
        int inicio = 0;
        int fin = -1;
        int nroDeSec = 0; //indica en q secuencia estoy parado de la fila.

        while(inicio < MAXC && nroDeSec < posSecFallida){ //si ini no se pasa de rango y el orden de la secuencia q estoy x procesar es menor a la posicion de la sec fallida, ejecuto:

            inicio = obtener_inicio_secuencia_desde(fila, fin+1);
            if(inicio < MAXC){
                fin = obtener_fin_secuencia(fila, inicio);
                nroDeSec++;
                //si encontre una secuencia avanzo el contador para saber en q secuencia estoy parado.
            }
        }

        int eliminaciones = 0;

        if(nroDeSec == posSecFallida){
            eliminaciones = procesarSecuencia(fila, inicio, fin);
        }else{
            System.out.println("\nNo existe la muestra NRO. " + posSecFallida+" en el atleta "+atleta);
        }

        return eliminaciones;
    }

    public static int procesarSecuencia(int [] fila, int inicio, int fin){
        int contadorEliminaciones = 0;

        while(inicio <= fin){
            fila[inicio] = fila[inicio] - E;
            if(fila[inicio] < 0){
                corrimiento_izq(fila, inicio);
                contadorEliminaciones++;
                fin--; //se modifica donde termina la sec.
            }else{
                inicio++;
            }
        }
        //System.out.println("contadorEliminaciones "+contadorEliminaciones);
        return contadorEliminaciones;
    }
    public static int obtener_inicio_secuencia_desde(int [] arreglo, int desde){
        int i = desde;
        while(i < MAXC && arreglo[i] <= 0){
            i++;
        }
        return i; //devuelvo la posicion del primer elemento de la secuencia.
    }
    public static int obtener_fin_secuencia(int [] arreglo, int inicio){
        int i = inicio;
        while(i < MAXC && arreglo[i] > 0){
            i++;
        }
        return i-1; //devuelvo la posicion del ultimo elemento de la secuencia.
    }
    public static void corrimiento_izq(int [] arreglo, int posicion){
        for(int i=posicion;i<MAXC-1;i++){
            arreglo[i]=arreglo[i+1];
        }
    }
    public static void mostrarMatriz(int [][] matriz){
        for(int f = 0;f<MAXF;f++){
            for(int c = 0; c<MAXC;c++){
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println("");
        }
    }
}