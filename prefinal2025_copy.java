public class prefinal2025_copy{

    public static final int MAXC = 39;
    public static final int MAXF = 4;

    public static void main(String[] args) {

        char[][] texto = {
                {'-','Y','o',' ','m','o','d','u','l','a','r','i','z','o',':','-','-','-','-','-','-','-','-',' ',' ',' ',' ',' ',' ',' ',' ','/','/','/','/','/','/','/','/'},
                {'¡','¡','p','e','r','o',' ','s','i',' ','n','o',' ','l','o',' ','h','a','g','o',',',' ',' ',' ',' ',' ',' ',' ',' ',' ','-','-','-','-','-',' ',' ',' ',' '},
                {' ','e','l',' ','c','a','o','s',' ','d','e',' ','m','i',' ','c','o','d','i','g','o','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'},
                {'¡','c','a','r','o',' ','l','o',' ','p','a','g','o','!','!','!','!','!','!','!','!','!','!','!','!','!','!','!',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
        };

        char[] arrC = {'p','m','l','p','t'}; // reemplazo de vocales.

        mostrarMatriz(texto);
        System.out.println("");

        procesarMatriz(texto, arrC);

        System.out.println("\nMatriz encriptada:");
        mostrarMatriz(texto);
    }

    public static void procesarMatriz(char[][] matriz, char[] arrC) {
        int menorCantidad = Integer.MAX_VALUE;
        int filaMenor = -1;

        for (int fila = 0; fila < MAXF; fila++) {
            int nroEncriptaciones = procesarFila(matriz[fila], arrC);
            if (nroEncriptaciones < menorCantidad) {
                menorCantidad = nroEncriptaciones;
                filaMenor = fila;
            }
        }

        System.out.println("\nLa fila con menor cantidad de palabras encriptadas fue: " + filaMenor);
    }

    public static int procesarFila(char[] fila, char[] arrC) {
        int inicio = 0;
        int fin = -1;
        int contador = 0;

        while (inicio < MAXC) {
            inicio = obtener_inicio_secuencia_desde(fila, fin + 1);
            fin = obtener_fin_secuencia(fila, inicio);
            // Solo procesar si hay letras válidas
            if (inicio <= fin) {
                procesarSecuencia(fila, inicio, fin, arrC);
                contador++;
            }
        }
        return contador;
    }

    public static void procesarSecuencia(char[] fila, int inicio, int fin, char[] arrC) {

        int finOriginal = fin;

        while (inicio <= fin) { //recorro sec de ini a fin.
            if (esVocal(fila[inicio])) {
                int id_vocal = indentificarVocal(fila[inicio]); // posición de la vocal en arrC
                corrimientoDer(fila, inicio + 1, arrC[id_vocal]); // inserto letra C
                corrimientoDer(fila, inicio + 2, fila[inicio]); // duplico la vocal
                fin += 2;
                inicio += 3; // saltar vocal y sus inserciones
            } else {
                inicio++;
            }
        }
    }

    public static boolean esVocal(char elemento) {
        return elemento == 'a' || elemento == 'A' || elemento == 'e' || elemento == 'E'
            || elemento == 'i' || elemento == 'I' || elemento == 'o' || elemento == 'O'
            || elemento == 'u' || elemento == 'U';
    }

    public static int indentificarVocal(char elemento) {
        if (elemento == 'a' || elemento == 'A') return 0;
        if (elemento == 'e' || elemento == 'E') return 1;
        if (elemento == 'i' || elemento == 'I') return 2;
        if (elemento == 'o' || elemento == 'O') return 3;
        if (elemento == 'u' || elemento == 'U') return 4;
        return -1;
    }

    public static int obtener_inicio_secuencia_desde(char[] arreglo, int desde) {
        int i = desde;
        while (i < MAXC && !esElementoValido(arreglo[i])) {
            i++;
        }
        return i;
    }

    public static int obtener_fin_secuencia(char[] arreglo, int inicio) {
        int i = inicio;
        while (i < MAXC && esElementoValido(arreglo[i])) {
            i++;
        }
        return i - 1;
    }

    public static boolean esElementoValido(char elemento) {
        return (elemento >= 'A' && elemento <= 'Z') || (elemento >= 'a' && elemento <= 'z');
    }

    public static void corrimientoDer(char[] fila, int ini, char elemento) {

        for (int i = MAXC - 1; i > ini; i--) {
            fila[i] = fila[i - 1];
        }
        fila[ini] = elemento;
    }

    public static void mostrarMatriz(char[][] matriz) {
        for (int f = 0; f < MAXF; f++) {
            for (int c = 0; c < MAXC; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }
}