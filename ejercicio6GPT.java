public class ejercicio6GPT {
    public static final int MAXC = 10;
    public static final int MAXF = 4;

    public static void main(String[] args) {
        
        char [][] matriz = {
                            {'A','X','3','5','7','A','2','2','B','B'},
                            {'A','7','7','B','5','5','6','A','1','B'},
                            {'E','R','U','8','9','A','5','2','P','I'},
                            {'A','8','8','2','3','A','1','A','B','B'}
                            };

        System.out.println("La fila con mayor cantidad de secuencias númericas es la fila: "+ obtenerFila(matriz));
        System.out.println("");
        mostrarMatriz(matriz);
        
    }

    public static int obtenerFila(char [][] matriz){

        int filaMayor = 0;
        int filaActual = 0;
        int cantMayor = 0;
        int cantActual = 0;

        for(int fila = 0; fila < MAXF; fila++){

            filaActual = fila;
            cantActual = obtenerCantSecEnFila(matriz[fila]);

            if(cantActual > cantMayor){
                cantMayor = cantActual;
                filaMayor = filaActual;
            }
        }


        return filaMayor;
    }

    public static int obtenerCantSecEnFila(char [] fila){

        int inicio = 0;
        int fin = -1;
        int contador = 0;

        while(inicio < MAXC){
            inicio = obtener_inicio_sec_desde(fila, fin + 1);
            if(inicio < MAXC){
                fin = obtener_fin_sec_desde(fila, inicio);
                contador++;
            }
        }
        
        return contador;
    }

    public static int obtener_inicio_sec_desde(char [] fila, int fin){
        int i = fin;

        while(i < MAXC && esNumero(fila[i])){
            i++;
        }

        return i;
    }

    public static int obtener_fin_sec_desde(char [] fila, int inicio){
        int i = inicio;
        while(i < MAXC && !esNumero(fila[i])){
            i++;
        }
        return i - 1;
    }

    public static boolean esNumero(int elemento){
        if(elemento >= 'A' && elemento <= 'Z' && elemento >= 'a' && elemento <= 'z'){
            return false;
        }
        return true;
    }

    public static void mostrarMatriz(char [][] matriz){
        for (int f = 0; f < MAXF; f++) {
            for (int c = 0; c < MAXC; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }
}
