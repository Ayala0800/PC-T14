public class r2 {

    final static int MAXF = 4;
    final static int MAXC = 26;

    public static void main(String[] args) {
        int[][] matM = {{ -6, 12, 26, 20, 24, 18, -9, -3, 56, 23, 88, 55, -1, 69, 74, 58, -6, 25, 33, 34, -8, 10, 25, 25, 44, -9 },
                        { -1, -2, 85, 86, 88, -9, -5, 12, 15, 18, 20, 35, 38, -7, 65, 66, 69, 55, -5, 18, 18, -8, 77, 62, 99, -2 },
                        { -4, 16, 18, 25, 36, 42, -5, -6, -8, 26, 28, 40, 39, -2, 36, 38, 34, 32, -9, 38, 15, -8, 12, 25, 20, -6 },
                        { -7, 85, 58, 57, 96, -6, 36, 42, 52, 41, -5, 25, 28, 36, 40, -8, 63, 66, 70, -6, 33, 26, 24, 28, 24, -3 }
                       };
        
        int[] arrF = {2, 3, 1, 5};
        int error = 25;

        procesarMatriz(matM, arrF, error);
        mostrarMatriz(matM);
    }

    public static void procesarMatriz(int[][] matM, int[] arrF, int error) {
        int total = 0;
        for (int i = 0; i < MAXF; i++) {
            total += procesarIndividuo(matM[i], arrF[i], error);
        }
        System.out.println("El total de eliminaciones fue: " + total);
    }

    public static int procesarIndividuo(int[] fila, int ordenElectroFallado, int error) {
        int ini = 0;
        int fin = -1;
        int orden = 0;

        while (ini < MAXC && orden < ordenElectroFallado) {
            ini = buscarInicio(fila, fin + 1);
            if (ini < MAXC) {
                fin = buscarFin(fila, ini);
                orden++;
            }
        }

        int totalEliminados = 0;
        
        if (orden == ordenElectroFallado) {
            // Se procesa la secuencia
            totalEliminados = procesarMuestraFallada(fila, ini, fin, error);
        }
        else {
            System.out.println("No existe la muestra " + ordenElectroFallado);
        }
        return totalEliminados;

    }

    public static int procesarMuestraFallada(int[] fila, int ini, int fin, int error) {
        int contadorEliminados = 0;
        
        while (ini <= fin) {
            if (fila[ini] < error) {
                correrAIzquierda(fila, ini);
                fin--;
                contadorEliminados++;
            }
            else {
                fila[ini] = fila[ini] - error;
                ini++;
            }
        }
        return contadorEliminados;
    }

    public static void correrAIzquierda(int[] arr, int pos) {
        for (int i = pos; i < MAXC - 1; i++)
            arr[i] = arr[i + 1];
    }

    public static int buscarInicio(int[] arr, int pos) {
        while (pos < MAXC && arr[pos] < 0) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while (pos < MAXC && arr[pos] >= 0)
            pos++;
        return pos - 1;
    }

    public static void mostrarMatriz(int[][] mat) {
        for (int i = 0; i < MAXF; i++)
            mostrarArreglo(mat[i]);
    }
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < MAXC; i++) {
            System.out.print(" | " + arr[i]);
        }
        System.out.println();
    }
}